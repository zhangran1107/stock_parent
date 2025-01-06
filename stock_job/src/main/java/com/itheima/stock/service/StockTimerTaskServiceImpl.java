package com.itheima.stock.service;

import com.google.common.collect.Lists;
import com.itheima.stock.mapper.StockBusinessMapper;
import com.itheima.stock.mapper.StockMarketIndexInfoMapper;
import com.itheima.stock.pojo.entity.StockMarketIndexInfo;
import com.itheima.stock.pojo.vo.StockInfoConfig;
import com.itheima.stock.utils.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockTimerTaskServiceImpl implements StockTimerTaskService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StockMarketIndexInfoMapper stockMarketIndexInfoMapper;

    @Autowired
    private StockBusinessMapper stockBusinessMapper;

    @Autowired
    private StockInfoConfig stockInfoConfig;

//    @Autowired
//    private IdWorker idWorker;


    @Override
    public void getInnerMarketInfo() {
        // String url="http://hq.sinajs.cn/list=sh000001,sz399001";
        String url = stockInfoConfig.getMarketUrl() + String.join(",", stockInfoConfig.getInner());
        //1.2维护请求头，防盗解和用户标识
        HttpHeaders headers = new HttpHeaders();
        //防盗链
        headers.add("Referer", "https://finance.sina.com.cn/stock/");
        //用户客户端标识
        //headers.add(  "User-Agent" , "Mozilla/5.0 (Windows NT 10.0; Win64; x64)

        //维护http请求实体对象
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        //发起请求
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        int statusCodevalue = responseEntity.getStatusCodeValue();
//        if (statusCodevalue!=200) {
//            //当前请求失败
//            log.error("当前时间点:{},采集数据失败,http状态码:{}" , DateTime.now().toString( " yyy-MM-dd AiH:m:ss" ),statusCodevalue);//其它:发送邮件企业微信钉钉等给相关运营人员提醒
//            return;
//
//        }

        String jsData = responseEntity.getBody();
        log.info("当前时间点:{},采集原姑数据内容:{}", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"), jsData);

        //2.1定义正则表达式
        String reg = "var hq_str_(.+)=\"(.+)\";";
        //2.2表达式编译
        Pattern pattern = Pattern.compile(reg);
        //2.3匹配字符串
        Matcher matcher = pattern.matcher(jsData);
        List<StockMarketIndexInfo> entities = new ArrayList<>();

        while (matcher.find()) {
            //1.获取大盘的编码
            String marketCode = matcher.group(1);//2.获取其它信息
            String otherInfo = matcher.group(2);//将other字符串以逗号切割，获取大片的详情信息
            String[] splitArr = otherInfo.split(" , ");
            //大盘名称
            String marketName = splitArr[0];//获取当前大盘的开盘点数
            BigDecimal openPoint = new BigDecimal(splitArr[1]);//前收盘点
            BigDecimal preclosePoint = new BigDecimal(splitArr[2]);//获取大盘的当前点数
            BigDecimal curPoint = new BigDecimal(splitArr[3]);//获取大盘最高点
            BigDecimal maxPoint = new BigDecimal(splitArr[4]);//获取大盘的最低点
            BigDecimal minPoint = new BigDecimal(splitArr[5]);
            //获取成交量
            Long tradeAmt = Long.valueOf(splitArr[8]);//获取成交金额
            BigDecimal tradeVol = new BigDecimal(splitArr[9]);
            Date curTime = DateTimeUtil.getDateTimeWithoutSecond(splitArr[30] + "" + splitArr[31]).toDate();
            StockMarketIndexInfo entity = StockMarketIndexInfo.builder()
                    .id(1L)
                    .marketName(marketName).openPoint(openPoint)
                    .preClosePoint(preclosePoint).curPoint(curPoint)
                    .maxPoint(maxPoint).minPoint(minPoint)
                    .tradeAmount(tradeAmt)
                    .tradeVolume(tradeVol)
                    .marketCode(marketCode)
                    .curTime(curTime)
                    .build();
            entities.add(entity);

        }
        log.info("解析大盘数据完毕!");
        //4.阶段4:调用mybatis批量入库
        int count = stockMarketIndexInfoMapper.insertBatch(entities);
        if (count > 0) {
            log.info("当前时间:{},插入数据:{}成功", DateTime.now().toString("yyy-MM-dd HH:mm:ss"), entities);
        } else {
            log.error("当前时间:{i},插入数据:}失败", DateTime.now().toString(" yyy-Mw-dd HH:mm:ss"), entities);

        }

    }


    @Override
    public void getStockRtIndex() {

        List<String> allCodes = stockBusinessMapper.getAllStockCodes();

        //添加大盘业务前缀sh sz
        allCodes=allCodes.stream().map(code->code.startsWith ("6")?"sh" +code:"sz"+code).collect(Collectors.toList());


        //将所有个股编码组成的大的集合拆分成若产小的集合40--->15 15 10
        Lists.partition(allCodes,15).forEach(codes->{
            String url=stockInfoConfig.getMarketUrl()+String.join("," , codes);


        });



    }






}
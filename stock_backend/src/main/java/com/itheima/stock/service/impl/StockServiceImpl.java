package com.itheima.stock.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.stock.mapper.StockMarketIndexInfoMapper;
import com.itheima.stock.mapper.StockRtInfoMapper;
import com.itheima.stock.pojo.domain.InnerMarketDomain;
import com.itheima.stock.pojo.domain.Stock4EvrDayDomain;
import com.itheima.stock.pojo.domain.Stock4MinuteDomain;
import com.itheima.stock.pojo.domain.StockUpdownDomain;
import com.itheima.stock.pojo.vo.StockInfoConfig;
import com.itheima.stock.service.StockService;
import com.itheima.stock.utils.DateTimeUtil;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.commons.collections4.CollectionUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockInfoConfig stockInfoConfig ;
    @Autowired
    private StockRtInfoMapper stockRtInfoMapper ;
    @Autowired
    private StockMarketIndexInfoMapper  stockMarketIndexInfoMapper;

    @Override
    public R<List<InnerMarketDomain>> getInnerMarketInfo() {
        //TODO 国内大盘实现
        //1.获取最新的股票交易时间点
        Date lastDate = DateTimeUtil.getLastDate4Stock(DateTime.now()).toDate();
        //TODO 伪造数据，后续删除
        lastDate=DateTime.parse("2022-01-03 09:47:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
        //2.获取国内大盘编码集合
        List<String> innerCodes = stockInfoConfig.getInner();
        //3.调用mapper查询
        List<InnerMarketDomain> infos= stockMarketIndexInfoMapper.getMarketInfo(lastDate,innerCodes);
        //4.响应
        return R.ok(infos);
    }

    @Override
    public R<PageResult<StockUpdownDomain>> getStockInfoByPage(Integer page, Integer pageSize) {
        //1.获取最新的股票交易时间
        Date curDate = DateTimeUtil.getLastDate4Stock(DateTime.now()).toDate();
        //TODO 伪造数据，后续删除
        curDate=DateTime.parse("2022-07-07 14:43:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
        //2.设置分页参数
        PageHelper.startPage(page,pageSize);
        //3.调用mapper查询数据
        List<StockUpdownDomain> pageData=stockRtInfoMapper.getStockInfoByTime(curDate);
        //判断数据是否为空

        PageInfo<StockUpdownDomain> pageInfo = new PageInfo<>(pageData);
        PageResult<StockUpdownDomain> pageResult = new PageResult<>(pageInfo);
        //4.响应数据
        return R.ok(pageResult);
    }
    @Override
    public R<Map<String,List>> getStockUpDownCount2(){
        DateTime curDateTime = DateTimeUtil.getLastDate4Stock(DateTime.now());

        //TODO 伪造数据，后续删除
        curDateTime=DateTime.parse( "2022-01-06 14:25:00",DateTimeFormat.forPattern("yyy-M-dd HH:mm:ss"));
        Date endDate = curDateTime.toDate();
        Date startDate=DateTimeUtil.getOpenDate(curDateTime).toDate();
        List<Map> upList=stockRtInfoMapper.getStockUpdownCount (startDate, endDate,1);
        List<Map> downList=stockRtInfoMapper.getStockUpdownCount (startDate, endDate,0);
        HashMap<String, List> info = new HashMap<>();
        info.put("upList", upList);
        info.put(" downList" , downList);
        return R.ok(info);


    }


    public R<Map<String, List>> getComparedStockTradeAmt() {
        //1.获取T日(最新股票交易日的日期范围)
        DateTime tEndDateTime = DateTimeUtil.getLastDate4Stock(DateTime.now());
        tEndDateTime=DateTime. parse(  "2022-01-03 14:40:00", DateTimeFormat . forPattern("yyyy-MM-dd HH:mm:ss"));
        Date tEndDate = tEndDateTime. toDate();

        //开盘时间
        Date tStartDate = DateTimeUtil. getOpenDate(tEndDateTime).toDate();
        //2.获取T-1日的时间范围

        DateTime preTEndDateTime = DateTimeUtil. getPreviousTradingDay(tEndDateTime);
        preTEndDateTime=DateTime.parse( "2022-01-02 14:40:00",DateTimeFormat . forPattern("yyyy-MM-dd HH:mm:ss"));

        Date preTEndDate = preTEndDateTime.toDate();
        //开盘时间
        Date tPreStartDate = DateTimeUtil. getOpenDate(preTEndDateTime).toDate();
        //3.调用Jmapper查询
        //3.1 统计T日
        List<Map> tData=stockMarketIndexInfoMapper.getSumAmtInfo(tStartDate , tEndDate, stockInfoConfig. getInner());
        //3.2统计T-1日.
        List<Map> preTData=stockMarketIndexInfoMapper.getSumAmtInfo(tPreStartDate, preTEndDate, stockInfoConfig. getInner());

        //4.组装数据
        HashMap<String,List> info = new HashMap<>();
        info. put("amtList", tData) ;
        info. put("yesAmtList" , preTData);
        //5.响应数据
        return R. ok(info);

    }

    @Override
    public R<Map> getIncreaseRangeInfo(){
        DateTime curDateTime = DateTimeUtil.getLastDate4Stock(DateTime.now());
        curDateTime=DateTime. parse(  "2022-01-06 09:55:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        Date curDate = curDateTime. toDate();
        List<Map> infos=stockRtInfoMapper. getIncreaseRangeInfoByDate(curDate);
        HashMap<String,Object> data = new HashMap<>();
        data.put ("time", curDateTime.toString("yyyy-MM-dd HH:mm:ss"));
        data.put("infos",infos);
        return R.ok(data);

    }

    @Override
    public R<List<Stock4MinuteDomain>> getStockScreenTimeSharing(String stockCode) {
    //1.获收T日1最新股票交易时间点endTime openTime
        DateTime endDateTime = DateTimeUtil. getLastDate4Stock(DateTime .now());
        endDateTime=DateTime.parse( "2021-12-30 14:30:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        Date endDate = endDateTime.toDate();
        Date openDate = DateTimeUtil. getOpenDate(endDateTime).toDate();
      //2.查的
        List<Stock4MinuteDomain> data=stockRtInfoMapper . getStock4MinuteInfo (openDate , endDate , stockCode);
      //3.返回
        return R. ok(data);
    }


    @Override
    public R<List<Stock4EvrDayDomain>> getStockScreenDkLine(String stockCode) {
        DateTime endDateTime = DateTimeUtil.getLastDate4Stock(DateTime.now());
        endDateTime = DateTime.parse("2022-12-30 14:30:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        Date endDate = endDateTime.toDate();

        DateTime startdateTime = endDateTime.minusMonths(3);
        startdateTime = DateTime.parse("2022-01-01 09:30:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));

        Date startDate = startdateTime.toDate();
        List<Stock4EvrDayDomain> dkLineData = stockRtInfoMapper.getStock4DKLine(startDate, endDate, stockCode);
        return R.ok(dkLineData);


    }




}

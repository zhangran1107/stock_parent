package com.itheima.stock.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.stock.mapper.LipstickMapper;
import com.itheima.stock.mapper.ToothPasteMapper;
import com.itheima.stock.pojo.domain.LipstickDomain;
import com.itheima.stock.pojo.domain.ToothpasteDomain;
import com.itheima.stock.service.LipstickSercive;
import com.itheima.stock.vo.req.LipstickReq;
import com.itheima.stock.vo.req.ToothpasteListReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LipstickServiceImpl implements LipstickSercive {

    @Autowired
    private LipstickMapper lipstickMapper ;

    @Override
    public R<PageResult<LipstickDomain>> getLipstickPage(LipstickReq req) {


        //2.设置分页参数
        //PageHelper.startPage(req.getPage(), req.getPageSize());
        //3.调用mapper查询数据
         int start=( (req.getPage()-1)*req.getPageSize() );
        List<LipstickDomain> pageData=lipstickMapper.getlipstickPage(req.getNames(),req.getProduce(),start, req.getPageSize());



        PageInfo<LipstickDomain> pageInfo = new PageInfo<>(pageData);
        //判断数据是否为空

         PageResult<LipstickDomain> pageResult = new PageResult<>(pageInfo);
        //4.响应数据
        return R.ok(pageResult);
    }

    public R<List<Integer>> getLipstickUpDownCount2(){
        Integer donprice=lipstickMapper.getLipstickUpDownCount(0,100);
        Integer donprice2=lipstickMapper.getLipstickUpDownCount(101,300);
        Integer donprice3=lipstickMapper.getLipstickUpDownCount(300,10000);
        List<Integer> zong= new ArrayList<>();
        zong.add(donprice);
        zong.add(donprice2);
        zong.add(donprice3);

        return R.ok(zong);

    }




}

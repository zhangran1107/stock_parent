package com.itheima.stock.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.stock.mapper.ToothPasteMapper;
import com.itheima.stock.pojo.domain.Stock4EvrDayDomain;
import com.itheima.stock.pojo.domain.Toothpaste222Domain;
import com.itheima.stock.pojo.domain.ToothpasteDomain;
import com.itheima.stock.pojo.domain.ToothpasteinformationDomain;
import com.itheima.stock.service.ToothpasteSercive;
import com.itheima.stock.utils.DateTimeUtil;
import com.itheima.stock.vo.req.ToothpasteListReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Service
public class ToothPasteServiceImpl implements ToothpasteSercive {


    @Autowired
    private ToothPasteMapper toothPasteMapper ;



    @Override
    public R<PageResult<ToothpasteDomain>> getToothpastePage(ToothpasteListReq req) {


        //2.设置分页参数
        PageHelper.startPage(req.getPage(), req.getPageSize());
        //3.调用mapper查询数据
        List<ToothpasteDomain> pageData=toothPasteMapper.getToothPasteByTime(req.getNames());

        //判断数据是否为空

        PageInfo<ToothpasteDomain> pageInfo = new PageInfo<>(pageData);
        PageResult<ToothpasteDomain> pageResult = new PageResult<>(pageInfo);
        //4.响应数据
        return R.ok(pageResult);
    }



    @Override
    public R<List<Toothpaste222Domain>> getToothPasteinformation() {


        List<ToothpasteinformationDomain> toothPaste = toothPasteMapper.getToothPaste();


        List<String> arrayList=new ArrayList();
        int aa=toothPaste.get(0).getZuigao();
        int bb=toothPaste.get(0).getZuigao();

        for(int i=0;i<toothPaste.size();i++){
                if (toothPaste.get(i).getZuigao()>aa){
                    aa=toothPaste.get(i).getZuigao();
                }
            if (toothPaste.get(i).getZuigao()<bb){
                bb=toothPaste.get(i).getZuigao();
            }

        }


        for(int i=0;i<toothPaste.size();i++){
            if(toothPaste.get(i).getZuigao()!=bb&&toothPaste.get(i).getZuigao()!=aa){
                arrayList.add(toothPaste.get(i).getName());
            }
        }




        List<Toothpaste222Domain> toothPaste2 = toothPasteMapper.getToothPaste2(arrayList);
        return R.ok(toothPaste2);


    }



    @Override
    public R<List<Toothpaste222Domain>> getToothPastehaolaimation() {


        List<ToothpasteinformationDomain> toothPaste = toothPasteMapper.getToothPaste3();
        List<Toothpaste222Domain> toothPaste2 = toothPasteMapper.getToothPaste4(toothPaste.get(0).getName());
        return R.ok(toothPaste2);


    }






}

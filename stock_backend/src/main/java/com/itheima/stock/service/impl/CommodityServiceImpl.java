package com.itheima.stock.service.impl;

import com.github.pagehelper.PageInfo;
import com.itheima.stock.mapper.CommodityMapper;
import com.itheima.stock.mapper.FruitMapper;
import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.service.CommoditySercive;
import com.itheima.stock.service.FruitSercive;
import com.itheima.stock.vo.req.CommodityReq;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommodityServiceImpl implements CommoditySercive {

    @Autowired
    private CommodityMapper commodityMapper ;



    //新项目

    @Override
    public R<Integer> insertCommodity(CommodityDomain commodity) {

      int a= commodityMapper.insertCommodity(commodity);


      return  R. ok(a);

    }


    @Override
    public R<Integer> deleteCommodityId( Integer id) {
        commodityMapper.deleteCommodityId(id);
        return  R. ok(id);

    }

    @Override
    public R<CommodityDomain> updateCommodity (CommodityDomain Commodity) {


        commodityMapper.updateCommodity(Commodity);
        return  R. ok(Commodity);

    }




    @Override
    public R<PageResult<CommodityDomain>> getCommodityPage(CommodityReq req) {



        if(req.getPage()==null){
            req.setPage(1);
        }
        if(req.getPageSize()==null){
            req.setPageSize(10);
        }



        int  start=( (req.getPage() -1)*req.getPageSize());
        List<CommodityDomain> pageData=commodityMapper.getCommodityPage( start, req.getPageSize());




        //判断数据是否为空

        PageInfo<CommodityDomain> pageInfo = new PageInfo<>(pageData);
        PageResult<CommodityDomain> pageResult = new PageResult<>(pageInfo);
        //4.响应数据
        return R.ok(pageResult);

    }



    @Override
    public R<PageResult<CommodityDomain>> getCommodityPage2(CommodityReq req) {



        if(req.getPage()==null){
            req.setPage(1);
        }
        if(req.getPageSize()==null){
            req.setPageSize(10);
        }

        if(req.getPageSize()==null){
            req.setBrandId(10);
        }



        int  start=( (req.getPage() -1)*req.getPageSize());
        List<CommodityDomain> pageData=commodityMapper.getCommodityPage2( start, req.getPageSize(),req.getBrandId());




        //判断数据是否为空

        PageInfo<CommodityDomain> pageInfo = new PageInfo<>(pageData);
        PageResult<CommodityDomain> pageResult = new PageResult<>(pageInfo);

        pageResult.setTotalRows(commodityMapper.getCommodityPage3(req.getBrandId()));

        int result= (int)Math.ceil(Double.valueOf(pageResult.getTotalRows())/pageResult.getPageSize());
        pageResult.setTotalPages(result);

        pageResult.setPageNum(req.getPage());
        pageResult.setPageSize(req.getPageSize());
        //4.响应数据
        return R.ok(pageResult);

    }




}

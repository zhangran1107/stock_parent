package com.itheima.stock.controller;

import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.service.CommoditySercive;
import com.itheima.stock.service.FruitSercive;
import com.itheima.stock.vo.req.CommodityReq;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/quot")
public class CommodityController {
    @Autowired
    //@Resource
    private CommoditySercive commoditySercive ;



    //新项目开端

    @PostMapping("/commodity/insert")
    public R<Integer> insertCommodity(@RequestBody CommodityDomain commodity){
        return  commoditySercive.insertCommodity(commodity);
    }


    @DeleteMapping("/commodity/deleteCommodityId")
    public R<Integer> deleteCommodityId(@RequestBody Integer id){
        return  commoditySercive.deleteCommodityId(id);

    }


    @PostMapping("/commodity/updateCommodity")
    public R<CommodityDomain> updateCommodity(@RequestBody CommodityDomain commodity){
        return  commoditySercive.updateCommodity(commodity);

    }

    @PostMapping("/commodity/all")
    public R<PageResult<CommodityDomain>> getCommodityPage(@RequestBody CommodityReq req){
        return  commoditySercive.getCommodityPage(req);

    }


    @PostMapping("/commodity/all2")
    public R<PageResult<CommodityDomain>> getCommodityPage2(@RequestBody CommodityReq req){
        return  commoditySercive.getCommodityPage2(req);

    }








}


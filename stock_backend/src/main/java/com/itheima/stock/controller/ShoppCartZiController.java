package com.itheima.stock.controller;

import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.pojo.vo.ShoppCartZiParam;
import com.itheima.stock.service.CommoditySercive;
import com.itheima.stock.service.ShoppCartZiSercive;
import com.itheima.stock.vo.req.CommodityReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/quot")
public class ShoppCartZiController {
    @Autowired

    private ShoppCartZiSercive shoppCartZiSercive ;

    @PostMapping("/ShoppCartZi/insert")
    public R<ShoppCartZiDomain> insertShoppCartZi(@RequestBody ShoppCartZiDomain shoppCart){
        return  shoppCartZiSercive.insertShoppCartZi(shoppCart);

    }

    @PostMapping("/ShoppCartZi/update")
    public R<ShoppCartZiDomain> updateShoppCartZi(@RequestBody ShoppCartZiParam shoppCartZiParam){
        return  shoppCartZiSercive.updateShoppCartZi(shoppCartZiParam);

    }












}


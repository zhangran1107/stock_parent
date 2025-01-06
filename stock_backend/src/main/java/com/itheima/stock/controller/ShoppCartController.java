package com.itheima.stock.controller;

import com.itheima.stock.pojo.domain.OrderZhuDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.pojo.vo.OrderZiParam;
import com.itheima.stock.pojo.vo.ShoppCartZiParam;
import com.itheima.stock.service.ShoppCartSercive;
import com.itheima.stock.vo.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/quot")
public class ShoppCartController {
    @Autowired

    private ShoppCartSercive shoppCartSercive;

//    @GetMapping("/ShoppCart/get")
//    public R<Integer> getShoppCart(@RequestParam("ShoppCart") Integer aa){
//        return  shoppCartSercive.getShoppCart(aa);
//
//    }

//    @PostMapping("/ShoppCart/insert")
//    public R<Integer> insertShoppCart(@RequestBody Integer bb){
//        return  shoppCartSercive.insertShoppCart(bb);
//    }
    //数据库里如果有相同的数据 那就修改数据库（增加）
    @PostMapping("/ShoppCartZi11/insert")
    public R<ShoppCartZiDomain> insertShoppCartZi(@RequestBody ShoppCartZiParam shoppCart)
    {
        return  shoppCartSercive.insertShoppCartZi(shoppCart);


    }


    //数据库里如果有相同的数据 那就修改数据库（减去）
    @PostMapping("/ShoppCartZijian/insert")
    public R<ShoppCartZiDomain> insertShoppCartZi2(@RequestBody ShoppCartZiParam shoppCart)
    {
        return  shoppCartSercive.deleteShoppCartZi2(shoppCart);


    }













}


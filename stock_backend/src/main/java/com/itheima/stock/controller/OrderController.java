package com.itheima.stock.controller;

import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.OrderZhuDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.pojo.vo.OrderZiParam;
import com.itheima.stock.pojo.vo.ShoppCartZiParam;
import com.itheima.stock.service.OrderSercive;
import com.itheima.stock.service.ShoppCartSercive;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.req.OrderReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/quot")
public class OrderController {
    @Autowired

    private OrderSercive orderSercive;

    //给order_zhu 里面增加数据
    @PostMapping("/Order/insert")
    public R<OrderZhuDomain> insertorderZhu(@RequestBody OrderZiParam orderZiParam)
    {
        return  orderSercive.insertOrderZhu(orderZiParam);


    }

    @PostMapping("/Order/all")
    public R<PageResult<OrderZhuDomain>> getStockInfoByPage(@RequestBody OrderReq req){
        return  orderSercive.getOrderPage(req);
    }



}


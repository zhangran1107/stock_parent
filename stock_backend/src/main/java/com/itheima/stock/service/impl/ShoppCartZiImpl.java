package com.itheima.stock.service.impl;

import com.github.pagehelper.PageInfo;
import com.itheima.stock.mapper.FruitMapper;
import com.itheima.stock.mapper.ShoppCartZiMapper;
import com.itheima.stock.mapper.ShoppingCartMapper;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.pojo.vo.ShoppCartZiParam;
import com.itheima.stock.service.FruitSercive;
import com.itheima.stock.service.ShoppCartZiSercive;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import com.itheima.stock.vo.resp.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShoppCartZiImpl implements ShoppCartZiSercive {

    @Autowired
    private ShoppCartZiMapper shoppCartZiMapper ;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper ;




    @Override
    public R<ShoppCartZiDomain> insertShoppCartZi(ShoppCartZiDomain fruit) {



        shoppCartZiMapper.insert(fruit);
        return  R. ok(fruit);

    }



    @Override
    public R<ShoppCartZiDomain> updateShoppCartZi(ShoppCartZiParam shoppCartZiParam) {

        //获取 shoppingCartId ID 从购物车主表
        Integer dd=shoppingCartMapper.getUserId(shoppCartZiParam.getUserId());
        //如果没找到
        if (dd==null){
            return R.error(ResponseCode.DATA_ERROR);
        }

        //在shopping_cart_zi 中 根据 shoppingCartId 和 commodityId 找到 shopping_cart_zi的id

        Integer aa=shoppCartZiMapper.getShoppCartZiid(shoppCartZiParam.getCommodityId(),dd);

        // 在shopping_cart_zi 表格中  传进去 数量 以及 shoppingCartId 进行修改

        ShoppCartZiDomain shoppCartZiDomain =new  ShoppCartZiDomain();
        shoppCartZiDomain.setId(aa);

        //在shopping_cart_zi 表格中 根据 shoppingCartId 和 commodityId  找到number

        Integer cc=shoppCartZiMapper.getnumberdan(shoppCartZiParam.getCommodityId(),aa);

        //得到的数量减去传进来的数量

        shoppCartZiDomain.setNumber(cc-shoppCartZiParam.getNumber());
        //如果减去的数量小于0，那么就把这条记录删掉
        if(shoppCartZiDomain.getNumber()<=0){
            shoppCartZiMapper.deleteData(aa);

        }

        shoppCartZiMapper.updateNumber(shoppCartZiDomain);
        return  R. ok(shoppCartZiDomain);

    }















}

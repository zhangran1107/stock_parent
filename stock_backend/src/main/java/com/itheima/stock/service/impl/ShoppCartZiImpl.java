package com.itheima.stock.service.impl;

import com.github.pagehelper.PageInfo;
import com.itheima.stock.mapper.FruitMapper;
import com.itheima.stock.mapper.ShoppCartZiMapper;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.service.FruitSercive;
import com.itheima.stock.service.ShoppCartZiSercive;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShoppCartZiImpl implements ShoppCartZiSercive {

    @Autowired
    private ShoppCartZiMapper shoppCartZiMapper ;




    @Override
    public R<ShoppCartZiDomain> insertShoppCartZi(ShoppCartZiDomain fruit) {



        shoppCartZiMapper.insert(fruit);
        return  R. ok(fruit);

    }

















}

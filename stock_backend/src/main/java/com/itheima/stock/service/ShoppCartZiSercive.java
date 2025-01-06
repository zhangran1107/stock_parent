package com.itheima.stock.service;

import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;

import java.util.List;

public interface ShoppCartZiSercive {

    R<ShoppCartZiDomain> insertShoppCartZi(ShoppCartZiDomain fruit);



}

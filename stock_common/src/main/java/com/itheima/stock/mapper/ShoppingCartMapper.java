package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.ShoppCartDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartMapper {

    Integer getUserId(Integer id);

    Integer insertShoppCart (ShoppCartDomain bb);



}

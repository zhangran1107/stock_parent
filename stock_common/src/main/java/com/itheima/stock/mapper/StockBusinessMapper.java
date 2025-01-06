package com.itheima.stock.mapper;

import com.itheima.stock.pojo.entity.StockBusiness;

import java.util.List;

/**
 * @Entity com.itheima.stock.pojo.entity.StockBusiness
 */
public interface StockBusinessMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockBusiness record);

    int insertSelective(StockBusiness record);

    StockBusiness selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockBusiness record);

    int updateByPrimaryKey(StockBusiness record);
    List<String> getAllStockCodes();

}

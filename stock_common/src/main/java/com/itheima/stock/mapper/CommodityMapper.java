package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CommodityMapper {




    //新项目

    int insertCommodity(CommodityDomain entities);

    int deleteCommodityId(@Param("id") Integer id);

    int updateCommodity(CommodityDomain entities);

    List<CommodityDomain> getCommodityPage( @Param("start") Integer start ,@Param("pageSize") Integer pageSize);
    List<CommodityDomain> getCommodityPage2( @Param("start") Integer start ,@Param("pageSize") Integer pageSize,
                                             @Param("brandId") Integer brandId);
    List<CommodityDomain> getCommodityprice(@Param("brandIds") List<Integer>brandIds );

    Long getCommodityPage3(Integer aa);

    List<CommodityDomain> getPrice (@Param("ids") List<Integer> ids);



}

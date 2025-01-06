package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.LipstickDomain;
import com.itheima.stock.pojo.entity.StockMarketIndexInfo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FruitMapper {

    List<FruitDomain> getfruitPage(@Param("names") List<String> names, @Param("produce") LocalDateTime produce,
                                  @Param("aa") Integer aa ,@Param("bb") Integer bb ,@Param("start") Integer start ,@Param("pageSize") Integer pageSize);
     FruitDomain getFruit2 (Integer id);


    int insert(FruitDomain entities);

    int insertBatch(@Param("fruit") List<FruitDomain> entities);

    int updateNameById(FruitDomain fruit);

    int updateName(FruitDomain fruit);

    int updateBatch(FruitDomain entities);

    int updateTrends(FruitDomain entities);

    int deleteById(@Param("id") Integer id);

    int deleteMultiple (@Param("ids") List<Integer> ids);

    int deleteName (@Param("names") List<String>names);



}

package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.LipstickDomain;
import com.itheima.stock.pojo.domain.ToothpasteDomain;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LipstickMapper {

    List<LipstickDomain>getlipstickPage(@Param("names") List<String> names,@Param("produce") LocalDateTime produce,
       @Param("start") int start ,@Param("pageSize") int pageSize);



    Integer getLipstickUpDownCount (@Param("startPrice") Integer startPrice,@Param("endPrice") Integer endPrice);



}

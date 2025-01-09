package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.OrderZhuDomain;
import com.itheima.stock.pojo.domain.ShoppCartDomain;
import com.itheima.stock.pojo.vo.OrderZiParam;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderMapper {


//    int insertOrder (OrderZiParam bb);


    Integer insertOrder2(OrderZhuDomain orderZhuDomain);

    List<OrderZhuDomain> getOrderPage( @Param("start") Integer start , @Param("pageSize") Integer pageSize);







}

package com.itheima.stock.service;

import com.itheima.stock.pojo.domain.OrderZhuDomain;
import com.itheima.stock.pojo.vo.OrderZiParam;
import com.itheima.stock.vo.resp.R;

public interface OrderSercive {



    R<OrderZhuDomain> insertOrderZhu (OrderZiParam orderZiParam);




}

package com.itheima.stock.service;

import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.pojo.vo.ShoppCartZiParam;
import com.itheima.stock.vo.resp.R;

public interface ShoppCartSercive {



    R<ShoppCartZiDomain> insertShoppCartZi(ShoppCartZiParam param);


    R<ShoppCartZiDomain> deleteShoppCartZi2(ShoppCartZiParam param);





}

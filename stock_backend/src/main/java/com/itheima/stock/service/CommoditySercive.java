package com.itheima.stock.service;

import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.vo.req.CommodityReq;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;

import java.util.List;

public interface CommoditySercive {


    R<Integer> insertCommodity(CommodityDomain commodity);

    R<Integer> deleteCommodityId( Integer id);

    R<CommodityDomain> updateCommodity( CommodityDomain fruit);

    R<PageResult<CommodityDomain>> getCommodityPage(CommodityReq req);

    R<PageResult<CommodityDomain>> getCommodityPage2(CommodityReq req);
}

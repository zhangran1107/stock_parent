package com.itheima.stock.service;

import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.LipstickDomain;
import com.itheima.stock.vo.req.CommodityReq;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.req.LipstickReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;

import java.util.List;

public interface FruitSercive {
    R<PageResult<FruitDomain>> getFruitPage(FruitReq req);
    R<FruitDomain> getfruitInfo(Integer aa);

    R<FruitDomain> insertFruit(FruitDomain fruit);

    R<List<FruitDomain>> insertFruit2 ( List<FruitDomain> fruit);

    R<FruitDomain> updateNameById( FruitDomain fruit);

    R<FruitDomain> updateName( FruitDomain fruit);

    R<List<FruitDomain>> updateBatch ( List<FruitDomain> fruit);

    R<FruitDomain> updateTrends( FruitDomain fruit);


    R<Integer> deleteById( Integer id);

    R<List<Integer>>deleteMultiple ( List<Integer>id);

    R<List<String>>deleteName ( List<String>name);


}

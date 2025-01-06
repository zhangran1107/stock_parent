package com.itheima.stock.service;

import com.itheima.stock.pojo.domain.LipstickDomain;
import com.itheima.stock.pojo.domain.ToothpasteDomain;
import com.itheima.stock.vo.req.LipstickReq;
import com.itheima.stock.vo.req.ToothpasteListReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;

import java.util.List;

public interface LipstickSercive {
    R<PageResult<LipstickDomain>> getLipstickPage(LipstickReq req);

    R<List<Integer>>getLipstickUpDownCount2();

}

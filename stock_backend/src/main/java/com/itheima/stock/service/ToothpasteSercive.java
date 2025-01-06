package com.itheima.stock.service;

import com.itheima.stock.pojo.domain.Stock4EvrDayDomain;
import com.itheima.stock.pojo.domain.Toothpaste222Domain;
import com.itheima.stock.pojo.domain.ToothpasteDomain;
import com.itheima.stock.pojo.domain.ToothpasteinformationDomain;
import com.itheima.stock.vo.req.ToothpasteListReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;

import java.util.List;

public interface ToothpasteSercive {


    R<PageResult<ToothpasteDomain>> getToothpastePage(ToothpasteListReq req);


    R<List<Toothpaste222Domain>> getToothPasteinformation();


    R<List<Toothpaste222Domain>> getToothPastehaolaimation();



}

package com.itheima.stock.service;

import com.itheima.stock.pojo.domain.InnerMarketDomain;
import com.itheima.stock.pojo.domain.Stock4EvrDayDomain;
import com.itheima.stock.pojo.domain.Stock4MinuteDomain;
import com.itheima.stock.pojo.domain.StockUpdownDomain;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;

import java.util.List;
import java.util.Map;

public interface StockService {
    R<List<InnerMarketDomain>> getInnerMarketInfo();

    R<PageResult<StockUpdownDomain>> getStockInfoByPage(Integer page, Integer pageSize);

    R<Map<String, List>> getStockUpDownCount2();

    R<Map<String, List>> getComparedStockTradeAmt();
    R<Map> getIncreaseRangeInfo();

    R<List<Stock4MinuteDomain>> getStockScreenTimeSharing(String stockCode);

    R<List<Stock4EvrDayDomain>> getStockScreenDkLine(String stockCode);
}
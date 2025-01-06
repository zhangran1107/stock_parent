package com.itheima.stock.controller;

import com.itheima.stock.pojo.domain.InnerMarketDomain;
import com.itheima.stock.pojo.domain.Stock4EvrDayDomain;
import com.itheima.stock.pojo.domain.Stock4MinuteDomain;
import com.itheima.stock.pojo.domain.StockUpdownDomain;
import com.itheima.stock.service.StockService;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(value="/api/quot",tags={"定义股票相关接口控制器"})
@RestController
@RequestMapping("/api/quot")
public class StockController {

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "获取国内大盘最新数据", notes = "获取国内大盘最新数据", httpMethod = "GET")
    @GetMapping("/index/all")
    public R<List<InnerMarketDomain>> getInnerMarketInfo() {
        return stockService.getInnerMarketInfo();

    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page", value = "当前页"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "每页大小")
    })
    @ApiOperation(value = "分页查询最新的股票交易数据", notes = "分页查询最新的股票交易数据", httpMethod = "GET")

    @GetMapping("/stock/all")
    public R<PageResult<StockUpdownDomain>> getStockInfoByPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                               @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
        return stockService.getStockInfoByPage(page, pageSize);
    }

    @GetMapping("/stock/updown/count")
    public R<Map<String, List>> getStockUpDownCount1hoh() {
        return stockService.getStockUpDownCount2();
    }

    @ApiOperation(value = "统计大盘T日和T-1日每分钟交易量的统计", notes = "统计大盘T日和T-1日每分钟交易量的统计", httpMethod = "GET")
    @GetMapping("/stock/tradeAmt")
    public R<Map<String, List>> getComparedStockTradeAmt() {
        return stockService.getComparedStockTradeAmt();
    }

    @ApiOperation(value = "统计最新交易时间点下股票(A股) 在各个涨幅区间的数量", notes = "统计最新交易时间点下股票(A股)")
    @GetMapping("/stock/updown")
    public R<Map> getIncreaseRangeInfo() {

        return stockService.getIncreaseRangeInfo();
    }


    @GetMapping("/stock/screen/time-sharing")
    public R<List<Stock4MinuteDomain>> getStockScreenTineSharing(@RequestParam(value = "code", required = true) String stockCode) {
        return stockService.getStockScreenTimeSharing(stockCode);


    }

    @GetMapping("/stock/screen/dkline")
    public R<List<Stock4EvrDayDomain>> getStockScreenDkLine(@RequestParam(value = "code", required = true) String stockCode) {
        return stockService.getStockScreenDkLine(stockCode);


    }
}
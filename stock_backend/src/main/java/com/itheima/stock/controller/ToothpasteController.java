package com.itheima.stock.controller;

import com.itheima.stock.pojo.domain.*;
import com.itheima.stock.service.StockService;
import com.itheima.stock.service.ToothpasteSercive;
import com.itheima.stock.vo.req.ToothpasteListReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="/api/quot",tags={"定义股票相关接口控制器"})
@RestController
@RequestMapping("/api/quot")
public class ToothpasteController {
    @Autowired
    private ToothpasteSercive toothpasteSercive;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page", value ="当前页"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value ="每页大小")
    })
    @ApiOperation(value ="分页查询最新的股票交易数据",notes = "分页查询最新的股票交易数据",httpMethod = "GET")

    @PostMapping("/toothPaste/all")
    public R<PageResult<ToothpasteDomain>> getStockInfoByPage(@RequestBody ToothpasteListReq req){
        return  toothpasteSercive.getToothpastePage(req);
    }


    @GetMapping("/toothPaste/information")
    public R<List<Toothpaste222Domain>> getToothPasteinformation() {
        return toothpasteSercive.getToothPasteinformation();


    }

    @GetMapping("/toothPaste/infonhaolai")
    public R<List<Toothpaste222Domain>> getToothPastehaolaimation() {
        return toothpasteSercive.getToothPastehaolaimation();


    }

}

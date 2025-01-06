package com.itheima.stock.controller;

import com.itheima.stock.pojo.domain.LipstickDomain;
import com.itheima.stock.pojo.domain.ToothpasteDomain;
import com.itheima.stock.service.LipstickSercive;
import com.itheima.stock.service.ToothpasteSercive;
import com.itheima.stock.vo.req.LipstickReq;
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
public class lipstickController {
    @Autowired
    private LipstickSercive lipstickSercive ;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page", value ="当前页"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value ="每页大小")
    })
    @ApiOperation(value ="分页查询最新的股票交易数据",notes = "分页查询最新的股票交易数据",httpMethod = "GET")

    @PostMapping("/lipstick/all")
    public R<PageResult<LipstickDomain>> getStockInfoByPage(@RequestBody LipstickReq req){
        return  lipstickSercive.getLipstickPage(req);
    }


    @GetMapping("/lipstick/updown/count")
    public  R<List<Integer>> getLipstickCount(){
       return lipstickSercive. getLipstickUpDownCount2();
    }
}

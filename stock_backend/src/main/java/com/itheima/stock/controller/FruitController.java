package com.itheima.stock.controller;

import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.LipstickDomain;
import com.itheima.stock.pojo.domain.ToothpasteDomain;
import com.itheima.stock.service.FruitSercive;
import com.itheima.stock.service.LipstickSercive;
import com.itheima.stock.service.ToothpasteSercive;
import com.itheima.stock.vo.req.CommodityReq;
import com.itheima.stock.vo.req.FruitReq;
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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(value="/api/quot",tags={"水果相关接口控制器"})
@RestController
@RequestMapping("/api/quot")
public class FruitController{
    @Autowired
    //@Resource
    private FruitSercive fruitSercive ;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page", value ="当前页"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value ="每页大小")
    })
    @ApiOperation(value ="分页查询最新的股票交易数据",notes = "分页查询最新的股票交易数据",httpMethod = "GET")
    @PostMapping("/fruit/all")
    public R<PageResult<FruitDomain>> getStockInfoByPage(@RequestBody FruitReq req){
        return  fruitSercive.getFruitPage(req);
    }

    @GetMapping("/fruit/get")
    public R<FruitDomain> getFruit(@RequestParam("id") Integer aa){
        return fruitSercive.getfruitInfo(aa);
    }


    @PostMapping("/fruit/insert")
    public R<FruitDomain> insertFruit(@RequestBody FruitDomain fruit){
        return  fruitSercive.insertFruit(fruit);
    }

    @PostMapping("/fruit/insertBatch")
    public R<List<FruitDomain>> insertFruit2(@RequestBody List<FruitDomain> fruit){
        return  fruitSercive.insertFruit2(fruit);

    }
    @PostMapping("/fruit/updateNameById")
    public R<FruitDomain> updateNameById(@RequestBody FruitDomain fruit){
        return  fruitSercive.updateNameById(fruit);

    }

    @PostMapping("/fruit/updateName")
    public R<FruitDomain> updateName(@RequestBody FruitDomain fruit){
        return  fruitSercive.updateName(fruit);

    }


    @PostMapping("/fruit/updateBatch")
    public R<List<FruitDomain>> updateBatch(@RequestBody List<FruitDomain> fruit){
        return  fruitSercive.updateBatch(fruit);

    }


    @PostMapping("/fruit/updateTrends")
    public R<FruitDomain> updateTrends(@RequestBody FruitDomain fruit){
        return  fruitSercive.updateTrends(fruit);

    }
    @DeleteMapping("/fruit/deleteById")
    public R<Integer> deleteById(@RequestBody Integer id){
        return  fruitSercive.deleteById(id);

    }

    @DeleteMapping("/fruit/deleteMultiple")
    public R<List<Integer>> deleteMultiple(@RequestBody List<Integer> id){
        return  fruitSercive.deleteMultiple(id);

    }

    @DeleteMapping("/fruit/deleteMultiple1")
    public R<List<Integer>> deleteMultiple1(@RequestBody List<FruitDomain> fruitDomains){
        List<Integer> ids = new ArrayList<>();
        for(FruitDomain fruitDomain : fruitDomains){
            ids.add(fruitDomain.getId());
        }
        return  fruitSercive.deleteMultiple(ids);

    }


    @DeleteMapping("/fruit/deleteName")
    public R<List<String>> deleteName(@RequestBody List<String> name){
        return  fruitSercive.deleteName(name);

    }












}


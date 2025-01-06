package com.itheima.stock;


import com.google.common.collect.Lists;
import com.itheima.stock.mapper.StockBusinessMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest

public class TestMapper {
    @Autowired
    private StockBusinessMapper stockBusinessMapper;

    @Test
    public void test01(){
        List<String> allCodes = stockBusinessMapper.getAllStockCodes();
        System.out.println(allCodes);
       //添加大盘业务前缀sh sz
        allCodes.stream().map(code->code.startsWith("6")?"sh"+code: "sz"+code).collect(Collectors.toList());
        System.out.println(allCodes) ;
        //将所有个股编码组成的大的集合拆分成若产小的集合40--->15 15 10
         Lists.partition(allCodes,15).forEach(codes->{
             System.out.println( "size : "+codes.size()+":"+codes);

         });

    }




}

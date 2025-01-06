package com.itheima.stock.pojo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("牙膏数据封装对象")
public class ToothpasteDomain {

    @ApiModelProperty("牙膏名字")
    private String name;

    @ApiModelProperty("牙膏克数")
    private int weight;

    @ApiModelProperty("牙膏功能")
    private String function;
    @ApiModelProperty("牙膏价格")
    private int price;

    @ApiModelProperty("牙膏口味")
    private String taste;




}

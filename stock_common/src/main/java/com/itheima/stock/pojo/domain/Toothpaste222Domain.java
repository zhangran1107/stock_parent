package com.itheima.stock.pojo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("牙膏数据封装对象")
public class Toothpaste222Domain {

    @ApiModelProperty("牙膏名字")
    private String name;

    @ApiModelProperty("牙膏价格")
    private Integer price;

    @ApiModelProperty("口味")
    private String taste;

    @ApiModelProperty("重量")
    private Integer weight;

    @ApiModelProperty("宣传语")
    private String function;




}

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
public class ToothpasteinformationDomain {

    @ApiModelProperty("牙膏名字")
    private String name;

    @ApiModelProperty("牙膏价格")
    private Integer zuigao;

    @ApiModelProperty("总数")
    private Integer geshu;




}

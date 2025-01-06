package com.itheima.stock.pojo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderZiDomain {
    private  Integer id;

    @ApiModelProperty("主表id")
    private  Integer orderZhuId;

    @ApiModelProperty("价格")
    private  Integer price;

    @ApiModelProperty("商品ID")
    private  Integer commodityId;


    @ApiModelProperty("数量")
    private Integer number;





}

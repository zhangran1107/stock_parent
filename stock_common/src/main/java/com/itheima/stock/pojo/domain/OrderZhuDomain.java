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
public class OrderZhuDomain {
    private  Integer id;

    @ApiModelProperty("购物车id")
    private  Integer userId;

    @ApiModelProperty("价格")
    private  Integer totalPrice;


    @ApiModelProperty("商品表格")
    private Date construct;





}

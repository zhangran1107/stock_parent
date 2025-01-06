package com.itheima.stock.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppCartZiParam {
    @ApiModelProperty("userId")
    private  Integer userId;


    @ApiModelProperty("商品表格")
    private  Integer commodityId;


    @ApiModelProperty("数量")
    private  Integer number;



}

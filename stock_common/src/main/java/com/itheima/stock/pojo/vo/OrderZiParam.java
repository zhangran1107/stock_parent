package com.itheima.stock.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderZiParam {
    @ApiModelProperty("userId")
    private  Integer userId;


    @ApiModelProperty("商品表格")
    private List<Integer> commodityId;



}

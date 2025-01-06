package com.itheima.stock.pojo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppCartDomain {
    @ApiModelProperty("主表id")
    private  Integer  id;
    @ApiModelProperty("userid")
    private  Integer userId;


}

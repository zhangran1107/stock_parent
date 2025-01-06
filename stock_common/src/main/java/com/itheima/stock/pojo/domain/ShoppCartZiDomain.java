package com.itheima.stock.pojo.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppCartZiDomain {
    private  Integer id;

    @ApiModelProperty("购物车id")
    private  Integer shoppingCartId;


    @ApiModelProperty("商品表格")
    private  Integer commodityId;


    @ApiModelProperty("数量")
    private  Integer number;



}

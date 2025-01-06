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
public class CommodityDomain {

    private  Integer id;

    private  Integer brandId;

    @ApiModelProperty("型号")
    private String model;

    @ApiModelProperty("价格")
    private int price;


    @ApiModelProperty("库存")
    private int inventory;

    @ApiModelProperty("真实库存")
    private int inventory2;


}

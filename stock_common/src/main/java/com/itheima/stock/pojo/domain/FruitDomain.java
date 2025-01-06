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
public class FruitDomain {

    private  Integer id;

    @ApiModelProperty("水果名字")
    private String name;

    @ApiModelProperty("水果价格")
    private int price;

    @ApiModelProperty("水果颜色")
    private String color;
    @ApiModelProperty("水果重量")
    private int weight;
    @ApiModelProperty("水果产地")
    private String producer;

    @ApiModelProperty("生产日期")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime produce;



}

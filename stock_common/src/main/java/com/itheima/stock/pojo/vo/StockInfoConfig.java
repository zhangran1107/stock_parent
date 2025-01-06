package com.itheima.stock.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix="stock")
public class StockInfoConfig {

    private List<String> inner;

    private List <String> outer;

    private List<String>upDownRange;

    @ApiModelProperty("大盘 外盘 个股的公共URL")
    private String marketUrl;

    @ApiModelProperty("板块采集URL")
    private String blockUrl;


}

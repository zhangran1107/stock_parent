package com.itheima.stock.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class FruitReq {




    @ApiModelProperty("第几页")
    private Integer page;

    @ApiModelProperty("每页几个")
    private Integer pageSize;

    @ApiModelProperty("时间")
    private LocalDateTime  produce;

    @ApiModelProperty("大于")
    private Integer  aa;

    @ApiModelProperty("小于")
    private Integer  bb;




    @ApiModelProperty("品牌名")
    private List<String> names;
}


package com.itheima.stock.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderReq {




    @ApiModelProperty("第几页")
    private Integer page;

    @ApiModelProperty("每页几个")
    private Integer pageSize;

    @ApiModelProperty("userId")
    private Integer userId;

}


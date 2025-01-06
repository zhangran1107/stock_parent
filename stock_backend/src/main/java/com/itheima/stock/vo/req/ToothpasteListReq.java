package com.itheima.stock.vo.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : itheima
 * @date : 2022/9/19 17:21
 * @description : 登录时请求参数封装vo-value object view-object
 */
@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class ToothpasteListReq {

    @ApiModelProperty("第几页")
    private Integer page;

    @ApiModelProperty("每页几个")
    private Integer pageSize;

    @ApiModelProperty("品牌名")
    private List<String> names;
//    private String rkey;


}

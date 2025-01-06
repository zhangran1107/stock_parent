package com.itheima.stock.vo.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
public class LoginReqVo {
    /**
     * 用户名
     */

    @JsonSerialize(using = ToStringSerializer.class)

    private Long id;
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("验证码")
    private String password;
    @ApiModelProperty("回话")
    private String code;
//    private String rkey;


}

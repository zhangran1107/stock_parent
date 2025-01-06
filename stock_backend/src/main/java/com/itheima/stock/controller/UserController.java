package com.itheima.stock.controller;

import com.itheima.stock.pojo.entity.SysUser;
import com.itheima.stock.service.UserService;
import com.itheima.stock.vo.req.LoginReqVo;
import com.itheima.stock.vo.resp.LoginRespVo;
import com.itheima.stock.vo.resp.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(tags="用户相关的接口处理器")
public class UserController {
    @Autowired
    private UserService userService;
        @ApiOperation(value="根据用户名查询用户信息")
        @GetMapping ("/user/{userName}/{kkk}")
        public SysUser getUserByUserName(@PathVariable("userName") String name,@PathVariable("kkk") String tt){
            return userService.findByUserName(name);
        }
        @ApiOperation(value="用户登录功能")
        @PostMapping("/login")
        public R<LoginRespVo> login(@RequestBody LoginReqVo vo){
           return userService.login(vo);
        }





}

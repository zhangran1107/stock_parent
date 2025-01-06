package com.itheima.stock.service.impl;

import com.itheima.stock.pojo.entity.SysUser;
import com.itheima.stock.service.UserService;
import com.itheima.stock.mapper.SysUserMapper;
import com.itheima.stock.vo.req.LoginReqVo;
import com.itheima.stock.vo.resp.LoginRespVo;
import com.itheima.stock.vo.resp.R;
import com.itheima.stock.vo.resp.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.findUserInfoByUserName(userName);
    }

    @Override
    public R<LoginRespVo> login(LoginReqVo vo) {
        if (vo == null || StringUtils.isBlank(vo.getUsername()) || StringUtils.isBlank(vo.getPassword())
                || StringUtils.isBlank(vo.getCode())) {
            return R.error(ResponseCode.DATA_ERROR);
        }

        SysUser dbUser = sysUserMapper.findUserInfoByUserName(vo.getUsername());
        if (dbUser == null) {
            return R.error(ResponseCode.ACCOUNT_EXISTS_ERROR);
        }

        if (!(passwordEncoder.matches(vo.getPassword(), dbUser.getPassword()))) {

            return R.error(ResponseCode.USERNAME_OR_PASSWORD_ERROR);
        }

        LoginRespVo respVo = new LoginRespVo();
//        respVo.setId(dbUser.getId());
//        respVo.setNickName(dbUser.getNickName());
        //我们发现respVo与dbUser下具有相同的属性，所以直接复制即可
        BeanUtils.copyProperties(dbUser, respVo);
        return R.ok(respVo);
    }

    private void process(LoginReqVo vo){
        if(vo.getPassword().length()>=6){
            vo.setPassword(vo.getPassword().substring(0, 6));
        }
    }
}

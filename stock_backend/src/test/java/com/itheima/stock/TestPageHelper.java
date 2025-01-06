package com.itheima.stock;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.stock.mapper.SysUserMapper;
import com.itheima.stock.pojo.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestPageHelper {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void test01(){
        Integer page=2;//当前页
        Integer pageSize=5;//每页大小
        PageHelper.startPage(page,pageSize);
        List<SysUser> all=sysUserMapper.findAll();
        //将查询的page对象封装到PageInfo下就可以获取分页的各种数据
        PageInfo<SysUser> pageInfo=new PageInfo<>(all);
        // 获取分页的详情数据
        int pageNum=pageInfo.getPageNum();//获取当前页

        int pages=pageInfo.getPages();//获取总页数

        int pageSize1=pageInfo.getPageSize();//每页大小
        int size =pageInfo.getSize();//当前页的纪录
        long total=pageInfo.getTotal();//总记录数
        List<SysUser> list =pageInfo.getList();//获取当前页的内容


    }

}

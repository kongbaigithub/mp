package com.hxl.mp;
import com.hxl.mp.order.enums.AgeEnum;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxl.mp.order.entity.TOrder1;
import com.hxl.mp.order.entity.Users;
import com.hxl.mp.order.enums.GradeEnum;
import com.hxl.mp.order.mapper.TOrder1Mapper;
import com.hxl.mp.order.service.ITOrder1Service;
import com.hxl.mp.order.service.IUsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class UserTest {

    @Resource
    IUsersService iUsersService;

    @Test
    public void testSave(){

        Users users = new Users();
        users.setName("张三");
        users.setGrade(GradeEnum.PRIMARY);
        users.setAge(AgeEnum.ONE);


        iUsersService.save(users);
    }

    @Test
    public void testGet(){
        Users users = iUsersService.getById(2);
        System.out.println(users);
    }
}

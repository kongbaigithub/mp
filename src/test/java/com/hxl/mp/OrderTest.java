package com.hxl.mp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxl.mp.order.entity.TOrder1;
import com.hxl.mp.order.mapper.TOrder1Mapper;
import com.hxl.mp.order.service.ITOrder1Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class OrderTest {

    @Resource
    TOrder1Mapper tOrder1Mapper;
    @Resource
    ITOrder1Service itOrder1Service;
    @Test
    public void testSelect(){
        TOrder1 tOrder1 = tOrder1Mapper.selectById(575467058469273600L);
        System.out.println(JSON.toJSONString(tOrder1));
    }

    @Test
    public void testSave(){
        TOrder1 tOrder1 = new TOrder1();
        tOrder1.setOrderId(575467059895336961L);
        tOrder1.setPrice(new BigDecimal("8.80"));
        tOrder1.setUserId(11L);
        tOrder1.setStatus("SUCCESS");
        tOrder1Mapper.insert(tOrder1);
        System.out.println(JSON.toJSONString(tOrder1));
    }
    @Test
    public void testSaveImpl(){
        TOrder1 tOrder1 = new TOrder1();
        tOrder1.setOrderId(575467059895336962L);
        tOrder1.setPrice(new BigDecimal("8.80"));
        tOrder1.setUserId(11L);
        tOrder1.setStatus("SUCCESS");
        itOrder1Service.save(tOrder1);
        System.out.println(JSON.toJSONString(tOrder1));
    }

    @Test
    public void testSaveBatch(){

        List<TOrder1> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            TOrder1 tOrder1 = new TOrder1();
            tOrder1.setOrderId(Long.valueOf(System.currentTimeMillis() + "" + new Random().nextInt(99999)));
            tOrder1.setPrice(new BigDecimal("9.90"));
            tOrder1.setUserId(Long.valueOf(i));
            tOrder1.setStatus("SUCCESS");
            list.add(tOrder1);
        }
        itOrder1Service.saveBatch(list,2);
    }

    @Test
    public void testSaveOrUpdate(){
        TOrder1 tOrder1 = new TOrder1();
        tOrder1.setOrderId(575467059895336962L);
        tOrder1.setPrice(new BigDecimal("8.81"));
//        tOrder1.setUserId(11L);
//        tOrder1.setStatus("SUCCESS");
        itOrder1Service.saveOrUpdate(tOrder1);
        System.out.println(tOrder1);
    }

    @Test
    public void testUpdateWrapper(){
        TOrder1 tOrder1 = new TOrder1();
//        tOrder1.setOrderId(575467059895336962L);
//        tOrder1.setPrice(new BigDecimal("8.81"));
        tOrder1.setUserId(14L);
//        tOrder1.setStatus("SUCCESS");

//        QueryWrapper<TOrder1> query = new QueryWrapper<>();
//        query.eq("price","8.81");

        LambdaQueryWrapper<TOrder1> query = new LambdaQueryWrapper<>();
        query.eq(TOrder1::getPrice,"8.81");
        itOrder1Service.saveOrUpdate(tOrder1,query);
    }


    @Test
    public void testRemove(){

        LambdaQueryWrapper<TOrder1> tWrapper = Wrappers.lambdaQuery();
        tWrapper.eq(TOrder1::getPrice,"3.00");
        itOrder1Service.remove(tWrapper);
    }
    @Test
    public void testRemoveById(){

        itOrder1Service.removeById(161759109399855365L);
    }

    @Test
    public void testUemoveByMap(){

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("order_id",161759109399859413L);
        itOrder1Service.removeByMap(stringObjectMap);
    }

    @Test
    public void testRemoveByIds(){

        List ids = new ArrayList<>();
        ids.add(161759109399841588L);
        ids.add(161759109399854178L);
        ids.add(161759109399872342L);
        itOrder1Service.removeByIds(ids);
    }

    @Test
    public void testUpdate(){

        LambdaUpdateWrapper<TOrder1> tWrapper = Wrappers.lambdaUpdate();
        tWrapper.eq(TOrder1::getPrice,"7.00").set(TOrder1::getUserId,11L);
        itOrder1Service.update(tWrapper);
    }

    @Test
    public void testUpdate2(){
        TOrder1 tOrder1 = new TOrder1();
        tOrder1.setUserId(15L);
        LambdaUpdateWrapper<TOrder1> tWrapper = Wrappers.lambdaUpdate();
        tWrapper.eq(TOrder1::getPrice,"8.80");
        itOrder1Service.update(tOrder1,tWrapper);
    }

    @Test
    public void testGet(){

        System.out.println(itOrder1Service.getById(575467061220737024L));
    }

    @Test
    public void testGetOne(){

        LambdaQueryWrapper<TOrder1> tWrapper = Wrappers.lambdaQuery();
        //sql选取最后一条
        tWrapper.eq(TOrder1::getPrice,"9.90").last("limit 1");
        itOrder1Service.getOne(tWrapper);
    }

    @Test
    public void testGetOne2(){

        LambdaQueryWrapper<TOrder1> tWrapper = Wrappers.lambdaQuery();
        tWrapper.eq(TOrder1::getPrice,"9.90");
        //不报错，选取第一条
        TOrder1 one = itOrder1Service.getOne(tWrapper, false);
        System.out.println(one);
    }

    @Test
    public void getMap(){
        LambdaQueryWrapper<TOrder1> tWrapper = Wrappers.lambdaQuery();
//        tWrapper.eq(TOrder1::getPrice,"7.00").
//        select(TOrder1::getOrderId,TOrder1::getPrice);
        tWrapper.eq(TOrder1::getPrice,"7.00").
        select(TOrder1.class,i->!i.getProperty().equals("price"));
        Map<String, Object> map = itOrder1Service.getMap(tWrapper);
        System.out.println(map);
    }

    @Test
    public void testList(){

        itOrder1Service.list();
    }

    @Test
    public void testList2(){

        LambdaQueryWrapper<TOrder1> tWrapper = Wrappers.lambdaQuery();
        tWrapper.eq(TOrder1::getPrice,"9.90");
        itOrder1Service.list(tWrapper);
    }

    @Test
    public void testListByIds(){

        List ids = new ArrayList<>();
        ids.add(161759109399814783L);
        ids.add(161759112814878110L);
        itOrder1Service.listByIds(ids);
    }

    @Test
    public void testListByMap(){

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("order_id",161759109399814783L);
        itOrder1Service.listByMap(stringObjectMap);
    }

    @Test
    public void testListMap(){

        System.out.println(itOrder1Service.listMaps());
    }

    @Test
    public void testListObjs(){
        //obj数组，只有id
        System.out.println(itOrder1Service.listObjs());
    }

    @Test
    public void testPage(){
        Page<TOrder1> page = itOrder1Service.page(new Page<>(1, 5));
        System.out.println(page.getRecords());
    }

    @Test
    public void testPage2(){
        LambdaQueryWrapper<TOrder1> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(TOrder1::getPrice,"9.90");
        Page<TOrder1> page = itOrder1Service.page(new Page<>(1, 5),lambdaQuery);
        System.out.println(page.getRecords());
    }

    @Test
    public void testPageMap(){

        Page<Map<String, Object>> mapPage = itOrder1Service.pageMaps(new Page<>(1, 5));
        System.out.println(mapPage.getRecords());
    }

    @Test
    public void testCount(){

        System.out.println(itOrder1Service.count());

        LambdaQueryWrapper<TOrder1> tWrapper = Wrappers.lambdaQuery();
        tWrapper.eq(TOrder1::getPrice,"9.90");
        itOrder1Service.count(tWrapper);
    }
}

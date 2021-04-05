package com.hxl.mp.order.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum AgeEnum implements IEnum<Integer> {
    ONE(1, "一岁"),
    TWO(2, "二岁"),
    THREE(3, "三岁")
    ;

    private int  age;
    private String desc;

    AgeEnum(int age, String desc) {
        this.age = age;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return age;
    }
}

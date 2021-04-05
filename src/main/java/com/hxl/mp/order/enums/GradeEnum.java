package com.hxl.mp.order.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum GradeEnum {
    PRIMARY(1, "小学"),
    SECONDORY(2, "中学"),
    HIGH(3, "高中")
    ;

    @EnumValue
    private Integer code;
    private String desc;

    GradeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}

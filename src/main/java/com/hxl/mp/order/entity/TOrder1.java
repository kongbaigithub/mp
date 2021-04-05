package com.hxl.mp.order.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_Order_1")
public class TOrder1 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */

    @TableId("order_id")
    private Long orderId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 下单用户ID
     */
    private Long userId;

    /**
     * 订单状态
     */
    private String status;


}

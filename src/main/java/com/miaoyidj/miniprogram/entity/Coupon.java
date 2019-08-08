package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Coupon
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 11:53
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon implements Serializable {
    private static final long serialVersionUID = -8506236228030464387L;
    private Integer cId;
    private String cName;
    private BigDecimal cValue;
    private int cStatus;
    private String cAging;
    private int cStandard;
}

package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Miaoyiorder
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/23 12:45
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Miaoyiorder implements Serializable {
    private static final long serialVersionUID = -3555943758225550190L;
    private Integer oId;
    private String oNumber;
    private int aId;
    private int pId;
    private int uId;
    private BigDecimal oTotalPrice;
    private BigDecimal oPayPrice;
    private String oUserMessage;
    private String oCreateTime;
    private String oPayTime;
    private String oDeliveryTime;
    private String oConfirmTime;
    private int oStatus;
    private String oSubscribeTime;
}

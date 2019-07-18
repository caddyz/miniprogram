package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Order
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 12:05
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 7041351652742170781L;
    private Integer oId;
    private int oNumber;
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

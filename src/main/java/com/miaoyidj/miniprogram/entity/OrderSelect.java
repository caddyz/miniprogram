package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName OrderSelect
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/18 9:06
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSelect implements Serializable {
    private static final long serialVersionUID = -3151296887240016093L;
    private Integer oId;
    private String oNumber;
    private BigDecimal oTotalPrice;
    private BigDecimal oPayPrice;
    private String oUserMessage;
    private String oCreateTime;
    private int oStatus;
    private String oSubscribeTime;
    private Address address;
    private Product product;

}

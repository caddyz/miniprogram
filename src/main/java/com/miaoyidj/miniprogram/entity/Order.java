package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
    private int oId;
    private int oNumber;
    private int aId;
    private int uId;
    private String oMobile;
    private String oUserMessage;
    private String oCreateTime;
    private String oPayTime;
    private String oDeliveryTime;
    private String oConfirmTime;
    private int oStatus;
}

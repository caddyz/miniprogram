package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName UserCoupon
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/18 10:31
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCoupon implements Serializable {
    private static final long serialVersionUID = 3966334130722709320L;
    private Integer ucId;
    private User user;
    private Coupon coupon;
    private String ucMobile;
    private boolean ucStatus;
}

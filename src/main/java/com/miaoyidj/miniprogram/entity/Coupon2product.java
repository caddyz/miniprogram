package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.entity
 * @ClassName: Coupon2product
 * @Author: Kaiser
 * @Description: 优惠券控制
 * @Date: 2019-08-01 17:34
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon2product implements Serializable {
    private static final long serialVersionUID = 2920197480472497409L;
    private Integer cpId;
    private Integer cId;
    private Integer pId;
}

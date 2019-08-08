package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.entity
 * @ClassName: MemberOrder
 * @Author: Kaiser
 * @Description: 会员订单
 * @Date: 2019-08-08 10:57
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberOrder implements Serializable {
    private static final long serialVersionUID = -6705032871939514269L;
    private Integer mId;
    private String mOrderNo;
    private Integer uId;
    private BigDecimal mTotalFee;
    private BigDecimal mPayFee;
    private String mCreateTime;
    private String mPayTime;
    private boolean mStatus;
}

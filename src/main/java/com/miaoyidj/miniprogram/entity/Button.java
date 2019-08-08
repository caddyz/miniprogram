package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.entity
 * @ClassName: Button
 * @Author: Kaiser
 * @Description: 会员充值按钮
 * @Date: 2019-08-01 17:07
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Button implements Serializable {
    private static final long serialVersionUID = 2684917692300050077L;
    private Integer bId;
    private int bBase;
    private int bGive;
    private String bRemark;
}

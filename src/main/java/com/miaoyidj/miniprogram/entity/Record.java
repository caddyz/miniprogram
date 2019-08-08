package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.entity
 * @ClassName: Record
 * @Author: Kaiser
 * @Description: record实体类
 * @Date: 2019-08-01 15:49
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record implements Serializable {
    private static final long serialVersionUID = 1602726790026915045L;
    private Integer rId;
    private Integer uId;
    private BigDecimal rNumber;
    private String rTime;
    private boolean rStatus;
}

package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.entity
 * @ClassName: Usepoints
 * @Author: Kaiser
 * @Description: 可用积分
 * @Date: 2019-08-01 22:59
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usepoints implements Serializable {
    private static final long serialVersionUID = -273844314655424490L;
    private Integer upId;
    private Integer uId;
    private int upValue;
    private String upCreatetime;
    private String upOverduetime;
}

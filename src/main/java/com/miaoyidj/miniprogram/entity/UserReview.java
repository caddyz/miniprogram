package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName UserReview
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/18 11:56
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReview implements Serializable {
    private static final long serialVersionUID = -3461265538921975263L;
    private Integer rId;
    private int rRate;
    private String rContent;
    private String rReviewTime;
    private User user;
}

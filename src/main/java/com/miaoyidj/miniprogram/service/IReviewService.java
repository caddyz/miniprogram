package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Review;
import com.miaoyidj.miniprogram.entity.UserReview;

import java.util.List;

/**
 * @ClassName IReviewService
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:19
 * @Version 1.0
 **/
public interface IReviewService extends IService<Review> {
    /**
     *  获取最新评价
     * @return
     */
    Review getLastReview();

    /**
     *  获取所有评价
     * @return
     */
    List<UserReview> getAllReview();
}

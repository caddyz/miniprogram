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
    UserReview getLastReview();

    /**
     *  根据Id查询评论
     * @param productId 产品Id
     * @return
     */
    List<UserReview> getAllReview(String productId);
}

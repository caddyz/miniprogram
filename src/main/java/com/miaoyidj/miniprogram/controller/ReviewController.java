package com.miaoyidj.miniprogram.controller;

import com.miaoyidj.miniprogram.entity.Review;
import com.miaoyidj.miniprogram.service.IReviewService;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import com.miaoyidj.miniprogram.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ReviewController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/17 18:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private IReviewService reviewService;

    /**
     * 获取最新评论
     * @return
     */
    @GetMapping("/getLastReview")
    public JsonData getLastReview(){
        return GetResult.result(reviewService.getLastReview());
    }

    /**
     *  获取所有评论
     * @return
     */
    @GetMapping("/getAllReview")
    public JsonData getAllReview(){
        return GetResult.result(reviewService.getAllReview());
    }

    /**
     *  新增评论
     * @param userId 用户id
     * @param reviewContent 评论内容
     * @param reviewRate 评分
     * @return
     */
    @GetMapping("/addReview")
    public JsonData addReview(int userId,String reviewContent,int reviewRate){
        Review review = new Review(null,reviewRate,reviewContent, TimeUtil.getCurrentTime(),userId);
        return GetResult.boReturn(reviewService.save(review));
    }
}

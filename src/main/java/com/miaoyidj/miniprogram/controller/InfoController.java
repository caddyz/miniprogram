package com.miaoyidj.miniprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.miaoyidj.miniprogram.entity.Miaoyirules;
import com.miaoyidj.miniprogram.entity.Record;
import com.miaoyidj.miniprogram.service.IButtonService;
import com.miaoyidj.miniprogram.service.IMiaoyirulesService;
import com.miaoyidj.miniprogram.service.IRecordService;
import com.miaoyidj.miniprogram.service.IUsepointsService;
import com.miaoyidj.miniprogram.util.Constant;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.controller
 * @ClassName: InfoController
 * @Author: Kaiser
 * @Description: 获取积分规则、会员充值等控制器
 * @Date: 2019-08-01 19:48
 * @Version: 1.0
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private IButtonService buttonService;
    @Autowired
    private IMiaoyirulesService miaoyirulesService;
    @Autowired
    private IUsepointsService usepointsService;
    @Autowired
    private IRecordService recordService;

    /**
     *  获取充值规则
     * @return
     */
    @GetMapping("/getMemberButton")
    public JsonData getMemberButton(){
        return GetResult.result(buttonService.getAllButton());
    }

    /**
     *  获取积分规则
     * @return
     */
    @GetMapping("/getPointsRules")
    public JsonData getPointsRules(){
        return GetResult.result(miaoyirulesService.getOne(new QueryWrapper<Miaoyirules>().eq("r_id",Constant.SUCCESS_CODE)));
    }

    @Scheduled(cron = "0 0 0 1/1 * ? ")
    public void checkOverdue(){
        usepointsService.checkOverdue();

    }

    @GetMapping("/getConsumeRecord")
    public JsonData consumeRecord(String userId){
        return GetResult.result(recordService.list(new QueryWrapper<Record>().eq("u_id",userId)));
    }

}

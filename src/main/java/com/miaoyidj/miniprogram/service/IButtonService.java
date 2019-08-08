package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Button;

import java.util.List;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service
 * @ClassName: IButtonService
 * @Author: Kaiser
 * @Description: button接口
 * @Date: 2019-08-01 17:10
 * @Version: 1.0
 */
public interface IButtonService extends IService<Button> {
    /**
     * 获取所以button
     * @return
     */
    List<Button> getAllButton();
}

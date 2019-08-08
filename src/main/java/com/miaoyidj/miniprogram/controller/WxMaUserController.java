package com.miaoyidj.miniprogram.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.miaoyidj.miniprogram.config.WxMaConfiguration;
import com.miaoyidj.miniprogram.util.JsonUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WxMaUserController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/21 20:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/wx/user")
public class WxMaUserController {
    @GetMapping("/login")
    public String login(String appid,String code){
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            return JsonUtil.toJson(session);
        } catch (WxErrorException e) {
            return e.toString();
        }
    }
}

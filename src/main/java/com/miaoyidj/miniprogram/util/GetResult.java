package com.miaoyidj.miniprogram.util;


import java.util.List;

/**
 * @ClassName: GetResult
 * @Description: TODO
 * @Author: Kaiser
 * @Date: 2019/5/10 11:16
 * @Version: 1.0
 */
public class GetResult {
    public static JsonData result(List list){
        if (list.isEmpty()){
            return new JsonData(null,"获取失败",Constant.FAIL_CODE,false);
        }
        return new JsonData(list,"成功获取",Constant.SUCCESS_CODE,true);
    }

    public static JsonData result(Object obj) {
        if (obj == null) {
            return new JsonData(null,"返回空",Constant.FAIL_CODE,false);
        }
        return new JsonData(obj,"成功获取",Constant.SUCCESS_CODE,true);
    }

    public static JsonData boReturn(boolean bo){
        if (bo) {
            return new JsonData(null,"success",Constant.SUCCESS_CODE,bo);
        }
        return new JsonData(null,"fail", Constant.FAIL_CODE,bo);
    }
}

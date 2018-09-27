package com.yf.provider.common

import com.alibaba.android.arouter.launcher.ARouter
import com.yf.base.common.BaseConstant
import com.yf.base.utils.AppPrefsUtils
import com.yf.provider.router.RouterPath


//provider层 提供业务相关 的东西
fun isLogined():Boolean{

    return true;
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}


/*
    如果已经登录，进行  传入的方法  处理
    若没有登录，进入登录界面
 */
fun afterLogin(method:()->Unit){
    if (isLogined()){
        method()
    }else{
        ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()
    }
}
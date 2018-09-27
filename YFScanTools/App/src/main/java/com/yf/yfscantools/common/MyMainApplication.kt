package com.yf.yfscantools.common

//import cn.jpush.android.api.JPushInterface
import com.yf.base.common.BaseApplication

class MyMainApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
        //JPushInterface.setDebugMode(true)
        //JPushInterface.init(this)
    }
}
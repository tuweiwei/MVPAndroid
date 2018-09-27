package com.yf.message.provider

import android.content.Context
//import cn.jpush.android.api.JPushInterface
import com.alibaba.android.arouter.facade.annotation.Route
import com.yf.provider.PushProvider
import com.yf.provider.router.RouterPath

/*
    模块间接口调用
    提供PushId的实现
 */
@Route(path = RouterPath.MessageCenter.PATH_MESSAGE_PUSH)
class PushProviderImpl: PushProvider {
    override fun getPushId(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun init(context: Context?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    private var mContext:Context? = null
////    override fun getPushId(): String {
////        //return JPushInterface.getRegistrationID(mContext)
////    }
//
//    override fun init(context: Context?) {
//        mContext = context
//    }
}

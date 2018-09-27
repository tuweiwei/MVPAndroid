package com.yf.usercenter.utils

import com.yf.base.common.BaseConstant
import com.yf.base.utils.AppPrefsUtils
import com.yf.provider.common.ProviderConstant
import com.yf.usercenter.data.protocol.UserInfo

object  UserPrefsUtils {
    /*
       退出登录时，传入null,清空存储
    */
    fun putUserInfo(userInfo: UserInfo?) {
        //用户名
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_NAME, userInfo?.username ?: "")

        //密码
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_SIGN, userInfo?.password ?: "")
    }
}
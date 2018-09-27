package com.yf.usercenter.presenter.view

import com.yf.base.presenter.view.BaseView
import com.yf.usercenter.data.protocol.UserInfo

interface UserInfoView : BaseView {
    /*
       获取上传凭证回调
    */
    fun onGetUploadTokenResult(result:String)

    /*
        编辑用户资料回调
     */
    fun onEditUserResult(result: UserInfo)
}
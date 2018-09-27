package com.yf.usercenter.presenter.view

import com.yf.base.presenter.view.BaseView
import com.yf.usercenter.data.protocol.UserInfo

interface LoginView :BaseView {
    fun onLoginResult(result:UserInfo)
}
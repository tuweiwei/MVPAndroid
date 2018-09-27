package com.yf.usercenter.presenter

import com.yf.base.ext.excute
import com.yf.base.presenter.BasePresenter
import com.yf.base.rx.BaseSubscriber
import com.yf.usercenter.data.protocol.UserInfo
import com.yf.usercenter.presenter.view.LoginView
import com.yf.usercenter.presenter.view.RegisterView
import com.yf.usercenter.service.UserService
import javax.inject.Inject


//登录界面 presenter 调用业务处理
class LoginPresenter @Inject constructor() :BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    fun login(username :String , password: String){

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.login(username, password).excute(object : BaseSubscriber<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                mView.onLoginResult(t)
            }
        }, lifecycleProvider)
    }
}
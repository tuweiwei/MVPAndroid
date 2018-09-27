package com.yf.usercenter.presenter

import com.yf.base.presenter.BasePresenter
import com.yf.usercenter.presenter.view.RegisterView

class RegisterPresenter:BasePresenter<RegisterView>() {

    fun register(username :String , password: String){


        mView.onRegisterResult("success")
    }
}
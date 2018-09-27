package com.yf.usercenter.presenter

import com.kotlin.user.service.UploadService
import com.yf.base.ext.excute
import com.yf.base.presenter.BasePresenter
import com.yf.base.rx.BaseSubscriber
import com.yf.usercenter.data.protocol.UserInfo
import com.yf.usercenter.presenter.view.UserInfoView
import com.yf.usercenter.service.UserService
import javax.inject.Inject

class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var uploadService: UploadService

    /*
        获取七牛云上传凭证
     */
    fun getUploadToken(){
        if (!checkNetWork())
            return

        mView.showLoading()
        uploadService.getUploadToken().excute(object : BaseSubscriber<String>(mView){
            override fun onNext(t: String) {
                mView.onGetUploadTokenResult(t)
            }
        },lifecycleProvider)
    }

    /*
        编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String){
        if (!checkNetWork())
            return

        mView.showLoading()
        userService.editUser(userIcon,userName,userGender,userSign).excute(object :BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                mView.onEditUserResult(t)
            }
        },lifecycleProvider)
    }

}
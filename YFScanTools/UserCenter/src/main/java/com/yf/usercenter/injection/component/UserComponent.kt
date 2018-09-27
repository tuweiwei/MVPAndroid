package com.yf.usercenter.injection.component

import com.yf.base.injection.PerComponentScope
import com.yf.base.injection.component.ActivityComponent
import com.yf.user.injection.module.UploadModule
import com.yf.user.ui.activity.UserInfoActivity
import com.yf.usercenter.injection.module.UserModule
import com.yf.usercenter.ui.activity.LoginActivity
import dagger.Component



@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class,UploadModule::class))

interface UserComponent {
    fun inject(activity: LoginActivity)
    fun inject(activity: UserInfoActivity)
}
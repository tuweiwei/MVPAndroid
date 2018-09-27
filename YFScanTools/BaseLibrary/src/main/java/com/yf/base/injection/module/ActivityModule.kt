package com.yf.base.injection.module

import android.app.Activity
import com.yf.base.injection.ActivityScope
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity: Activity) {

    //作用域并无实际的功能  只是一种分层形式上的意义 如Singleton作用域并无单例的功能
    //若要实现单例的功能需借助全局对象  Application
    //ActivityScope代表 提供Actity对象时 是activity级别  不是单例级别

    @ActivityScope
    @Provides
    fun provideActivity():Activity{
        return this.activity
    }

}
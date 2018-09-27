package com.yf.base.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context:Context) {

    //由于借助了Application 对象 此处提供注入的对象是单例 所有用了 @Singleton标注
    //单纯用 @Singleton 无效果
    @Provides
    @Singleton
    fun provideContext():Context{
        return this.context
    }
}
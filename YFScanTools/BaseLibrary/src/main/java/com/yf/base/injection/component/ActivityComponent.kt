package com.yf.base.injection.component

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import com.trello.rxlifecycle.LifecycleProvider
import com.yf.base.injection.ActivityScope
import com.yf.base.injection.module.ActivityModule
import com.yf.base.injection.module.LifecycleProviderModule
import dagger.Component


@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class, LifecycleProviderModule::class))
interface ActivityComponent {

    //Component作为 注入的中间桥梁， 依赖于Appcomponet， 自身提供 activity 和 lifecycleProvider的注入
    //其中提供的context是全局单例的
    fun  context(): Context
    fun  activity(): Activity
    fun  lifecycleProvider(): LifecycleProvider<*>
}
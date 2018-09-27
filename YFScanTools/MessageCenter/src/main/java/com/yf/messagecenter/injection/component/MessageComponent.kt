package com.yf.message.injection.component


import com.yf.base.injection.PerComponentScope
import com.yf.base.injection.component.ActivityComponent
import com.yf.message.injection.module.MessageModule
import com.yf.message.ui.fragment.MessageFragment
import com.yf.messagecenter.ui.activity.EquipItemCheck
import dagger.Component

/*
    消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(MessageModule::class))
interface MessageComponent{
    fun inject(fragment: MessageFragment)
    fun inject(activity: EquipItemCheck)
}

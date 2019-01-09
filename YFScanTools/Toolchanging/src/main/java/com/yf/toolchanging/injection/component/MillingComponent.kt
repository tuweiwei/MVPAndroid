package com.yf.milling.injection.component

import com.yf.base.injection.PerComponentScope
import com.yf.base.injection.component.ActivityComponent
import com.yf.milling.injection.module.MillingModule
import com.yf.milling.ui.activity.UploadDataActivity
import com.yf.milling.ui.fragment.RightAddFragment
import com.yf.milling.ui.fragment.RightQueryFragment

import dagger.Component



@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(MillingModule::class))

interface MillingComponent {
    fun inject(activity: UploadDataActivity)
    fun inject(fragment: RightAddFragment)
    fun inject(fragment: RightQueryFragment)
}
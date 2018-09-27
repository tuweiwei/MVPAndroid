package com.yf.base.injection.component

import android.content.Context
import com.yf.base.injection.module.AppModule
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {
    fun context():Context
}
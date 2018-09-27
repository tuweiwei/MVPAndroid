package com.yf.usercenter.injection.module

import com.yf.usercenter.service.UserService
import com.yf.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }
}
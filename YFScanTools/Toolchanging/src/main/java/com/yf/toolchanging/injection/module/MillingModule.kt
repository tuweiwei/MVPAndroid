package com.yf.milling.injection.module

import com.yf.milling.service.impl.MillingServiceImpl
import com.yf.milling.service.MillingService
import dagger.Module
import dagger.Provides

@Module
class MillingModule {

    @Provides
    fun provideUserService(millingService: MillingServiceImpl): MillingService {
        return millingService
    }
}
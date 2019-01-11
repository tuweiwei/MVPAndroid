package com.yf.milling.service.impl

import com.yf.base.ext.convert
import com.yf.base.ext.convertBoolean
import com.yf.milling.data.protocol.MillingInfo
import com.yf.milling.data.repository.MillingRepository
import com.yf.milling.service.MillingService
import rx.Observable
import javax.inject.Inject

//提供注入
class MillingServiceImpl @Inject constructor() : MillingService {


    @Inject
    lateinit var userRepository: MillingRepository

    override fun queryLastThirtyData(): Observable<MutableList<MillingInfo>> {
        return userRepository.queryLastThirtyData().convert()

    }
    override fun uploadData(millingMaterialno:String,millingToolno:String,millingAge:String,millingDistance:String,millingUser:String,millingPcb:String): Observable<MutableList<MillingInfo>> {

         return userRepository.uploadData(millingMaterialno,millingToolno,millingAge,millingDistance,millingUser,millingPcb).convert()
    }

    override fun queryData(code: String): Observable<MillingInfo> {
        return userRepository.queryData(code).convert()
    }

    override fun queryByMaterialData(code: String): Observable<MutableList<MillingInfo>> {
        return userRepository.queryByMaterialData(code).convert()
    }


}
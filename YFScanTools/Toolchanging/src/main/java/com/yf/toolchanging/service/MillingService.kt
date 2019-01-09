package com.yf.milling.service

import com.yf.milling.data.protocol.MillingInfo
import rx.Observable


interface MillingService {

    //fun uploadData(username:String,password:String): Observable<Boolean>
    fun uploadData(millingMaterialno:String,millingToolno:String,millingAge:String,millingDistance:String,millingUser:String,millingPcb:String): Observable<MillingInfo>
    fun queryData(code:String):Observable<MillingInfo>
    fun queryByMaterialData(code:String):Observable<MutableList<MillingInfo>>
}
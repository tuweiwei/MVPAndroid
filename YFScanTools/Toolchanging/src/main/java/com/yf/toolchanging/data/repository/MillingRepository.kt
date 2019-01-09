package com.yf.milling.data.repository

import com.yf.base.data.net.RetrofitFactory
import com.yf.base.data.protocol.BaseResp
import com.yf.milling.data.api.MillingApi
import com.yf.milling.data.protocol.UploadReq
import com.yf.milling.data.protocol.QueryReq
import com.yf.milling.data.protocol.MillingInfo
import com.yf.milling.data.protocol.QueryByMaterialReq
import rx.Observable
import javax.inject.Inject


//数据层
class MillingRepository @Inject constructor() {

    fun uploadData(millingMaterialno:String,millingToolno:String,millingAge:String,millingDistance:String,millingUser:String,millingPcb:String ): Observable<BaseResp<MillingInfo>>{
        return RetrofitFactory.instance.create(MillingApi::class.java).uploadData(UploadReq(millingMaterialno,millingToolno,millingAge,millingDistance,millingUser,millingPcb))
    }

    fun queryData(millingToolno:String): Observable<BaseResp<MillingInfo>>{
        return RetrofitFactory.instance.create(MillingApi::class.java).queryData(QueryReq(millingToolno))
    }

    fun queryByMaterialData(millingMaterialno:String): Observable<BaseResp<MutableList<MillingInfo>>>{
        return RetrofitFactory.instance.create(MillingApi::class.java).queryDataByMaterial(QueryByMaterialReq(millingMaterialno))
    }
}
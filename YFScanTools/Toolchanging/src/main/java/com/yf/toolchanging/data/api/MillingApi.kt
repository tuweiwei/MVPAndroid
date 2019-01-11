package com.yf.milling.data.api

import com.yf.base.data.protocol.BaseResp
import com.yf.milling.data.protocol.QueryReq
import com.yf.milling.data.protocol.UploadReq
import com.yf.milling.data.protocol.MillingInfo
import com.yf.milling.data.protocol.QueryByMaterialReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable


//访问网络 获取数据接口 /millingCenter/uploadMillingRecord
interface MillingApi {
    /*
        上传数据
     */
    @POST("millingCenter/uploadMillingRecord")
    fun uploadData(@Body req: UploadReq):Observable<BaseResp<MutableList<MillingInfo>>>

    /*
        查询数据
     */
    @POST("millingCenter/query")
    fun queryData(@Body req: QueryReq): Observable<BaseResp<MillingInfo>>

    /*
     查询数据
    */
    @POST("millingCenter/queryByMaterial")
    fun queryDataByMaterial(@Body req: QueryByMaterialReq): Observable<BaseResp<MutableList<MillingInfo>>>

    /*
     查询数据
    */
    @POST("millingCenter/queryLastThirty")
    fun queryLastThirty(): Observable<BaseResp<MutableList<MillingInfo>>>

}
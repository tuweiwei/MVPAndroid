package com.yf.user.data.api


import com.yf.base.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/*
    上传相关 接口
 */
interface UploadApi {

    /*
        获取七牛云上传凭证
     */
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}

package com.yf.message.data.api

import rx.Observable
import com.yf.base.data.protocol.BaseResp
import com.yf.messagecenter.data.protocol.*
import retrofit2.http.Body
import retrofit2.http.POST

/*
    消息 接口
 */
interface MessageApi {

    /*
         根据用户名获取当天的点检任务列表
     */
    @POST("spotInspection/listTodayTaskByUser")
    fun getTodayTaskList(@Body req: ListTodayTaskReq): Observable<BaseResp<MutableList<SpotTask>?>>

    //根据设备ID号 和 当前点检频次 获取当前设备的点检项
    @POST("spotInspection/listcurCheckItems")
    fun listcurCheckItems(@Body req: ListcurCheckItemReq): Observable<BaseResp<MutableList<SpotItem>?>>

    //上传点检结果
    @POST("spotInspection/uploadTaskResult")
    fun uploadTaskResult(@Body req: UploadTaskResultReq): Observable<BaseResp<String>>

    //点检完成 更新任务状态
    @POST("spotInspection/updateTaskStatus")
    fun updateTaskStatus(@Body req: UpdateTaskStatusReq): Observable<BaseResp<String>>
}

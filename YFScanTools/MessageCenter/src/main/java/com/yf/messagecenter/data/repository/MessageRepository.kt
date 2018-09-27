package com.yf.message.data.repository


import javax.inject.Inject

import rx.Observable
import com.yf.base.data.net.RetrofitFactory
import com.yf.base.data.protocol.BaseResp
import com.yf.message.data.api.MessageApi
import com.yf.messagecenter.data.protocol.*


/*
   数据层
 */
class MessageRepository @Inject constructor() {

    fun getTodayTaskList(username : String, date:String): Observable<BaseResp<MutableList<SpotTask>?>> {
        return RetrofitFactory.instance.create(MessageApi::class.java).getTodayTaskList(ListTodayTaskReq(username,date))
    }

    fun listcurCheckItems(equipno : String, frequency: String): Observable<BaseResp<MutableList<SpotItem>?>>{
        return RetrofitFactory.instance.create(MessageApi::class.java).listcurCheckItems(ListcurCheckItemReq(equipno, frequency))

    }

    fun uploadTaskResult(taskid: Int,equipno: String,frequency: String,item:String ,itemValue:String,username: String, result: String,remark:String ): Observable<BaseResp<String>>{

        return RetrofitFactory.instance.create(MessageApi::class.java).uploadTaskResult(UploadTaskResultReq(taskid,equipno,frequency,item,itemValue,username,result,remark))
    }

    fun updateTaskStatus(taskid: Int): Observable<BaseResp<String>>{

        return RetrofitFactory.instance.create(MessageApi::class.java).updateTaskStatus(UpdateTaskStatusReq(taskid))
    }
}

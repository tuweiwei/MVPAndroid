package com.yf.message.service

import com.yf.base.data.protocol.BaseResp
import com.yf.message.data.protocol.Message
import com.yf.messagecenter.data.protocol.SpotItem
import com.yf.messagecenter.data.protocol.SpotTask
import rx.Observable

/*
   业务接口
 */
interface MessageService {

    fun getTodayList(username : String, date :String): Observable<MutableList<SpotTask>?>

    fun listcurCheckItems(equipno : String, frequency: String): Observable<MutableList<SpotItem>?>

    fun uploadTaskResult(taskid: Int,equipno: String,frequency: String,item:String ,itemValue:String,username: String, result: String,remark: String ): Observable<Boolean>

    fun updateTaskStatus(taskid: Int): Observable<Boolean>
}

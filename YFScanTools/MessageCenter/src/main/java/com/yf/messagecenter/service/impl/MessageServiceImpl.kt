package com.yf.message.service.impl


import com.yf.base.data.net.RetrofitFactory
import com.yf.base.data.protocol.BaseResp
import javax.inject.Inject
import rx.Observable
import com.yf.base.ext.convert
import com.yf.base.ext.convertBoolean
import com.yf.message.data.api.MessageApi
import com.yf.message.data.protocol.Message
import com.yf.message.data.repository.MessageRepository
import com.yf.message.service.MessageService
import com.yf.messagecenter.data.protocol.*

/*
   消息业务层
 */
class MessageServiceImpl @Inject constructor(): MessageService {

    @Inject
    lateinit var repository: MessageRepository


    override fun getTodayList(username: String, date : String): Observable<MutableList<SpotTask>?> {
        return repository.getTodayTaskList(username, date).convert()
    }

    override fun listcurCheckItems(equipno: String, frequency: String): Observable<MutableList<SpotItem>?> {
        return repository.listcurCheckItems(equipno, frequency).convert()
    }

    override fun uploadTaskResult(taskid: Int, equipno: String, frequency: String, itemValue: String,item: String, username: String, result: String, remark:String): Observable<Boolean> {
        return repository.uploadTaskResult(taskid,equipno,frequency,item,itemValue,username,result,remark).convertBoolean()
    }

    override fun updateTaskStatus(taskid: Int): Observable<Boolean> {
        return repository.updateTaskStatus(taskid).convertBoolean()

    }


}

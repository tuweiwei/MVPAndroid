package com.yf.message.presenter

import com.yf.base.ext.excute
import com.yf.base.presenter.BasePresenter
import com.yf.base.rx.BaseSubscriber
import com.yf.message.data.protocol.Message
import com.yf.message.presenter.view.MessageView
import com.yf.message.service.MessageService
import com.yf.messagecenter.data.protocol.SpotItem
import com.yf.messagecenter.data.protocol.SpotTask
import javax.inject.Inject

/*
    消息列表 Presenter
 */
class MessagePresenter @Inject constructor() : BasePresenter<MessageView>() {

    @Inject
    lateinit var messageService: MessageService

    /*
        获取任务列表
     */
    fun getTodayTaskList(equipname: String, date: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        messageService.getTodayList(equipname, date).excute(object : BaseSubscriber<MutableList<SpotTask>?>(mView) {
            override fun onNext(t: MutableList<SpotTask>?) {
                mView.onGetMessageResult(t)
            }
        }, lifecycleProvider)

    }

}

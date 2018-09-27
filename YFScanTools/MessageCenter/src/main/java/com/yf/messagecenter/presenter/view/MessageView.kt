package com.yf.message.presenter.view

import com.yf.base.presenter.view.BaseView
import com.yf.message.data.protocol.Message
import com.yf.messagecenter.data.protocol.SpotItem
import com.yf.messagecenter.data.protocol.SpotTask

/*
    消息列表 视图回调
 */
interface MessageView : BaseView {

    //获取任务列表回调
    fun onGetMessageResult(result:MutableList<SpotTask>?)

    //获取点检项目列表回调
    fun onGetCheckItemsResult(result:MutableList<SpotItem>?)
}

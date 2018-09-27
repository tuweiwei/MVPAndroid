package com.kotlin.user.presenter.view

import com.yf.base.presenter.view.BaseView
import com.yf.messagecenter.data.protocol.SpotItem
import junit.framework.TestResult

/*
    编辑用户资料 视图回调
 */
interface EquipItemCheckUploadView : BaseView {

    /*
        获取上传凭证回调
     */
    fun onGetUploadTokenResult(result:String)

    fun onGetCheckItemsResult(result:MutableList<SpotItem>?)

    fun onNextUploadResult(result: Boolean)

    fun onUpdateTaskStatusResult(result: Boolean)

}

package com.yf.milling.presenter.view

import com.yf.base.presenter.view.BaseView
import com.yf.milling.data.protocol.MillingInfo

interface UploadDataView :BaseView {
    fun onUploadResult(result: MutableList<MillingInfo>)
    fun onQueryByMaterialResult(t: MutableList<MillingInfo>)
    fun onQueryDataResult(t: MillingInfo)
    fun onQueryThiryResult(t: MutableList<MillingInfo>)
}
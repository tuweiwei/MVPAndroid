package com.yf.milling.presenter.view

import com.yf.base.presenter.view.BaseView
import com.yf.milling.data.protocol.MillingInfo

interface UploadDataView :BaseView {
    fun onUploadResult(result: MillingInfo)
    fun onQueryByMaterialResult(t: MutableList<MillingInfo>)
    fun onQueryDataResult(t: MillingInfo)
}
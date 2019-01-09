package com.yf.milling.presenter

import com.yf.base.ext.excute
import com.yf.base.presenter.BasePresenter
import com.yf.base.rx.BaseSubscriber
import com.yf.milling.data.protocol.MillingInfo
import com.yf.milling.presenter.view.UploadDataView
import com.yf.milling.service.MillingService
import javax.inject.Inject


//界面 presenter 调用业务处理
class UploadDataPresenter @Inject constructor() :BasePresenter<UploadDataView>() {

    @Inject
    lateinit var millingService: MillingService

    fun uploadData(millingMaterialno:String,millingToolno:String,millingAge:String,millingDistance:String,millingUser:String,millingPcb:String){

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        millingService.uploadData(millingMaterialno,millingToolno,millingAge,millingDistance,millingUser,millingPcb).excute(object : BaseSubscriber<MillingInfo>(mView) {
            override fun onNext(t: MillingInfo) {
                mView.onUploadResult(t)
            }
        }, lifecycleProvider)
    }

    fun queryMaterialData(millingMaterialno:String){

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        millingService.queryByMaterialData(millingMaterialno).excute(object : BaseSubscriber<MutableList<MillingInfo>>(mView) {
            override fun onNext(t: MutableList<MillingInfo>) {
                mView.onQueryByMaterialResult(t)
            }
        }, lifecycleProvider)
    }

    fun queryData(millingToolno:String){

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        millingService.queryData(millingToolno).excute(object : BaseSubscriber<MillingInfo>(mView) {
            override fun onNext(t: MillingInfo) {
                mView.onQueryDataResult(t)
            }
        }, lifecycleProvider)
    }
}
package com.yf.base.rx

import com.yf.base.presenter.view.BaseView
import rx.Subscriber

//订阅者默认实现
open class BaseSubscriber<T>(val baseView: BaseView):Subscriber<T>() {
    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()

        if (e is BaseException){
            baseView.onError(e.msg)
        }

    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

}
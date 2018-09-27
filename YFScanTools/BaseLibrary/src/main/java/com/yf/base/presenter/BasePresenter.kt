package com.yf.base.presenter

import android.content.Context
import com.trello.rxlifecycle.LifecycleProvider
import com.yf.base.presenter.view.BaseView
import com.yf.base.utils.NetWorkUtils
import javax.inject.Inject


//mvp      p层 持有view
open class BasePresenter<T : BaseView> {

    lateinit var mView:T

    //Dagger注入，Rx生命周期管理
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context  //context是全局的 程序启动就已存在


    /*
        检查网络是否可用
     */
    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}
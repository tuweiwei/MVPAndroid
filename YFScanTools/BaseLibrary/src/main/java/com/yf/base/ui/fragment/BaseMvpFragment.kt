package com.yf.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yf.base.common.BaseApplication
import com.yf.base.injection.component.ActivityComponent
import com.yf.base.injection.component.DaggerActivityComponent
import com.yf.base.injection.module.ActivityModule
import com.yf.base.injection.module.LifecycleProviderModule
import com.yf.base.presenter.BasePresenter
import com.yf.base.presenter.view.BaseView
import com.yf.base.widgets.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import javax.inject.Inject

abstract  class BaseMvpFragment<T:BasePresenter<*>>:BaseFragment() ,BaseView{

    @Inject
    lateinit var mPresenter:T
    lateinit var mActiviryComponet:ActivityComponent
    private lateinit var mLoadingDialog: ProgressLoading


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initActivityInjection()
        injectComponent()

        //初始加载框
        mLoadingDialog = ProgressLoading.create(context)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始化Activity级别Component
     */
    private fun initActivityInjection() {
        mActiviryComponet = DaggerActivityComponent.builder().appComponent((activity.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }

    /*
       显示加载框，默认实现
    */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /*
        错误信息提示，默认实现
     */
    override fun onError(text:String) {
        toast(text)
    }
}
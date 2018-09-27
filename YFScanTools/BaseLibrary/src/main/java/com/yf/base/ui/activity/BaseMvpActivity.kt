package com.yf.base.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.yf.base.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import com.yf.base.common.BaseApplication
import com.yf.base.injection.component.ActivityComponent
import com.yf.base.injection.component.DaggerActivityComponent
import com.yf.base.injection.module.ActivityModule
import com.yf.base.presenter.BasePresenter
import com.yf.base.presenter.view.BaseView
import com.yf.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

abstract class BaseMvpActivity<T : BasePresenter<*>>:BaseActivity(),BaseView {

    //Presenter泛型，Dagger注入    mPresenter定义在基类  方便子类直接用
    //1. 注入 有两种 形式 第一种 是  在构造器上 加@Inject 这种会自动寻找
    //2. 第二种 就是针对接口 和 第三方库的情形  只能使用 module 的形式 由component作为中间桥梁进行注入
    @Inject
    lateinit var mPresenter: T

    //基类里 定义 ActivityComponent 子类直接使用
    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()
        injectComponent()                //调用子类具体的 dagger 注入 方法

        //初始加载框
        mLoadingDialog = ProgressLoading.create(this)

        //ARouter注册
        ARouter.getInstance().inject(this)
    }

    /*
       Dagger注册
    */
    protected abstract fun injectComponent()

    /*
        初始ActivityComponent
     */
    private fun initActivityInjection() {
        //注： activityComponent 依赖于 AppComponent
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }


    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text: String) {

        toast(text)
    }

}
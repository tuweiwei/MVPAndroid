package com.yf.usercenter.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.yf.base.ext.enable
import com.yf.base.ext.onClick
import com.yf.base.ui.activity.BaseMvpActivity
import com.yf.provider.common.ProviderConstant
import com.yf.provider.router.RouterPath
import com.yf.user.ui.activity.UserInfoActivity
import com.yf.usercenter.R
import com.yf.usercenter.R.string.username
import com.yf.usercenter.data.protocol.UserInfo
import com.yf.usercenter.injection.component.DaggerUserComponent
import com.yf.usercenter.injection.module.UserModule
import com.yf.usercenter.presenter.LoginPresenter
import com.yf.usercenter.presenter.RegisterPresenter
import com.yf.usercenter.presenter.view.LoginView
import com.yf.usercenter.presenter.view.RegisterView
import com.yf.usercenter.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*

import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.*

//后期可以为此类 指定路由   从别的模块拦截进入此ACTIVITY进行登录
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener{
    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")

        UserPrefsUtils.putUserInfo(result)
        finish()
        //startActivity<UserInfoActivity>()
        //跳转到主界面
        jumpMain()
    }

     fun jumpMain() {
        ARouter.getInstance().build(RouterPath.App.PATH_MAIN)
                .withString(ProviderConstant.KEY_SP_USER_NAME, mUser.text.toString())
                .navigation()
    }

    /*
       点击事件
    */
    override fun onClick(v: View) {

        when(v.id){
            R.id.mLoginBtn -> {
               mPresenter.login(mUser.text.toString(),"")
            }
        }
    }


    /*
        判断按钮是否可用
     */
    //private fun isBtnEnable():Boolean{
//        return mMobileEt.text.isNullOrEmpty().not() &&
//                mPwdEt.text.isNullOrEmpty().not()
    //}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //初始化 presenter 和  view
        initView()

    }

    /*
       初始化视图
    */
    private fun initView() {
        //mLoginBtn.enable(mMobileEt,{isBtnEnable()})
        //mLoginBtn.enable(mPwdEt,{isBtnEnable()})

        mLoginBtn.onClick(this)

    }

    /*
        Dagger注册
     */
    override fun injectComponent() {

        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

}

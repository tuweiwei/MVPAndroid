package com.yf.usercenter.ui.activity

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.yf.base.ui.activity.BaseMvpActivity
import com.yf.usercenter.R
import com.yf.usercenter.presenter.RegisterPresenter
import com.yf.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*

import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView , View.OnClickListener{
    override fun injectComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View) {

        when(v.id){
//            R.id.btnLogin -> {
//
//                mPresenter.register(mUsername.text.toString(),mPassword.text.toString())
//            }

        }
    }

    override fun onRegisterResult(result: String) {
        toast("注册成功")


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        mPresenter = RegisterPresenter()
        mPresenter.mView = this

        initView()


    }

    private fun initView() {

        //mLoginBtn.setOnClickListener(this)

    }

}

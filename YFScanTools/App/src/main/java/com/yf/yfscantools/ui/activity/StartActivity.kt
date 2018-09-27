package com.yf.yfscantools.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.yf.base.common.AppManager
import com.yf.base.ui.activity.BaseActivity
import com.yf.base.utils.AppPrefsUtils
import com.yf.message.ui.fragment.MessageFragment
import com.yf.provider.event.MessageBadgeEvent
import com.yf.yfscantools.R
import com.yf.yfscantools.ui.fragment.HomeFragment
import com.yf.yfscantools.ui.fragment.MeFragment
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import org.jetbrains.anko.toast
import android.R.id.tabs
import android.support.v4.content.ContextCompat.startActivity
import com.yf.provider.common.ProviderConstant
import com.yf.usercenter.ui.activity.LoginActivity
import com.yf.yfscantools.R.id.mBottomNavBar


class StartActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME) == "") {

            startActivity<LoginActivity>()
            return
        }

        startActivity<MainActivity>()
    }
}

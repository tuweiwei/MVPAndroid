package com.yf.yfscantools

import android.os.Bundle
import com.yf.base.ext.onClick
import com.yf.base.ui.activity.BaseActivity
import com.yf.usercenter.utils.UserPrefsUtils
import com.yf.yfscantools.R.id.*
import kotlinx.android.synthetic.main.activity_setting.*
import org.jetbrains.anko.toast

/*
    设置界面
 */
class SettingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        mUserProtocolTv.onClick {
            toast("用户协议")
        }
        mFeedBackTv.onClick {
            toast("反馈")
        }
        mAboutTv.onClick {
            toast("关于")
        }

        //退出登录，清空本地用户数据
        mLogoutBtn.onClick {
            UserPrefsUtils.putUserInfo(null)
            finish()
        }
    }
}

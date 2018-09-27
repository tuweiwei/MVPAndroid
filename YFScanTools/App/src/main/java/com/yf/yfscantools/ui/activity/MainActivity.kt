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
import com.alibaba.android.arouter.facade.annotation.Route
import com.yf.provider.common.ProviderConstant
import com.yf.provider.router.RouterPath
import com.yf.usercenter.ui.activity.LoginActivity

@Route(path = RouterPath.App.PATH_MAIN)
class MainActivity : BaseActivity(){

    private var pressTime:Long = 0

    //Fragment 栈管理
    private val mStack = Stack<Fragment>()

    //主界面Fragment  放置公告等相关信息
     private val mHomeFragment by lazy { HomeFragment() }

    //点检任务消息Fragment   任务消息
    private val mMsgFragment by lazy { MessageFragment() }

    //"我的"Fragment  个人信息
    private val mMeFragment by lazy { MeFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        initBottomNav()
        changeFragment(0) //默认为首页
    }

    /*
        初始化Fragment栈 管理
     */
    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()

        //底部 和 fragment 初始化  加入到fragment管理器 和 栈
        manager.add(R.id.mContaier, mHomeFragment)   //首页
        manager.add(R.id.mContaier, mMsgFragment)   //任务消息
        manager.add(R.id.mContaier, mMeFragment)     //个人

        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)
    }

    /*
        初始化底部导航切换事件
     */
    private fun initBottomNav(){
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)

            }
        })

    }

    /*
        切换Tab，切换对应的Fragment
     */
    private fun changeFragment(position: Int) {

        val manager = supportFragmentManager.beginTransaction()

        //遍历栈  隐藏所有  显示当前
        for (fragment in mStack){
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }

    /*
        重写Back事件，双击退出
     */
    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000){
            toast("再按一次退出程序")
            pressTime = time
        } else{
            AppManager.instance.exitApp(this)
        }
    }
}

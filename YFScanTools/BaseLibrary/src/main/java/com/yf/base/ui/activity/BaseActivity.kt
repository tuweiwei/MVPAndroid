package com.yf.base.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import com.yf.base.common.AppManager
import org.jetbrains.anko.find

/*
    Activity基类，业务无关
 */
open class BaseActivity: RxAppCompatActivity() {


    //每当调用到子类 的oncreate 方法时  会调用到  基类的oncreate方法   这里直接把子类activity 添加到 自定义栈
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //appManager 管理 activity 栈
        AppManager.instance.addActivity(this)
    }


    //销毁activity 回调到 ondestroy时  会把当前activity 退栈
    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }



    //获取Window中视图content
    val contentView: View
        get() {
            val content = find<FrameLayout>(android.R.id.content)
            return content.getChildAt(0)
        }
}
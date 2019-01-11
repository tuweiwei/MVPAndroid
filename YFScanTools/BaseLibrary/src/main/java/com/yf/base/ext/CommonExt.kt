package com.yf.base.ext

import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.fy.base.utils.GlideUtils
import com.kennyc.view.MultiStateView
import com.trello.rxlifecycle.LifecycleProvider
import com.yf.base.R
import com.yf.base.data.protocol.BaseResp
import com.yf.base.rx.BaseFunc
import com.yf.base.rx.BaseFuncBoolean
import com.yf.base.rx.BaseSubscriber
import com.yf.base.widgets.DefaultTextWatcher
import org.jetbrains.anko.find
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

//Kotlin通用扩展

/*
    扩展Observable执行
 */
fun <T> Observable<T>.excute(subscriber: BaseSubscriber<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(subscriber)
}


/*
    扩展数据转换  采用rx转换网络返回对象BaseResp<T> 为 指定的类型Observable<T>
 */
fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFunc())
}

/*
    扩展Boolean类型数据转换 采用rx转换网络返回对象BaseResp<T> 为 指定的类型Observable<Boolean>
 */
fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}

/*
    扩展方法 扩展点击事件
 */
fun View.onClick(listener:View.OnClickListener):View{
    setOnClickListener(listener)
    return this
}

/*
    扩展点击事件，参数为方法
 */
fun View.onClick(method:() -> Unit):View{
    setOnClickListener { method() }
    return this
}

/*
    扩展Button可用性
 */
fun Button.enable(et: EditText, method: () -> Boolean){
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher({

        //            @Override
    //            public void onTextChanged(CharSequence arg0, int start, int before, int count) {
    //
    //
    //                if (str.endsWith("\n")) {
    //                    String str1 = str . substring (0, Len-1);
    //                    int iPos = str1 . lastIndexOf ("\n");
    //                    String strBuff = "";
    //                    if (-1 == iPos) {
    //                    }
    //                }
    //            }
    }) {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

/*
    ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}

/*
    多状态视图开始加载
 */
fun MultiStateView.startLoading(){
    viewState = MultiStateView.VIEW_STATE_LOADING
    val loadingView = getView(MultiStateView.VIEW_STATE_LOADING)
    val animBackground = loadingView!!.find<View>(R.id.loading_anim_view).background
    (animBackground as AnimationDrawable).start()
}


/*
    扩展视图可见性
 */
fun View.setVisible(visible:Boolean){
    this.visibility = if (visible) View.VISIBLE else View.GONE
}
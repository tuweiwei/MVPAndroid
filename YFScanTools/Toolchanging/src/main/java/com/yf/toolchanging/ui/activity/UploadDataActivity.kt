package com.yf.milling.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.yf.base.common.BaseApplication.Companion.context
import com.yf.base.ext.enable
import com.yf.base.ext.onClick
import com.yf.base.ui.activity.BaseMvpActivity
import com.yf.milling.data.protocol.MillingInfo
import com.yf.milling.injection.component.DaggerMillingComponent
import com.yf.milling.injection.module.MillingModule
import com.yf.milling.presenter.UploadDataPresenter
import com.yf.milling.presenter.view.UploadDataView
import com.yf.milling.ui.adapter.MillingToolAdapter
import com.yf.toolchanging.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class UploadDataActivity : BaseMvpActivity<UploadDataPresenter>(), UploadDataView, View.OnClickListener{

    private lateinit var mAdapter: MillingToolAdapter

    //获取机型的所有条码
    override fun onQueryByMaterialResult(result: MutableList<MillingInfo>) {
        if (result != null && result.size > 0){
            //回调回来  将获得数据设置到  适配器

            mAdapter.setData(result)
            toast(result.size.toString())
            //mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        }else{
            //数据为空
            //mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }

    //获取刚刚上传的单个条码
    override fun onQueryDataResult(t: MillingInfo) {

    }

    override fun onUploadResult(result: MillingInfo) {
        toast("上传成功")
        //UserPrefsUtils.putUserInfo(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //初始化 presenter 和  view
        initView()
        initData()
    }

    /*
          初始化视图
       */
    private fun initView() {
        mMillingRv.layoutManager = LinearLayoutManager(context)
        mAdapter = MillingToolAdapter(context)
        mMillingRv.adapter = mAdapter
        //mMachineEt mMillingNoEt mAgeSp mDistanceSp mUserEt mPcbEt mConfirmBtn
        mConfirmBtn.enable(mMachineEt,{isBtnEnable()})
        mConfirmBtn.enable(mMillingNoEt,{isBtnEnable()})
        mConfirmBtn.enable(mUserEt,{isBtnEnable()})
        mConfirmBtn.enable(mPcbEt,{isBtnEnable()})

        mConfirmBtn.onClick(this)
        mQueryBtn.onClick(this)
        mScanMaterialNoEt.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            //当actionId == XX_SEND 或者 XX_DONE时都触发
            //或者event.getKeyCode == ENTER 且 event.getAction == ACTION_DOWN时也触发
            //注意，这是一定要判断event != null。因为在某些输入法上会返回null。
            if (actionId == EditorInfo.IME_ACTION_SEND
                    || actionId == EditorInfo.IME_ACTION_DONE
                    || event != null && KeyEvent.KEYCODE_ENTER == event.keyCode && KeyEvent.ACTION_DOWN == event.action) {
                //处理事件
                mPresenter.queryMaterialData(mScanMaterialNoEt.text.toString().trim())
            }
            false
        })
    }

    /*
        初始化数据
     */
    private fun initData() {

    }

    /*
       判断按钮是否可用
    */
    private fun isBtnEnable():Boolean{
        return mMachineEt.text.isNullOrEmpty().not() &&
                mMillingNoEt.text.isNullOrEmpty().not() &&
                mUserEt.text.isNullOrEmpty().not() &&
                mPcbEt.text.isNullOrEmpty().not()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.mConfirmBtn -> {
                mPresenter.uploadData(mMachineEt.text.toString(),mMillingNoEt.text.toString(),
                        mAgeSp.getSelectedItem().toString(),mDistanceSp.getSelectedItem().toString(), mUserEt.text.toString(), mPcbEt.text.toString())
            }
            R.id.mQueryBtn ->{
                mPresenter.queryMaterialData(mScanMaterialNoEt.text.toString().trim())
            }
        }
    }

    override fun injectComponent() {

        DaggerMillingComponent.builder().activityComponent(mActivityComponent).millingModule(MillingModule()).build().inject(this)
        mPresenter.mView = this
    }
}

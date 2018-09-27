package com.yf.messagecenter.ui.activity

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.kotlin.base.ui.activity.BaseTakePhotoActivity
import com.kotlin.user.presenter.view.EquipItemCheckUploadView
import com.yf.base.ext.onClick
import com.yf.base.ext.setVisible
import com.yf.base.utils.AppPrefsUtils
import com.yf.em.data.protocol.SpotItemParam
import com.yf.message.common.TaskMessageConstant
import com.yf.message.injection.component.DaggerMessageComponent
import com.yf.message.injection.module.MessageModule
import com.yf.messagecenter.R
import com.yf.messagecenter.data.protocol.SpotItem
import com.yf.provider.common.ProviderConstant
import com.yf.user.presenter.EquipItemCheckUploadPresenter
import kotlinx.android.synthetic.main.activity_equip_item.*
import org.jetbrains.anko.toast

class EquipItemCheck : BaseTakePhotoActivity<EquipItemCheckUploadPresenter>(), EquipItemCheckUploadView{

    private var spotItemParam : SpotItemParam? = null

    private var items : MutableList<SpotItem> = mutableListOf()

    private var conut : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equip_item)

        initData()
        initView()
    }

    private fun initView() {
        mEquipIconIv.onClick {
            showAlertView()
        }

        mHeaderBar.getRightView().onClick {
//            mPresenter.editUser(mRemoteFileUrl!!,
//                    mUserNameEt.text?.toString()?:"",
//                    if(mGenderMaleRb.isChecked) "0" else "1",
//                    mUserSignEt.text?.toString()?:""
//            )
        }

        mNextBtn.onClick{
            conut++
            if(mSpotValue.text.toString() == "" || (!mOKRb.isChecked && !mNGRb.isChecked)){

                toast("请填写点检值及点检结果")
                return@onClick
            }

            if(items!!.size <= 0){
                return@onClick
            }

            if(conut < items.size) {
                toast("上传成功，已跳到下一个点检项目")
            }


            if(conut == items!!.size-1){
                mNextBtn.setText("完成")
            }

            mPresenter.uploadInfo(spotItemParam?.id?:0,
                    mEquipNo.text.toString(),
                    "frequency",
                    mSpotValue.text.toString(),
                    mSpotItem.text.toString(),
                    AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME),
                    if(mOKRb.isChecked) "OK" else "NG",
                    mRemark.text.toString())

             //当点检项目完全点检完，则此任务置为已完成  否则清除点检信息
            if(conut == items.size) {
                mPresenter.uploadTaskStatus(spotItemParam?.id ?: 0)
            }

        }
    }


    /*
       初始化数据
    */
    private fun initData() {
        spotItemParam = intent.getParcelableExtra(TaskMessageConstant.SP_CLICK_ID)
        //id ，no，name, fre,username    给设备编号  设备名称赋值

        spotItemParam?.let {
            mEquipNo.setText(it.equipno)
            mEquipName.setText(it.equipname)
            mPresenter.getSpotInspectItems(it.equipno , it.frequency)
        }

    }

    override fun onGetCheckItemsResult(result: MutableList<SpotItem>?) {

        if(result == null || result.size <= 0){
            return
        }

        //取出第一项进行设值
        mSpotItem.setText(result[0].spotinspectionitem)
        mGeneryValue.setText("默认值")
        items = result

        //进来时  如果只有一个测试项目
        if(items!!.size == 1){
            mNextBtn.setText("完成")
        }
    }

    override fun onNextUploadResult(result: Boolean) {
        //如果没有点检完所有的项  则更新UI  进行下一项显示
        if(conut == items!!.size-1){
            mNextBtn.setText("完成")
        }

        if(conut == items!!.size){
            finish()
        }

        mSpotItem.setText(items[conut].spotinspectionitem)
        mSpotValue.setText("")
        mNGRb.isChecked = false
        mOKRb.isChecked = false
    }


    //更新任务状态后
    override fun onUpdateTaskStatusResult(result: Boolean) {

        toast("此点检任务完成")

    }

    override fun injectComponent() {

        DaggerMessageComponent.builder().activityComponent(mActivityComponent).messageModule(MessageModule()).build().inject(this)
        mPresenter.mView = this
    }








    override fun onGetUploadTokenResult(result: String) {

    }



}
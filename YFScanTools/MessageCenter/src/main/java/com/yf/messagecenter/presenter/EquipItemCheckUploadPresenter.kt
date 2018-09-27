package com.yf.user.presenter


import android.os.Build.VERSION_CODES.M
import com.kotlin.user.presenter.view.EquipItemCheckUploadView
import com.yf.base.ext.excute
import com.yf.base.presenter.BasePresenter
import com.yf.base.rx.BaseSubscriber
import com.yf.message.service.MessageService
import com.yf.messagecenter.data.protocol.SpotItem
import javax.inject.Inject

/*
    编辑用户资料Presenter
 */
class EquipItemCheckUploadPresenter @Inject constructor() : BasePresenter<EquipItemCheckUploadView>() {

    @Inject
    lateinit var messageService: MessageService

//    @Inject
//    lateinit var uploadService: UploadService

    /*
        获取七牛云上传凭证
     */
    fun getUploadToken(){
        if (!checkNetWork())
            return

        mView.showLoading()
//        uploadService.getUploadToken().excute(object : BaseSubscriber<String>(mView){
//            override fun onNext(t: String) {
//                mView.onGetUploadTokenResult(t)
//            }
//        },lifecycleProvider)
    }

    /*
        编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String){
        if (!checkNetWork())
            return

        mView.showLoading()
//        MessageService.editUser(userIcon,userName,userGender,userSign).excute(object :BaseSubscriber<UserInfo>(mView){
//            override fun onNext(t: UserInfo) {
//                mView.onEditUserResult(t)
//            }
//        },lifecycleProvider)
    }



    /*
       获取具体设备的 点检项目列表
    */
    fun getSpotInspectItems(equipno: String, frequency: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        messageService.listcurCheckItems(equipno, frequency).excute(object : BaseSubscriber<MutableList<SpotItem>?>(mView) {
            override fun onNext(t: MutableList<SpotItem>?) {
                mView.onGetCheckItemsResult(t)
            }
        }, lifecycleProvider)

    }




    /*
      上传点检项目结果
   */
    fun uploadInfo(taskID: Int,equipno: String,frequency: String, item : String, itemValue: String,username: String, resutlt:String, remark:String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        messageService.uploadTaskResult(taskID,equipno, frequency,item,itemValue,username,resutlt,remark).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onNextUploadResult(t)
            }
        }, lifecycleProvider)

    }


    /*
      更新任务
   */
    fun uploadTaskStatus(taskID: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        messageService.updateTaskStatus(taskID).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onUpdateTaskStatusResult(t)
            }
        }, lifecycleProvider)

    }

}

package com.yf.message.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.kennyc.view.MultiStateView
import com.yf.base.ext.startLoading
import com.yf.base.ui.adapter.BaseRecycleViewAdapter
import com.yf.base.ui.fragment.BaseMvpFragment
import com.yf.base.utils.AppPrefsUtils
import com.yf.em.data.protocol.SpotItemParam
import com.yf.message.common.TaskMessageConstant
import com.yf.message.injection.component.DaggerMessageComponent
import com.yf.message.injection.module.MessageModule
import com.yf.message.presenter.MessagePresenter
import com.yf.message.presenter.view.MessageView
import com.yf.message.ui.adapter.MessageAdapter
import com.yf.messagecenter.R
import com.yf.messagecenter.data.protocol.SpotItem
import com.yf.messagecenter.data.protocol.SpotTask
import com.yf.messagecenter.ui.activity.EquipItemCheck
import com.yf.provider.common.ProviderConstant
import com.yf.provider.event.MessageBadgeEvent
import kotlinx.android.synthetic.main.fragment_message.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import rx.internal.schedulers.NewThreadScheduler
import java.text.SimpleDateFormat
import java.util.*


/*
    点检任务消息列表Fragment
 */
class MessageFragment: BaseMvpFragment<MessagePresenter>(), MessageView {

    private lateinit var mAdapter: MessageAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        //拿到主体布局
        return inflater?.inflate(R.layout.fragment_message,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    /*
       初始化视图
    */
    private fun initView() {

        mMessageRv.layoutManager = LinearLayoutManager(context)
        mAdapter = MessageAdapter(context)
        mMessageRv.adapter = mAdapter
        //单项点击事件
        mAdapter.setOnItemClickListener(object : BaseRecycleViewAdapter.OnItemClickListener<SpotTask> {
            override fun onItemClick(item: SpotTask, position: Int) {
//                for (category in mAdapter.dataList) {
//                    //category.isSelected = item.id == category.id
//                }
                mAdapter.notifyDataSetChanged()
                val value = SpotItemParam(item.id,item.equipno, item.equipname,item.frequency,item.spotinspectionworker)
                toast(""+ item.id +"   "+ item.equipno + "   "+ item.equipname)

                startActivity<EquipItemCheck>(TaskMessageConstant.SP_CLICK_ID to value)
            }
        })

    }


    override fun onGetCheckItemsResult(result: MutableList<SpotItem>?) {
        //拿到点检项后 根据对应点击的项进入 Activity    （此时要查出点检项目）
       if(result != null && result.size >=1){
           //val spotTransfer = SpotItemTransfer()

       }

    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    /*
        加载数据
     */
    private fun loadData() {
        mMultiStateView.startLoading()
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd");

        mPresenter.getTodayTaskList(AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME), simpleDateFormat.format(Date()))
    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerMessageComponent.builder().activityComponent(mActiviryComponet).messageModule(MessageModule()).build().inject(this)
        mPresenter.mView = this
    }

    /*
        获取消息后回调
     */
    override fun onGetMessageResult(result: MutableList<SpotTask>?) {
        if (result != null && result.size > 0){
            //回调回来  将获得数据设置到  适配器
            mAdapter.setData(result)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        }else{
            //数据为空
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }


    /*
        监听Fragment隐藏或显示
     */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden){
            Bus.send(MessageBadgeEvent(false))
        }
    }
}

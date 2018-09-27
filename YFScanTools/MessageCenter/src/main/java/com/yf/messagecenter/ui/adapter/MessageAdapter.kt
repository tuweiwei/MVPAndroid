package com.yf.message.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yf.base.ext.loadUrl
import com.yf.base.ui.adapter.BaseRecycleViewAdapter
import com.yf.message.data.protocol.Message
import com.yf.messagecenter.R
import com.yf.messagecenter.data.protocol.SpotTask
import kotlinx.android.synthetic.main.layout_message_item.view.*

/*
    任务消息数据
 */
class MessageAdapter(context: Context) : BaseRecycleViewAdapter<SpotTask, MessageAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {


        //设置子布局
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_message_item,
                        parent,
                        false)

        //创建viewHolder
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //重写父类方法，上面已经 创建好viewHolder   并再次调用父类方法设置监听
        super.onBindViewHolder(holder, position)
        val model = dataList[position]

        //任务消息图标
        //holder.itemView.mMsgIconIv.loadUrl(model.msgicon)
        //消息标题设备名
        holder.itemView.mMsgTitleTv.text = model.equipno
        //时间
        holder.itemView.mMsgTimeTv.text = "截止：${model.executetime}"
        //消息内容   中文名 +  频次
        holder.itemView.mMsgContentTv.text ="${model.equipname}  按${model.frequency}点检"
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}

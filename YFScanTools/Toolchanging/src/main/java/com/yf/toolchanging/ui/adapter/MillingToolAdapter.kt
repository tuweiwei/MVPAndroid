package com.yf.milling.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yf.base.common.BaseApplication.Companion.context
import com.yf.base.ui.adapter.BaseRecycleViewAdapter
import com.yf.milling.data.protocol.MillingInfo
import com.yf.toolchanging.R
import kotlinx.android.synthetic.main.layout_milling_item.view.*

class MillingToolAdapter(context: Context): BaseRecycleViewAdapter<MillingInfo,
        MillingToolAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MillingToolAdapter.ViewHolder {

        //设置子布局
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_milling_item,
                        parent,
                        false)

        //创建viewHolder
        return MillingToolAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //重写父类方法，上面已经 创建好viewHolder   并调用父类方法设置监听
        super.onBindViewHolder(holder, position)
        val model = dataList[position]

        holder.itemView.mMaterialNoTv.text = model.millingMaterialno
        holder.itemView.mToolNoTv.text = model.millingToolno
        holder.itemView.mAgeTv.text = model.millingAge
        holder.itemView.mDistanceTv.text = model.millingDistance
        holder.itemView.mUserTv.text = model.millingUser
        holder.itemView.mCreateTimeTv.text = model.millingCreatedate

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
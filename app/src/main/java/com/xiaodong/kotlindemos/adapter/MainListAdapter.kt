package com.xiaodong.kotlindemos.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.jlibrary.base.BaseRecycleViewAdapter
import com.example.jlibrary.base.BaseViewHold
import com.example.jlibrary.bean.BeanWraper
import com.xiaodong.kotlindemos.R
import kotlinx.android.synthetic.main.main_list_vh.view.*

/**
 * Created by xiaodong.jin on 2019/4/16.
 * description：
 */
class MainListAdapter(context: Context, list: List<BeanWraper>) : BaseRecycleViewAdapter<BeanWraper>(context, list) {

    var mOnItemClickListener: onItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHold<Any> {

        return MainListVH(mInfalater.inflate(R.layout.main_list_vh, parent, false))
    }


    inner class MainListVH(val mItemView: View) : BaseViewHold<BeanWraper>(mItemView) {


        override fun onBindViewHolder(position: Int, mData: List<Any>) {

            val beanWraper = mData[position] as BeanWraper

            mItemView.button_view.setText(beanWraper.name)
            mItemView.button_view.setOnClickListener {
                mOnItemClickListener?.onItemClick(it, position)
            }
        }
    }

    fun setOnItemClickListener(clickListener: onItemClickListener) {
        mOnItemClickListener = clickListener
    }


    interface onItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}
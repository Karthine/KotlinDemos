package com.example.jlibrary.base

import android.view.View

/**
 * Created by xiaodong.jin on 2019/4/16.
 * description：
 */
class DefaultNothingHolder(val itemView: View) : BaseViewHold<Any>(itemView) {

    override fun onBindViewHolder(position: Int, mData: List<Any>) {
    }

}
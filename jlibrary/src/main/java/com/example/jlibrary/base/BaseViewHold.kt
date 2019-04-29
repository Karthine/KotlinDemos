package com.example.jlibrary.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by xiaodong.jin on 2019/4/16.
 * description：
 */
abstract class BaseViewHold<out T>( itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBindViewHolder(position: Int, mData: List<Any>);

}
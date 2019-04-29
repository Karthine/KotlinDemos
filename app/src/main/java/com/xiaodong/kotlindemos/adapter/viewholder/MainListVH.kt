package com.xiaodong.kotlindemos.adapter.viewholder

import android.view.View
import android.widget.Button
import com.example.jlibrary.base.BaseViewHold
import com.example.jlibrary.bean.BeanWraper
import com.xiaodong.kotlindemos.R

/**
 * Created by Administrator on 2019/4/29 0029.
 * description：
 */
class MainListVH(itemView: View) : BaseViewHold<BeanWraper>(itemView) {


    var btnItme: Button

    init {
        btnItme = itemView.findViewById(R.id.bt_refresh)
    }

    override fun onBindViewHolder(position: Int, mData: List<Any>) {

    }

}


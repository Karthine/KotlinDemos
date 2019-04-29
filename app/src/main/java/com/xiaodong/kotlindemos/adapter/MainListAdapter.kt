package com.xiaodong.kotlindemos.adapter

import android.content.Context
import android.view.ViewGroup
import com.example.jlibrary.base.BaseRecycleViewAdapter
import com.example.jlibrary.base.BaseViewHold
import com.example.jlibrary.bean.BeanWraper
import com.xiaodong.kotlindemos.R
import com.xiaodong.kotlindemos.adapter.viewholder.MainListVH

/**
 * Created by xiaodong.jin on 2019/4/16.
 * description：
 */
class MainListAdapter(context: Context, list: List<BeanWraper>) : BaseRecycleViewAdapter<BeanWraper>(context, list){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHold<Any> {

        return MainListVH(mInfalater.inflate(R.layout.main_list_vh,parent,false))
    }


}
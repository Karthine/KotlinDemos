package com.example.jlibrary.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jlibrary.R

/**
 * Created by xiaodong.jin on 2019/4/16.
 * description：
 */
open class BaseRecycleViewAdapter<out T>(val mContext: Context, val list: List<Any>) : RecyclerView.Adapter<BaseViewHold<Any>>() {


    var prePosition = 0

    val mDefaultCount = HashMap<Int, Int>()
    val mData = ArrayList<Any>()
    val mInfalater = LayoutInflater.from(mContext);
    val myDataObserver = MyDataObserver()

    companion object {
        //无内容
        val NOTHING = R.layout.default_page_no_content
        //加载失败
        val FAILED = R.layout.default_page_failed
    }


    init {
        if (list != null) {
            mData.addAll(list)
        }
        registerAdapterDataObserver(myDataObserver)
    }


    override fun getItemViewType(position: Int): Int {
        if (mDefaultCount.size != 0) {
            if (mDefaultCount.containsKey(NOTHING) && mDefaultCount[NOTHING] == position) {
                return NOTHING
            }
            if (mDefaultCount.containsKey(FAILED) && mDefaultCount[FAILED] == position) {
                return FAILED
            }
        }
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHold<Any> {
        if (viewType == NOTHING) {
            return DefaultNothingHolder(mInfalater.inflate(NOTHING, parent, false))
        } else if (viewType == FAILED) {
            return DefaultFailedHolder(mInfalater.inflate(FAILED, parent, false))
        }
        return DefaultNothingHolder(mInfalater.inflate(NOTHING, parent, false))

    }

    override fun getItemCount(): Int {
        return mData?.size + mDefaultCount.size
    }

    override fun onBindViewHolder(holder: BaseViewHold<Any>, position: Int) {
        holder.onBindViewHolder(position, mData)
    }

    fun inflate(resLayout: Int, parent: ViewGroup): View {

        return mInfalater?.inflate(resLayout, parent, false)
                ?: LayoutInflater.from(mContext).inflate(resLayout, parent, false)
    }

    fun getData(): List<Any> {
        return mData
    }

    //显示加载失败
    fun showFailed() {
        showPage(FAILED)
    }

    //显示无内容
    fun showNothing() {
        showPage(NOTHING)
    }

    private fun showPage(resourceId: Int) {
        prePosition = mData?.size
        mDefaultCount[resourceId] = prePosition
        notifyDataSetChanged()
    }


    inner class MyDataObserver : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            if (mData.size != prePosition) {
                mDefaultCount.clear()
            }
        }
    }
}
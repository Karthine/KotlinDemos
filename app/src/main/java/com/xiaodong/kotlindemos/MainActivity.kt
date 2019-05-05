package com.xiaodong.kotlindemos

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jlibrary.bean.BeanWraper
import com.xiaodong.kotlindemos.adapter.MainListAdapter
import com.xiaodong.kotlindemos.basic.BasicGrammarActivity
import com.xiaodong.kotlindemos.utils.FormatMockDataUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var mList = ArrayList<BeanWraper>()

    var mAdapter: MainListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
        initData()
    }

    private fun initListener() {
        mAdapter?.setOnItemClickListener(object : MainListAdapter.onItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val beanWraper = mList[position]
                var intent: Intent? = null
                when (beanWraper.name) {
                    "Kotlin Demo One" -> intent = Intent(this@MainActivity, BasicGrammarActivity::class.java)
                }
                startActivity(intent)
            }
        })
    }

    private fun initView() {
        recycleview.layoutManager = LinearLayoutManager(this)
        mAdapter = MainListAdapter(this, mList)
        recycleview.adapter = mAdapter
    }

    private fun initData() {
        mList.add(FormatMockDataUtils.getBeanWraper("Kotlin Demo One"))
        mAdapter?.mData?.clear()
        mAdapter?.mData?.addAll(mList)
        mAdapter?.notifyDataSetChanged()
    }
}

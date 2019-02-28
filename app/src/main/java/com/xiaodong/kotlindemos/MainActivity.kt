package com.xiaodong.kotlindemos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.text = "hello kotlin!"
        tv.setOnClickListener {
            if (tv.text.equals("hello"))
                tv.text = "你点了一下"
            else tv.text="hello"
        }

    }
}

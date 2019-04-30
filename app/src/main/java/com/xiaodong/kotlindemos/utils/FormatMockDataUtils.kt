package com.xiaodong.kotlindemos.utils

import com.example.jlibrary.bean.BeanWraper

/**
 * Created by Administrator on 2019/4/30 0030.
 * description：
 */
class FormatMockDataUtils {

    companion object {

        fun getBeanWraper(name: String): BeanWraper {
            var beanWraper = BeanWraper()
            beanWraper.name = name
            beanWraper.type = 1
            return beanWraper
        }

        fun getBeanWraper(data: Any, type: Int): BeanWraper {
            var beanWraper = BeanWraper()
            beanWraper.data = data
            beanWraper.type = type
            return beanWraper
        }


    }


}
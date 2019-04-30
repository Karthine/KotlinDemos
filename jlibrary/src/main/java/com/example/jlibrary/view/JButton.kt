package com.example.jlibrary.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import com.example.jlibrary.R

/**
 * Created by Administrator on 2019/4/30 0030.
 * description：
 */
class JButton : AppCompatButton {

    /**
     * mode:按钮的样式
     * 0：默认首选样式，1：次选样式 2：弱操作样式
     * */
    var style = 0

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

        //第二个参数就是我们在attrs.xml文件中的<declare-styleable>标签
        //即属性集合的标签，在R文件中名称为R.styleable+name
        var a = context.obtainStyledAttributes(attrs, R.styleable.JButton)
        //第一个参数为属性集合里面的属性，R文件名称：R.styleable+属性集合名称+下划线+属性名称
        //第二个参数为，如果没有设置这个属性，则设置的默认的值
        //最后记得将TypedArray对象回收
        a.recycle()


        when (style) {
            0 -> setBackgroundResource(R.drawable.lib_btn_gray_bg)
            1 -> setBackgroundResource(R.drawable.lib_btn_line_bg)
            2 -> setBackgroundResource(R.drawable.lib_btn_line_gray_bg)
            else -> setBackgroundResource(R.drawable.lib_btn_gray_bg)
        }
        gravity = Gravity.CENTER

    }
}
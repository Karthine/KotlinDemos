package com.xiaodong.kotlindemos.basic.start

/**
 * Created by xiaodong.jin on 2019/05/20.
 * description：基础部分
 */


fun main(args: Array<String>) {
    var baseKotlin = BaseKotlin()
    baseKotlin.numberType()
    baseKotlin.numberTest()
    baseKotlin.naumberTest2()
    println(baseKotlin.chartest('8'))
    baseKotlin.arrayTest()
}

class BaseKotlin {

    /**
     * 1. 基本类型：
     * */

    /**
     *  1.1 数字: Kotlin提供了如下的内置类型来表示数字(和 Java 很相近)
     *      Type      Bit width
     *      Double        64
     *      Float        32
     *      Long         64
     *      Int         32
     *      Short        16
     *      Byte        8
     *      注意：Kotlin中字符不是数字
     *  字面常量：
     *        数值常量字面值有以下几种：
     *           —— 十进制：123
     *               —— Long类型用大写的L标记：123L
     *          —— 十六进制:0x0F
     *          —— 二进制:0b00001011
     *  注意：不支持八进制
     *
     *  Kotlin 同样⽀持浮点数的常规表⽰⽅法:
     *      默认 double：123.5 、123.5e10
     *      Float ⽤ f 或者 F 标记: 123.5f
     *
     *  数字字⾯值中的下划线（⾃ 1.1 起）
     *  你可以使⽤下划线使数字常量更易读:
     *
     */
    fun numberType() {
        var aInt: Int = 3
        var aDouble: Double = 3.0
        var aFloat: Float = 3.0f
        var aLong: Long = 123L
        var aShort: Short = 11
        println("aShort =" + aShort)
        var oneMillion = 1_000_000
        val creditCardNumber = 1234_5678_9012_3456L
        val socialSecurityNumber = 999_99_9999L
        val hexBytes = 0xFF_EC_DE_5E
        val bytes = 0b11010010_01101001_10010100_10010010
        println("oneMillion" + oneMillion)
        println("creditCardNumber" + creditCardNumber)
        println("socialSecurityNumber" + socialSecurityNumber)
        println("hexBytes" + hexBytes)
        println("bytes" + bytes)

    }

    //数字装箱：
    fun numberTest() {
        val a: Int = 10000
        println(a === a)
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        //注意数字装箱不⼀定保留同⼀性:
        println(boxedA === anotherBoxedA)
        //另⼀⽅⾯，它保留了相等性:
        println(boxedA == anotherBoxedA)
    }

    /**
     * 由于不同的表⽰⽅式，较⼩类型并不是较⼤类型的⼦类型。
     * 因此较⼩的类型不能隐式转换为较⼤的类型。这意味着在不进⾏显式转换的情况下我们不能把 Byte
     *型值赋给⼀个 Int 变量。
     * 算术运算会有重载做适当转换，
     *
     * 每个数字类型支持以下的显示转换：
     *              toByte(): Byte
     *              toShort(): Short
     *              toInt(): Int
     *              toLong(): Long
     *              toFloat(): Float
     *              toDouble(): Double
     *              toChar(): Char
     */
    fun naumberTest2() {
        val b: Byte = 1 //ok 字面值时静态检测
//        val i :Int = b  //error
        //我们可以显示转换
        val i: Int = b.toInt()

        val l = 1L + 3 // Long + Int => Long

        println("b = $b, i =$i ,l =$l")
    }


    /**
     * 1.2 字符：字符⽤ Char 类型表⽰
     *      字符字⾯值⽤单引号括起来: '1' 。特殊字符可以⽤反斜杠转义。
     *      ⽀持这⼏个转义序列：\t 、\b 、\n 、\r 、\' 、\" 、\\ 与 \$ 。
     *      编码其他字符要⽤ Unicode 转义序列语法：'\uFF00' 。
     *
     *      当需要可空引⽤时，像数字、字符会被装箱。装箱操作不会保留同⼀性。
     *  toInt() 方法返回的是对应的ASSIC码
     * */
    fun chartest(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of Range")
        return c.toInt() - '0'.toInt()
    }

    /**
     * 1.3 布尔：布尔⽤ Boolean 类型表⽰，它有两个值：true 与 false
     *
     *      若需要可空引⽤布尔会被装箱
     *      || – 短路逻辑或
     *      && – 短路逻辑与
     *      ! - 逻辑⾮
     *
     */

    /**
     * 1.4 数组：数组在 Kotlin 中使⽤ Array 类来表⽰，它定义了 get 与
     *          set 函数（按照运算符重载约定这会转变为[] ）以及 size 属性，以及⼀些其他有⽤的成员函数：
     *
     *     使⽤： 库函数 arrayOf() 来创建⼀个数组并传递元素值给它
     *            库函数 arrayOfNulls() 可以⽤于创建⼀个指定⼤⼩的、所有元素都为空的数组
     *            另⼀个选项是⽤接受数组⼤⼩以及⼀个函数参数的 Array 构造函数，⽤作参数的函数能够返回给定索引的每个元素初始值：
     *     [] 运算符代表调⽤成员函数 get() 与 set() 。
     *
     *  注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）。这意味着 Kotlin 不让我们把
     *  Array<String> 赋值给 Array<Any> ，以防⽌可能的运⾏时失败（但是你可以使⽤ Array<outAny> , 参⻅类型投影）
     *
     *     ⽆装箱开销的专⻔的类来表⽰原⽣类型数组:intArrayOf(),doubleArrayOf() ...
     *
     *  */
    fun arrayTest() {
        val arr = arrayOf(1, 2, 3)
        val arrOfNull = arrayOfNulls<String>(12)
        val arrString = Array(5) { i -> (i * i).toString() }
        for (item in arrString) {
            print("$item ,")
        }

    }


    /**
     * 1.5 无符号整型：⽆符号类型⾃ Kotlin 1.3 起才可⽤，并且⽬前是实验性的
     *
     *      Kotlin 为⽆符号整数引⼊了以下类型：
     *          kotlin.UByte : ⽆符号 8 ⽐特整数，范围是 0 到 255
     *          kotlin.UShort : ⽆符号 16 ⽐特整数，范围是 0 到 65535
     *          kotlin.UInt : ⽆符号 32 ⽐特整数，范围是 0 到 2^32 - 1
     *          kotlin.ULong : ⽆符号 64 ⽐特整数，范围是 0 到 2^64 - 1
     *
     */

    /**
     * 1.6 字符串: 字符串⽤ String 类型表⽰。
     *             字符串是不可变的
     *             字符串的元素——字符可以使⽤索引运算符访问str[i]
     *             可以⽤ for 循环迭代字符串:
     *                                  for (c in str) {
     *                                      println(c)
     *                                  }
     *             可以⽤ + 操作符连接字符串 val s = "abc" + 1
     *
     *  字符串字⾯值:
     *      有两种类型的字符串字⾯值:
     *              转义字符串可以有转义字符，
     *              以及原始字符串可以包含换⾏以及任意⽂本。
     *
     *              转义字符串很像 Java 字符串:
     *              val s = "Hello, world!\n"
     *              原始字符串 使⽤三个引号（ """ ）分界符括起来，内部没有转义并且可以包含换⾏以及任何其他字符:
     *              val text = """for (c in "foo")print(c)"""
     */

    fun stringTest() {

    }
}

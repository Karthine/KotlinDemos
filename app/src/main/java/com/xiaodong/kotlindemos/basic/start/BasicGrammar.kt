package com.xiaodong.kotlindemos.basic.start

/**
 * Created by xiaodong.jin on 2019/5/5 0005.
 * description：Kotlin基本语法
 */
fun main(args: Array<String>) {

    var mBasicGrammar = BasicGrammar()

    println("3+4=" + mBasicGrammar.sum(3, 4))

    mBasicGrammar.printSum(2, 2)

    mBasicGrammar.incrementR()

    mBasicGrammar.useString()

    println("4,6中大的值是" + mBasicGrammar.maxOf2(4, 6))

    mBasicGrammar.useFor()
    mBasicGrammar.useRange()
    mBasicGrammar.useCollection()

}

class BasicGrammar {

    /*
    * 1.定义函数
    * */

    //带有两个 Int 参数、返回 Int 的函数
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    //表达式作为函数体、返回值类型⾃动推断的函数：
    fun sum2(a: Int, b: Int) = a + b

    //函数返回⽆意义的值：
    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }

    //unit 返回类型可以省略：
    fun printSum2(a: Int, b: Int) {
        println("sum of $a and $b is ${a + b}")
    }

    /*
    * 2.定义变量
    * */
    fun variable() {
        //定义只读局部变量使⽤关键字 val 定义。只能为其赋值⼀次。
        val a: Int = 1 //需要立即复制
        val b = 1        //可以自动推断出'Int' 类型

        //可重新赋值的变量使⽤ var 关键字：
        var x = 5 //自动推断出类型
        x += 1
    }

    //顶层变量（对应Java中的属性）
    val PI = 3.14
    var r = 2
    fun incrementR() {
        println("the area is ${PI * r * r}")
    }

    /*
    * 3. 使用字符串
    * */
    fun useString() {
        var a = 1
        val s1 = "a is $a"
        println("current $s1")
        a = 2
        val s2 = "${s1.replace("is", "was")},but now is $a"
        println(s2)
    }

    /*
    * 4.使用条件表达式
    *
    * */
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    //可以直接使⽤ if 作为表达式:
    fun maxOf2(a: Int, b: Int) = if (a > b) a else b

    /*
    * 5.使用可空值及null检测
    * 当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引⽤可为空。
    * */
    //如果 str 的内容不是数字返回 null：
    fun parseInt(str: String): Int? {
        return str.toInt()
    }

    //使用返回可空值的函数时，要判空
    fun printproduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        // 直接使⽤ `x * y` 会导致编译错误，因为他们可能为 null
        if (x != null && y != null) {
            // 在空检测后，x 与 y 会⾃动转换为⾮空值（non-nullable）
            println(x * y)
        } else {
            println("either '$arg1' or '$arg2' is not a number")
        }

        //or
//        if (x == null) {
//            println("Wrong number format in arg1: '$arg1'")
//            return
//        }
//        if (y == null) {
//            println("Wrong number format in arg2: '$arg2'")
//            return
//        }
//        // 在空检测后，x 与 y 会⾃动转换为⾮空值
//        println(x * y)

    }


    /*
    * 6. 使⽤类型检测及⾃动类型转换
    * is 运算符检测⼀个表达式是否某类型的⼀个实例。如果⼀个不可变的局部变量或属性已经判断出为某
    * 类型，那么检测后的分⽀中可以直接当作该类型使⽤，⽆需显式转换：
    * */
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // `obj` 在该条件分⽀内⾃动转换成 `String`
            return obj.length
        }
        // 在离开类型检测分⽀后，`obj` 仍然是 `Any` 类型
        return null
    }

    //or
    fun getStringLength1(obe: Any): Int? {
        if (obe !is String) return null
        // `obj` 在这⼀分⽀⾃动转换为 `String`
        return obe.length
    }

    //or
    fun getStringLength2(obj: Any): Int? {
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }


    /*
    * 7.使用for循环
    * */
    fun useFor() {
        val items = listOf("apple", "banana", "kiwifruit")
        for (item in items) {
            println(item)
        }
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
    }

    /*
    * 8.使用while循环
    * */
    fun useWhile() {
        val items = listOf("apple", "banana", "kiwifruit")
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    /*
     *9.使用when表达式 （java中的switch）
     * */
    fun useWhen(obj: Any): String =
            when (obj) {
                1 -> "one"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a String"
                else -> "Unknown"
            }

    /**
     * 10.使用区间（range）
     * */

    fun useRange() {
        //使⽤ in 运算符来检测某个数字是否在指定区间内：
        val x = 10
        val y = 9
        if (x in 1..y + 1) {
            println("fits in range")
        }

        //检测某个数字是否在指定区间外:
        val list = listOf("a", "b", "c")
        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range, too")
        }

        //区间迭代
        for (x in 1..5) {
            print(x)
        }
        println()
        for (x in 1..10 step 2) {
            print(x)
        }
        println()
        for (x in 10 downTo 0 step 3) {
            print(x)
        }
    }

    /*
    * 11.使用集合
    * */
    fun useCollection() {
        //对集合进行迭代
        val items = listOf("小米", "华为", "oppo", "vivo", "魅族", "iphone")
        for (item in items) {
            print(item + ",")

        }
        when {
            "小米2" in items -> println("小米手机上榜了")
            "华为" in items -> println("华为手机也上榜了")
        }
        //使 ⽤ in 运算符来判断集合内是否包含某实例：

        //使⽤ lambda 表达式来过滤（filter）与映射（map）集合：
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { print(it+",") }
    }


}
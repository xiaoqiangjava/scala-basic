package com.xiaoqiang.scala.basic.function

/*
 * scala中的函数基本用法演示
 */
object FunctionBasic {

    def main(args: Array[String]): Unit = {
        // 如果函数没有参数列表，那么函数调用时可以省略后面的(), 如果不想执行函数，可以使用_占位符
        val v1 = f1 _
        // 调用v1
        v1()
        val v2 = f2 _ //由于f2的返回值是一个函数，那么想要调用时就需要加(), 而v2现在也是一个函数，调用时也要加()
        // 调用v2
        v2()()
    }

    def f1() = println("function")

    /*
     * 在scala中，对函数的调用有省略()的特性，所以当调用函数时可以不写()，这样的话要是我们只是想返回一个函数，
     * 而不是返回函数调用的结果的时候就有麻烦，因此scala中提供了一个占位符_，当我们赋值或者返回值只想返回函数
     * 而不是函数的调用结果的时候，就可以使用该占位符：f1 _
     */
    def f2() = f1 _
}

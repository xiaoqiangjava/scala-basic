package com.xiaoqiang.scala.basic.function
/*
 * scala中柯里化：将接受多个参数列表的函数转成成接受一个参数列表的函数的过程
 */
object CurryingDemo {
    def main(args: Array[String]): Unit = {
        // 定义一个柯里化方法有下面两种方式：
        // 方式一：直接指定多个参数列表
        def currying(x: Int)(y: Int) = x * y
        // 方式二：先指定一个参数列表，然后在函数体中指定一个参数列表
        def currying0(x: Int) = (y: Int) => x * y

        // 定义一个变量，将currying方法转换成函数，使用 方法 _可以将方法转成函数
        val curry = currying(10) _
        val curry0 = currying0(10)
        println("方式一：" + curry(10))
        println("方式二：" + curry0(10))
        // 使用隐式值可以不用传入参数, implicit参数必须在参数列表的最后面
        def currying1(x: Int)(implicit y: Int = 100) = x * y
        val res = currying1(10)
        println(s"res: $res")
        // 隐式参数可以在当前scope中声明，然后调用的时候编译器会自动找到声明的隐式变量
        // 隐式值在上下文中只能指定一个，不能指定多个隐式值
        implicit val xxx = 11
        println("res: " + currying1(11))

    }
}

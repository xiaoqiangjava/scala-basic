package com.xiaoqiang.scala.basic.varibale

/*
 * 变量的声明：var|val 变量名[: 变量类型] = 值
 * val声明的变量的值不能改变, 类似于Java中的final，底层反编译之后就是final修饰的
 * var声明的变量的值可以改变
 */
object VariableDemo {
    val age = 28
    def main(args: Array[String]): Unit = {
        var name = "xiaoqiang"
        println(name)
        println(age)
        name = "wenwen"
        println(name)
        // age = 30
    }
}

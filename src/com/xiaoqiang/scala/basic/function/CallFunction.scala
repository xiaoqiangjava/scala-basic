package com.xiaoqiang.scala.basic.function
// 导包时，_相当于Java中的*
// scala中的包不仅仅用于管理类，还可以当成对象使用，所以导包的时候，等同于把包对象引入到当前环境中，所以包对象中声明的函数可以直接调用
import scala.math._
/*
 * 函数的调用
 */
object CallFunction {
    def main(args: Array[String]): Unit = {
        println(sqrt(100))
    }
}

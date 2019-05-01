package com.xiaoqiang.scala.basic.lazydemo

/*
 * Scala中使用lazy关键字修饰的变量具有惰性，编译的时候不会运行
 * 只有当该变量使用的时候才会调用
 * lazy关键字只能修饰val定义的变量
 */
class LazyDemo {
    def call(): Unit = println("call method")
}

object LazyDemo {
    def main(args: Array[String]): Unit = {
        // 正常的加载逻辑
        val res = new LazyDemo().call()
        println("call 方法调用之后")
        println(res)
        // 使用lazy关键字修饰变量之后的逻辑
        lazy val rs = new LazyDemo().call()
        println("call 方法调用之后")
        println(rs)
    }
}
package com.xiaoqiang.scala.basic.method

object Methods {
    def main(args: Array[String]): Unit = {
        // method和function相似, 不同的是method需要关键字def来定义
        // def后面跟方法名称, 参数列表, 返回值, 注意返回值是在: Int指定
        // 用=分隔参数列表和body
        def addOne(x: Int): Int = x + 1
        println(addOne(1))
        // 方法可以有多个参数列表
        def addThenMutiply(x: Int, y: Int)(z: Int): Int = (x + y) * z
        println(addThenMutiply(2, 3)(4))
        // 方法可以不带参数列表, 不带参数类表时()可以省略
        def name: String = System.getProperty("user.name")
        println(name)
        // 当方法体中有多个表达式时需要使用{}, 跟function一样, 最后一个表达式就是整个
        // 方法的返回值, Scala中虽然有return关键字, 但是很少使用
        def mulLine(x: Int, y: Int)(z: Int): Int = {
            val sum = x + y
            sum * z
        }
        println(mulLine(2, 3)(4))
    }
}

package com.xiaoqiang.scala.basic.enum

/*
 * scala中没有枚举类型，需要继承Enumeration来实现相同的功能
 */
object EnumDemo {
    def main(args: Array[String]): Unit = {
        // 使用枚举
        println(Enum.RED)
    }
}

object Enum extends Enumeration {
    val RED = Value("red")
    val YELLOW = Value("yellow")
}
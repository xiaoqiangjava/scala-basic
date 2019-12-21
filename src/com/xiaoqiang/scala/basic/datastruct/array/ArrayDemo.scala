package com.xiaoqiang.scala.basic.datastruct.array

/*
 * scala中使用Array作为数组来使用
 */
object ArrayDemo {
    def main(args: Array[String]): Unit = {
        // 声明数组
        val arr = new Array[Int](10)
        println(arr)
        // 赋值，使用()来访问
        arr(0) = 1
        arr(1) = 2
        arr(2) = 3
        println(arr(1))
        // 第二种定义数组的方式: 使用Array的伴生对象中apply方法
        // 声明的Array其实是声明在scala的包对象中，而声明Array指向了scala.collection.immutable.Array, 即不可变数组
        val arr1 = Array(1, 2)
        println(arr1)
    }
}

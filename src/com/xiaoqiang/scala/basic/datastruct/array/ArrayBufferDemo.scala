package com.xiaoqiang.scala.basic.datastruct.array

import scala.collection.mutable.ArrayBuffer

/*
 * ArrayBuffer: scala.collection.mutable.ArrayBuffer是可变集合
 */
object ArrayBufferDemo {
    def main(args: Array[String]): Unit = {
        // 声明一个变长数组
        val buffer = new ArrayBuffer[Int]
        buffer.append(1)
        buffer.append(2)
        println(buffer)
        // 使用ArrayBuffer伴生对象的apply方法声明一个变长数组
        val buffer1 = ArrayBuffer[Int]()
        buffer1.append(3, 4, 5)
        // 修改指定位置的值
        buffer1(0) = 7
        println(buffer1)

        // 定长数组和变长数组的转换
        val arr = Array(1, 3, 5, 7, 9)
        // 将定长数组转换为变长数组
        val buffer2 = arr.toBuffer
        buffer2.append(2,  4, 6, 8)
        println(buffer2)
        // 将变长数组转成定长数组
        println(buffer.toArray)
    }
}

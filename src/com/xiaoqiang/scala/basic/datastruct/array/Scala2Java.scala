package com.xiaoqiang.scala.basic.datastruct.array

import scala.collection.mutable

/*
 * scala中集合和Java中的集合相互转换: 使用的是隐式转换
 */
object Scala2Java {
    def main(args: Array[String]): Unit = {
        val buffer = mutable.ArrayBuffer("ll", "ls", "cd")

        // scala中的变长数组转成Java中的集合, import引入的是一个隐式转换函数
        import scala.collection.JavaConversions.bufferAsJavaList
        val processBuilder = new ProcessBuilder(buffer)
        println(processBuilder.command())

        // Java中的数组转换为scala中的数组
        import scala.collection.JavaConversions.asScalaBuffer
        val scalaArr: mutable.Buffer[String] = processBuilder.command()
        println(scalaArr)

        // 数组的循环
        for (command <- buffer) {
            println(command)
        }
    }
}

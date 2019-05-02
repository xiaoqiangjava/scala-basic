package com.xiaoqiang.scala.basic.function

import scala.io.Source

class RichFile(val file: String) {
    def read() = {
        Source.fromFile(file).mkString
    }
}

object RichFile {
    def main(args: Array[String]): Unit = {
        // 正常的实现逻辑
        val file = "D:\\a.txt"
        val content = new RichFile(file).read()
        println(content)
        // 使用隐式转换函数实现--> 需要引入隐式转换函数，这里需要将Sting类型转成成RichFile类型
        // 通过隐式转换函数，String类型多出了一个read方法
        import MyPredef.file2RichFile
        println(file.read())
    }

}

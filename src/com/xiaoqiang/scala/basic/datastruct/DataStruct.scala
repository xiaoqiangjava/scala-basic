package com.xiaoqiang.scala.basic.datastruct

/*
 * SCALA中的数据结构：
 * SCALA中的集合主要包含在下面两个包中：
 * SCALA.COLLECTION.IMMUTABLE 不可变集合
 * SCALA.COLLECTION.MUTABLE   可变集合
 * SCALA中默认采用不可变集合，对于几乎所有的集合类，SCALA都同时提供了可变和不可变的版本。
 */
object DataStruct {
    def main(args: Array[String]): Unit = {
        // scala中的运算符：
        // 1. 中置运算符: 1 + 1等同于1.+(1)
        val x = 1 + 1
        println(x)
        // 后置运算符: oper++等同于oper.++
        val oper = new Operator
        oper++;
        // 前置运算符：前置运算符声明时，必须给操作符增加前缀：unary_ 否则声明的肯定时后置运算符, !oper等同于oper.unary_!
        println(!oper)
    }
}

class Operator {
    /*
     * 无参函数定义时，如果省略了括号，调用的时候必须省略，这个是为了访问一致性，如果声明时没有省略(), 那么调用时可以省略也可以不省略
     */
    def ++ = println("123")

    def unary_! = false
}

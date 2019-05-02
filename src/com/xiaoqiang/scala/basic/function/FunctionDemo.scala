package com.xiaoqiang.scala.basic.function

object FunctionDemo {
    def main(args: Array[String]): Unit = {
        // val是values的缩写, var是variable的缩写
        // scala中函数是一等公民, 即函数就是一个values
        // 函数可以带有参数列表, 需要声明参数类型
        // =>左边是参数列表, 右边是body
        // 函数的返回值类型需要指定A => B, 即接受参数列表的类型到返回值的类型
        val addOne: Int => Int = (x: Int) => x + 2
        println(addOne(1))
        // 带有两个参数的函数
        val addTwo = (x: Int, y: Int) => x + y
        println(addTwo(3, 5))
        // 不带参数的函数, 调用时需要加上()
        val add = () => 1 + 1
        println(add())
        // 匿名函数
        println((x: Int) => x + 1)
        // 当函数体有多个表达式时需要用{}包围, 最后一个表达式结果就是整个块的结果
        val addThree = (x: Int, y: Int, z: Int) =>{
            val sum = x + y
            sum + z
        }
        println(addThree(1, 2, 3))
    }
}

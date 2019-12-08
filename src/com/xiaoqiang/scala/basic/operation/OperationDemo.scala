package com.xiaoqiang.scala.basic.operation

/*
 * 1. 算术操作符重载：
 * +='*'/%在scala中可以完成与Java相同的操作，但是有一点区别，scala是完全面向对象语言，所以所有的运算符都是对象的运算行为，也就是所谓的对象的方法。
 * 1 + 2 相当于1.+(2), 即调用了1这个值对象的+方法。
 * 2. scala中没有++，--操作符，需要通过+=， -=来实现。
 * 3. 由于+也是方法，可以直接写成1 + 2，当有一个方法为其他名称时，也可以写成【对象 方法名 参数】
 */
object OperationDemo {
    def main(args: Array[String]): Unit = {
        val res = 1 + 2
        println(res)
        println(1.+(2))
        // 调用方法: 对象和方法之间用空格隔开
        val operation = new SumOperation
        println(operation sum 10)
    }
}

class SumOperation {
    def sum(x: Int) : Int = {
        10 + 10
    }
}

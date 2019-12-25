package com.xiaoqiang.scala.basic.partialFunction
/*
 * PartialFunction[-A, +B], 其中A是参数类型，B是返回值类型, -A是泛型的一种表示方法
 * -A传入的参数必须是A的父类或者A，+B传入的参数必须是B的子类或者是B
 * 偏函数常用作模式匹配
 * 偏函数主要用于模式匹配，模式匹配中省略了match，将{}中的多个case语句构成的代码块就叫偏函数。
 * 在对符合某个条件，而不是所有情况进行逻辑操作时，使用偏函数是一个不错的选择。
 */
object PartialFunctionDemo {
    // 使用正常的函数写法实现模式匹配--因为模式匹配时一个表达式，可以赋值给一个方法或者变量
    def m1(num: String): Int = num match {
        case "one" => {
            println("Case 1")
            1 //在代码块中，最后一个表达式表示的是返回值
        }
        case "tow" => {
            println("Case 2")
            2
        }
        case _ => {
            println("Not Match")
            0
        }
    }

    // 使用偏函数实现模式匹配
    def m2: PartialFunction[String, Int] ={
        case "One" => {
            println("Case one")
            1
        }
        case "tow" => {
            println("Case two")
            2
        }
        case _ => {
            println("Not match")
            0
        }
    }
    def main(args: Array[String]): Unit = {
        // 调用方法m1，正常的模式匹配用方法接收
        m1("one")
        // 调用方法m2，使用偏函数实现的模式匹配，虽然没有显示的指定参数列表
        // 但是在后面的偏函数中指定了需要传入的参数的类型
        m2("One")
        // 偏函数是个特质, 子类需要重写两个方法，isDefinedAt方法的返回值为true时，执行apply方法中的逻辑
        // 这种写法太复杂，scala中一种简单的写法是大括号包含的一组case语句
        def f = new PartialFunction[String, Int] {
            override def isDefinedAt(x: String): Boolean = true

            override def apply(v1: String): Int = v1.toInt
        }
        def f1: PartialFunction[String, Int] = {
            case "one" => 1
            case "two" => 2
        }
        // 将数组中的元素加1
        val list = List(1, 3, 5, 7, "null")
        // map函数不能接受偏函数，collect可以接受偏函数
        println(list.collect{case x: Int => x + 1})
    }
}

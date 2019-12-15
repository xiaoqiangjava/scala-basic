package com.xiaoqiang.scala.basic.Singleton

import scala.collection.mutable.ArrayBuffer

/*
 * 在Scala中没有静态方法和静态字段，但是可以使用object关键之加类名的语法结构时间同样的功能
 * 1. 工具类，存放常亮和工具方法
 * 2. 实现单例模式: scala中，单独的一个object就是单例的
 */
object SingletonDemo {
    def main(args: Array[String]): Unit = {
        val session = SessionFactory.getSession()
        println(session)
        println(session.head)
        println(session.size)
        println(session.tail)
        println(SessionFactory.i)
    }
}

/*
 * 对象中编写的代码相当于Java中静态块中的代码， 在类加载的时候里面的代码都会执行
 */
object SessionFactory{
    // 相当于Java中的静态块
    println("SessionFactory被执行了。。。")

    var i =  5

    private val session = new ArrayBuffer[Session]()

    while (i > 0) {
        session += new Session
        i -= 1
    }

    def getSession() = session
}

/*
 * scala中创建类时，可以不指定属性跟方法，这时候可以省略掉类后面的代码块表示符{}
 */
class Session

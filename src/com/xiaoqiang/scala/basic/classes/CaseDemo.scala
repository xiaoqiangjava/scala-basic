package com.xiaoqiang.scala.basic.classes

// case class可以直接用于比较, 并且case class必须带有参数列表
// case class是不可变的, 通过结构进行比较的, 不是通过引用
case class Point(x: Int)

object MainCase {
    def main(args: Array[String]): Unit = {
        // case classes 实例化时可以省略new关键字
        val point = Point(1)
        val anotherPoint = new Point(1)
        val yetPoint = new Point(2)
        if (point == anotherPoint) {
            println("point == anotherPoint")
        }else{
            println("point != anotherPoint")
        }
        if (point == yetPoint) {
            println("point == yetPoint")
        }
        else{
            println("point != yetPoint")
        }

        // 一个包里面只能有一个object, 因为object是单例的
        val dog = new XiaoDog
        dog.show
    }
}
package com.xiaoqiang.scala.basic.classes

trait TraitDemo {
    def help(): String

    def show(): Unit = {
        println("trait跟java中的abstract相似, 可以包含借口和方法")
    }
}

trait Dog {
    def show: Unit
}

class XiaoDog extends Dog {
    override def show: Unit = {
        println("帮助信息")
    }
}

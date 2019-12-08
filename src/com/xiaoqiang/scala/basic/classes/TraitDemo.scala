package com.xiaoqiang.scala.basic.classes

/*
 * Java中接口interface不属于类的体系关系，因此接口可以多继承，由于scala是完全面向对象的语言，而interface不属于面向对象的体系，所以
 * scala中没有interface的概念，但是由于需要满足Java的规范，因此引入了trait，编译之后是Java中的interface。
 * 在使用trait时，使用的是extends关键字，多继承时使用with关键字。
 */
trait TraitDemo {
    def help(): String

    def show(): Unit = {
        println("trait跟java中的abstract相似, 可以包含借口和方法")
    }
}

trait Dog {
    def show: Unit
}

trait Animal {

}

/*
 * scala中使用extends关键字来继承trait
 */
class XiaoDog extends Dog {
    override def show: Unit = {
        println("帮助信息")
    }
}

/*
 * 当一个类有多个特征时，使用extends .. with来实现
 */
class SmallDao extends Dog with Animal {
    override def show: Unit = ???
}

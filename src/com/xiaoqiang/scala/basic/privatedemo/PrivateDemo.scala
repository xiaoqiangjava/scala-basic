package com.xiaoqiang.scala.basic.privatedemo
/*
 * 类名前加private关键字是指包的访问权限，只有privatedemo这个包有访问权限
 * 在构造器参数列表前面加private关键字，表示伴生对象的权限，只有伴生对象才可以访问
 * 其他对象可以使用new关键字创建对象，但是不能访问参数列表中的值，可以编译，运行时报错
 */
private [privatedemo] class PrivateDemo private(val gender: String, var faceVal: Int) {
    // 私有属性，属性前面加private，次字段成为私有属性, 可以在伴生对象中访问
    private val name = "xiaoqiang"

    // 限制了this表示只能在本列中访问，伴生对象中也不能访问
    private [this] var age = 24

    private def sayHello(): Unit = println(s"xiaoqiang's age is $age")
}

object PrivateDemo{
    def main(args: Array[String]): Unit = {
        val demo= new PrivateDemo("女", 26)
        println(demo.faceVal)
        demo.sayHello()
    }
}

object Test{
    def main(args: Array[String]): Unit = {
        // 构造器被private修饰，可以创建，但是不能访问
//        val demo = new PrivateDemo()
//        println(demo.faceVal)
    }
}

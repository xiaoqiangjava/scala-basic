package com.xiaoqiang.scala.basic.apply

/*
 * 伴生类
 */
class Student {

}

/*
 * 伴生对象：伴生对象中可以声明apply方法，该方法时由scala自动调用的
 */
object Student {
    /*
     * apply方法类似于Java中的getInstance, 但是由scala自动调用的，可以使用伴生对象来创建伴生类的对象
     * 但是方法名称必须是apply
     */
    def apply(): Student = new Student()
}

object Main {
    def main(args: Array[String]): Unit = {
        // com.xiaoqiang.scala.basic.apply.Main$@47f37ef1
        println(Main)
        // 使用伴生对象的apply方法来创建伴生类的对象
        val student = Student.apply()
        println(student)
        // 该种方式可以简写为下面的形式，不使用new关键字，直接通过类名来调用
        // 需要注意的是：当apply方法没有参数列表时，如果省略了()，那么使用下面的方法来获取伴生类对象时，也不能写()
        // 伴生对象()就等同于Student.apply，即调用了apply方法。
        val stu = Student()
        println(stu)
    }
}

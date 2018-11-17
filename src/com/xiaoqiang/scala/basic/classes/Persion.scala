package com.xiaoqiang.scala.basic.classes

/*
 * 定义类时, 如果不指定val或者var, 则该属性时私有的, 只能在类的内部访问
 * 在外部是不可见的, 如果想要在外部访问, 需要用关键字: val或者var
 * 不用val/var声明时默认是val的, 不可修改
 */
class Person(val name: String, age: Int) {
    // you can define classes with class keyword followed it name
    // and constructor parameters
    private var phone: String = "150"
    def show: String = {
        name + "," + age
    }

    // age是私有的属性, 可以通过get方法访问
    def getAge = age

    def setAge_=(newVal: Int): Unit = {
        //age = newVal
    }

    def getPhone = phone

    def setPhone_=(newVal: String): Unit = {
        phone = newVal
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        val person = new Person("小强", 26)
        // method不带参数时可以省略()
        val message = person.show
        println(message)
        // 外部可以访问公共属性
        println(person.name)
        // 可以通过get方法访问私有属性
        println(person.getAge)
        // 通过set方法设置私有属性的值: set方法的语法: 方法名_=(newVal: Int): Unit = {}
        person.setPhone_=("1509532")
        println(person.getPhone)
    }
}

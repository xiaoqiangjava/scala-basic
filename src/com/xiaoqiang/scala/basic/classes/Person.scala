package com.xiaoqiang.scala.basic.classes

/*
 * 定义类时, 如果不指定val或者var, 则该属性时私有的, 只能在类的内部访问
 * 在外部是不可见的, 如果想要在外部访问, 需要用关键字: val或者var
 * 不用val/var声明时默认是val的, 不可修改
 */
class Person(val name: String, age: Int) {
    // you can define classes with class keyword followed it name
    // and constructor parameters
    // scala类中声明一个属性，必须显示的进行初始化，否则编译出错
    // 因为scala可以根据属性值进行推断类型，所以属性类型可以省略
    private var phone = "150"
    // 如果指定的类型为null，那么无法推断类型具体是什么，所以声明属性时需要指定类型，由于null不是面向对象的
    // 范畴，因此在scala中使用_来代替
    // 在scala中，声明属性，编译器会自动生成类似get/set方法，如果声明的属性时private，那么生成的都是get/set是private类型的
    private var adress: String = _

    //
    var id: Int = _
    def show: String = {
        name + "," + age
    }

    // age是私有的属性, 可以通过get方法访问
    def getAge = age

    def setAge(newVal: Int): Unit = {
        //age = newVal
    }

    def getPhone = phone

    def setPhone(newVal: String): Unit = {
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
        person.setPhone("1509532")
        println(person.getPhone)
        // scala中的set
        person.id = 20
        // scala中访问get
        println(person.id)
    }
}

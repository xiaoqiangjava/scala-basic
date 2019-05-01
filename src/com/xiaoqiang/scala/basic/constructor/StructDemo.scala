package com.xiaoqiang.scala.basic.constructor

/*
 * Scala中构造器声明在类名后面，val修饰的属性具有不可变性
 * gender：String没有指定val/var，默认情况下是被val修饰的，不可修改
 * 而且该属性只能在本类送访问，伴生对象中也不能访问
 * 在new一个对象实例时，该类中除了方法和函数不会执行以外，其他的表达式都会执行
 * @param name
 * @param age
 * @param gender
 */
class StructDemo(val name: String, var age: Int, gender: String) {
    // 类中的属性，可以使用_指定一个默认值，Int类型的默认值为0，引用类型的默认值为null
    var faceVal: Int = _
    // 类中声明属性时也可以将body体写在代码块中
    var personMap = {Map("name" -> name, "age" -> age, "gender" -> gender, "faceVal" -> faceVal)}
    // 辅助构造器，可以实现构造器的重载，使用this关键字声明，辅助构造器的第一行必须调用原构造器
    def this(name: String, age: Int, gender: String, faceVal: Int){
        this(name, age, gender)
        this.faceVal = faceVal
    }
    // gender没有指定val/var修饰，当外部需要访问该属性的值时需要指定get方法
    def getGender(): String = gender
}

object StructDemo {
    def main(args: Array[String]): Unit = {
        // 在伴生对象中访问类中的属性
        val s = new StructDemo("xiaoqiang", 26, "男", 100)
        s.age = 27
        // name是用val修饰的，具有不可变性，所以不能修改name的值
        println("age" + s.age)
        println("name" + s.name)
        println("gender" + s.getGender())
        println("faceVal" + s.faceVal)

    }
}

object TestDemo {
    def main(args: Array[String]): Unit = {
        // 在普通对象中访问类中的属性
        val s = new StructDemo("xiaoqiang", 26, "男")
        s.faceVal = 101
        println("faceVal: " + s.faceVal)
        println("name: " + s.name)
        println("age: " + s.age)
        // new 之后personMap会执行，此时没有指定faceVal的值，所以map中faceVal是默认值
        s.personMap.map(println(_))
    }
}
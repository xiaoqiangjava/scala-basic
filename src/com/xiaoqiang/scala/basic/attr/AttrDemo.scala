package com.xiaoqiang.scala.basic.attr

import scala.beans.BeanProperty

/*
 * scala中的属性，如果构造参数中的没有使用任何关键字修饰，那么scala中认为是一个局部变量，外部不能访问。
 * 使用val修饰时，具有只读属性，有get方法，使用var修饰时，可以读写。
 * Bean属性：为了适合Java中的某些框架，引入了@BeanPropery注解，该注解标注的属性，会生成Java中标准的get/set方法。
 */
object AttrDemo {
    def main(args: Array[String]): Unit = {
        val manager = new Manager("lisi", "技术部", 28)
        println(manager.age + "," + manager.dept)
        // 当使用@BeanProperty时，默认会具有Java中标准的get/set方法
        manager.setSkill("java")
        println(manager.getSkill)

    }
}

class Manager(name: String, val dept: String, var age: Int) {
    @BeanProperty var skill: String = _
}

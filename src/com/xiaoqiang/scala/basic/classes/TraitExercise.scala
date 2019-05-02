package com.xiaoqiang.scala.basic.classes
/*
 * 特质: 具有Java中接口和抽象类的特征，类似于Java8之后的接口，接口中可以有默认实现的方法
 */
object TraitExercise {
    def main(args: Array[String]): Unit = {
        val bird = new Bird
        // 调用实现了的属性
        println(bird.name)
        // 调用实现了的方法
        val str = bird.run()
        println(str)
        // 调用不需要实现的方法, 编译期不会报错，运行时报错NotImplementError
        bird.fight
    }
}

trait Flyable {
    // 声明一个没有实现的属性
    val distance: Int
    // 声明一个没有实现的方法
    def fight: Unit
    // 声明一个有实现的方法
    def fly = println(s"fly distance is $distance")
}

abstract class Animal {
    // 声明一个没有赋值的字段
    val name: String
    // 声明一个没有实现的方法
    def run(): String
    // 声明一个有实现的方法
    def climb: String = "I can climb"
}

class Bird extends Animal with Flyable {
    // 重写抽象类中未赋值的属性，实现抽象类或者接口中的变量时不能使用_来赋值默认值，否在会报错
    override val name: String = "nice"

    // 重写抽象类中未实现的方法, 不需要实现的方法可以使用???来代替
    override def run(): String = "nice is running"

    // 实现接口中未赋值的属性
    override val distance: Int = 1000

    // 实现接口中未实现的方法
    override def fight: Unit = ???

    // 实现接口中实现的方法
    override def fly: Unit = println(s"fly distance is $distance")
}
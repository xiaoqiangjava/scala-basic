package com.xiaoqiang.scala.basic.constructor

/*
 * Scala中有一个构造器比其他的 构造器都重要，我们称之为主构造器，其他的构造器我们称之为辅助构造器。
 * 主构造器的声明直接放置于类名后面。当主构造函数没有构造方法时，小括号可以省略。
 */
class Emp() {
    // 类体， 构造方法体
    println("emp...")
}

class Dept() {
    // 辅助构造器：辅助构造器和主构造器都是无参的，会报错, 即一个类中不能存在两个同样参数的构造器
    // 辅助构造器: 辅助构造器是不能直接构建对象，需要调用主构造器函数
    def this(name: String) {
        this()
        println("name: " + name)
    }

    def this(name: String, age: Int) {
        // 在辅助构造器中，一定要有调用主构造器的逻辑。无论是直接调用还是间接调用，必须要有调用主构造函数的逻辑在里面。
        this("wangwu") // 调用之前已经声明过的构造函数。一定要注意构造器的声明顺序，如果在该构造函数之前没有声明单参构造器，则会报错。
    }
}

class Dept1(name: String = "xiaoqiang", age: Int) {
    println(name + "," + age)
}

/*
 * 构造参数可以声明为私有的，需要使用private关键字，当主构造器为私有的时，无法在外部直接调用主构造参数来创建
 * 对象，这个时候需要使用辅助构造函数来创建
 */
class Dept2 private(){
    // 使用辅助构造函数来创建对象
    def this(name: String) {
        this
        println(name)
    }
}

// 由于伴生对象是单例的，所以伴生对象是不能声明构造器的
object Dept2 {

}


object ScalaObject {
    def main(args: Array[String]): Unit = {
        // 创建对象: 创建对象时会执行主构造函数, 所谓的主构造函数，其实就是类的主体内容，类中的所有内容都会执行。
        // 主构造函数没有参数时可以省略小括号，因此创建对象调用构造函数时，小括号也可以省略。
        val emp = new Emp
        val dept = new Dept("zhangsan")
        val dept1 = new Dept1(age = 30)
        val dept2 = new Dept1("xiaoqinag", 40)
        val dept3 = new Dept2("xiaoqiang")
    }
}



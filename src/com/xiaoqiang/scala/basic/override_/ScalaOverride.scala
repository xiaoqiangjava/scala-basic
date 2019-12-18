package com.xiaoqiang.scala.basic.override_

/*
 * scala中的继承：使用extends关键字
 * scala中明确规定，只要出现方法的重写，必须使用override关键字来声明
 * scala中的类型检查和类型转换
 * 检查：isInstanceOf[T] 相当于Java中的  name instanceOf T
 * 转换：asInstanceOf[T] 相关与Java中的  (T) name
 * 获取类型：classOf[T]或者name.getClass
 * scala中不允许super(param)
 * scala中只有子类的主构造器可以调用父类的构造器，因此在构造子类时，如果要调用父类构造器，可以传参给父类构造器
 *
 * scala中的重写： 在scala中一定要记得， 声明变量的时候，一定要注意生成的方法
 * def只能重写另一个def
 * val只能重写另一个val或者不带参数的def：因为scala中声明一个变量的同时，会为这个变量生成get方法，因此val可以重写get方法。
 * var只能重写另一个抽象的var：因为没有初始化的var，生成的方法也是抽象的，因此没有初始化的var属性所在的类一定是abstract修饰的。
 */
object ScalaOverride {
    def main(args: Array[String]): Unit = {
        val emp: Person = new Emp("xiaoqiang")
        println(emp.name)
        println(emp.test)
        // 类型检查
        println(emp.isInstanceOf[Person])
        // 获取类型
        println(classOf[Emp])
        println(emp.getClass)

        printNo(emp)
        printNo(new Student("wenwen"))
        println(emp.name)

        // java 动态绑定技术：Java在调用对象的成员方法时，会将方法与对象的实际内存进行绑定，然后调用内存中的方法。
        println(emp.age)

    }

    def printNo(person: Person): Unit = {
        if (person.isInstanceOf[Student]) {
            println(person.asInstanceOf[Student].sno)
        } else if (person.isInstanceOf[Emp]) {
            println(person.asInstanceOf[Emp].eno)
        } else {
            println("error")
        }


    }
}


abstract class Person(var pname: String) {
    var name: String = pname

    // 声明属性的同时声明了get方法age()
    val age: Int = 10

    // 抽象属性在编译成字节码时，会自动生成抽象方法，所以类必须声明为抽象类，我们的属相并不会声明出来。
    var gender: String

    def test = "123"

    // 抽象方法
    def hello()
}

/*
 * 将子类主构造函数里面的参数传递给父类的构造函数, 这种写法编译之后底层会调用super()
 */
class Emp(var ename: String) extends Person(ename) {
    val eno: Int = 10

    // 声明属性的同时声明了get方法age(), 因此需要override关键字
    override val age: Int = 40

    override var gender: String = _

    /*
     * 方法的重写，必须使用override关键字声明
     */
    override def test = "wenwen"

    def hello(): Unit = println("hello")
}

class Student(var sname: String) extends Person(sname) {
    val sno: Int = 20

    // 抽象属性在重写时，不需要override，因为抽象的必须要实现。
    var gender: String = _

    // 子类重写抽象方法不需要override
    def hello(): Unit = println("hello")
}

class Emp1(val ename: String) extends {
    // 预定以， 可以预定义一些属性。
} with Person(ename) {
    override var gender: String = _
    override val age: Int = _
}
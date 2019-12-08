package com.xiaoqiang.scala.basic.classes

/*
 * 1. scala中的get/set方法：
 * scala中不建议写get/set方法，编译器会自动生成类似get/set作用的方法，如果声明的属性时私有的，而且没有在伴生对象中
 * 设置属性的值，那么生成的get/set方法也是私有的，但要是在伴生对象中修改了属性的值，那么生成的get/set方法就是public的。
 * 如果声明的属性时public的，那么生成的get/set也是public的。
 *
 * 2. scala中为了访问一致性，一般不推荐开发人员自定义get/set方法。
 * 3. scala中声明一个属性，必须显示的初始化，可以使用_来表示默认值，引用类型的是null，Int的是0。
 * 4. scala中的方法其实就是函数，只是习惯上将对象中的函数称之为方法，声明跟函数式编程中函数的声明是一样的。
 * 5. scala是完全面向对象的语言，所以并没有静态操作，但是为了能够和Java交互，就产生了一种特殊的对象类模拟类对象，
 * 我们称之为类的伴生对象。伴生对象的名称和类的名称时一样的。因此当需要在类中写静态属性时，只需要将静态属性写在该类的伴生对象中即可。
 * 伴生对象中的属性和方法可以直接通过类名点的形式来访问，不需要具体的对象，跟Java中静态的概念非常相似。
 * 6. 虽然伴生对象中的属性和方法非常类似Java中的静态的概念，但是反编译之后看到底层的实现并不是静态的属性，只是模拟的静态的访问。从技术
 * 的角度来讲，scala中还是没有静态的内容，因为scala是完全面向对象的语言，只不过将伴生对象又生成一个新的类，实现属性的get方法调用。
 */
class Emp {
    // 在scala中声明属性时，可以通过_指定声明的变量的值为对应的类型的初始值，编译之后跟Java中的相同
    private var name: String = _

    var age: Int = _

    private var address = "西安"

    private val phone = "135xxxxxxxx"
}

/*
 * 伴生对象必须跟类的名称保持一致。
 */
object Emp {
    val sex = 1
    def main(args: Array[String]): Unit = {
        val emp = new Emp()
        // 直接给属性赋值，会调用编译器生成的set方法，访问调用的是get方法
        emp.name = "xiaoqiang"
        emp.age = 28
        emp.address = "陕西西安"
        printf("name: %s, age: %d, sex: %s, address: %s, phone: %s", emp.name, emp.age, Emp.sex, emp.address, emp.phone)
    }
}
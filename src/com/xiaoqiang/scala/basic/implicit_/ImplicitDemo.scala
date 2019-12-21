package com.xiaoqiang.scala.basic.implicit_

/*
 * scala中的隐式转换：
 * 0. 使用implicit关键字声明的函数称之为隐式函数，隐式转换也称之为类型转换，隐式函数一般只有一个参数列表和一个返回值类型
 * 1. 隐式转换函数与函数名称无关，只有函数的签名（参数列表和返回值类型）有关
 * 2. 在当前环境中，不能存在多个满足条件的隐式函数
 * 3. 当程序编译出错是，会在当前环境中的隐式函数列表中查找满足当前程序的隐式函数自动应用。
 * 4. 使用隐式转换实现丰富类库的作用
 * 5. 隐式参数：如果声明函数时将参数列表声明为implicit，调用时如果不显示的传参，则会在当前环境中寻找满足类型的隐式变量
 * 6. 在scala 2.10后可以声明隐式类：不能声明为顶级类
 *      6.1 其所带的构造参数有且只能有一个
 *      6.2 隐式类必须定义在类或者伴生对象或者包对象里
 *      6.3 隐式类不能是case class
 *      6.4 作用域内不能有与之相同名称的标识符
 * 7. 隐式的转换时机：
 *      7.1 当方法中的参数类型与目标类型不一致时
 *      7.2 当对象调用所在类中不存在的方法或者成员时，编译器会根据类型自动将对象进行隐式转换。
 * 8. 隐式转换的前提：
 *      8.1 不能存在二义性
 *      8.2 隐式操作不能嵌套
 */
object ImplicitDemo {
    def main(args: Array[String]): Unit = {
        implicit def double2int(x: Double) = x.toInt
        // 由于当前环境中存在将double转换成int的隐式函数，所以直接将一个浮点数赋值为一个int类型的变量不会报错。
        val x: Int = 3.5
        println(x)
        // MySQL中没有delete方法，当我们需要delete方法时，可以使用隐式转换，将MySql转换成DB类型，然后使用其delete方法
        val mysql = new MySql
        implicit def mysql2db(mysql: MySql) = new DB
        mysql.delete(1)
        implicit val name: String = "xiaoqiang"
        printName
        // 隐式类
        implicit class StringUtil(str: String) {
            def addSuffix() = str + "scala"
        }
        val str = "study ".addSuffix()
        println(str)
    }

    def printName(implicit name: String) = println(name)
}

class MySql {
    def insert(id: Int): Unit = {
        println("插入一条数据")
    }
}

class DB {
    def delete(id: Int) = {
        println("删除一条数据")
    }
}
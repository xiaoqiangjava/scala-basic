package com.xiaoqiang
package scala.basic.pkg

/*
 * scala中的包
 * 上面的写法相当于com.xiaoqiang.scala.basic.pkg
 * scala中的包可以嵌套使用：子包中可以直接访问父包中的类，不需要import，跟作用域的概念相似。
 * 包中可以嵌套包，也可以声明类，但是不能声明函数或者自定义变量。
 *
 * 包可以包含类，对象和特质，但不能包含函数和变量，为了弥补这一点，scala中提供了包对象的概念来解决这个问题。
 */
object PackageDemo {

}

package chapter {

    import com.xiaoqiang.scala.basic.pkg.chapter.section.Manager

    class User {

    }

    package section {
        class Manager {
            // 包中的对象直接可以访问包对象中声明的属性和方法。
            println(name)
        }
    }

    /*
     * 包对象，可以声明函数和属性, 名称需要和包的名称保持一致
     */
    package object section {
        val name = "zhangsan"
    }

    object User {
        def main(args: Array[String]): Unit = {
            val manager = new Manager
            println(manager)
        }
    }
}

package com.xiaoqiang.scala.basic.privatedemo

/*
 * scala中的protected比Java中的严格，Java中的protected是本类，本包以及子类可以访问，而在scala中protected只能是子类中访问。
 * scala中默认的权限时public，而Java中默认的权限时包权限，scala中需要指定包权限时，用private[报名] 来指定
 */
object ProtectedDemo {
    def main(args: Array[String]): Unit = {
        val manager = new Manager
        // 同包中不能访问protected权限的变量
        // println(manager.name)
        // private[privatedemo]指定包权限
        println(manager.age)
        // 导入的类的重命名: 如果存在多个重名的类，可以通过包的重命名进行修改名称，防止使用时用错
        import java.util.{HashMap=>JavaHashMap}
        val map = new JavaHashMap[String, String]()
    }
}

class Manager {
    protected var name: String = "xiaoqiang"

    private[privatedemo] var age: Int = 29
}

class ChildManager extends Manager {
    def test(): Unit = {
        println(name)
    }
}
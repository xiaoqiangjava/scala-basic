package com.xiaoqiang.scala.basic.function
/*
 * scala编译是从上往下编译的，如果将Context类放在下面，该隐式值将不会被引入
 */
object Context {
    implicit val name = "Java"
    implicit val name1 = "Python"
}

object CurryingExercise {
    // 定义一个柯里化方法
    def m1(str: String)(implicit name: String = "scala") ={
        println(str + " " + name)
    }
    def main(args: Array[String]): Unit = {
        // 隐式参数会在上下文作用域中查找可以使用的隐式类型传入相应的参数
        import Context.name1
        m1("Study")
    }
}

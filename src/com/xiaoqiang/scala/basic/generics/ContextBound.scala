package com.xiaoqiang.scala.basic.generics

/*
 * [A : B] 上下文定界，需要提供一个隐式值，使用implicity方法提取隐式值队象进行相应的操作
 * 会从上下文中寻找B类型的隐式值，并提取其对象
 */
class ContextBound[T : Ordering] {
    def choose(first: T, second: T): T = {
        val ord: Ordering[T] = implicitly[Ordering[T]]
        if(ord.gt(first, second)) first else second
    }
}

object ContextBound {
    def main(args: Array[String]): Unit = {
        val g1 = new Girl("wenwen", 25, 101)
        val g2 = new Girl("xiaoqiang", 26, 100)
        import com.xiaoqiang.scala.basic.function.MyPredef.OrderingGirl
        val choose = new ContextBound[Girl].choose(g1, g2)
        println(choose)
    }
}

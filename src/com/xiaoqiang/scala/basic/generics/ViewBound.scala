package com.xiaoqiang.scala.basic.generics

/*
 * [B <% A]视图定界，需要一个隐式转换函数
 * 在此案例中比较两个Girl对象，提供的隐式函数需要将Girl对象转换为Ordered[Girl]对象
 */
class ViewBound[T <% Ordered[T]] {
    def choose(first: T, second: T): T = if(first > second) first else second
}

object ViewBound {
    def main(args: Array[String]): Unit = {
        val g1 = new Girl("wenwen", 25, 100)
        val g2 = new Girl("xiaoqiang", 24, 99)
        import com.xiaoqiang.scala.basic.function.MyPredef.girl2Ordered
        val choose = new ViewBound[Girl].choose(g1, g2)
        println(choose)
    }
}
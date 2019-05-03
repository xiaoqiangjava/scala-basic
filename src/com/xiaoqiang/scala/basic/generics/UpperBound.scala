package com.xiaoqiang.scala.basic.generics

/*
 * upperbound 泛型上界
 */
class UpperBound[T <: Comparable[T]] {
    def choose(first: T, second: T): T = if(first.compareTo(second) > 0) first else second
}

object UpperBound {
    def main(args: Array[String]): Unit = {
        val g1 = new Girl("wenwen", 28, 99)
        val g2 = new Girl("xiaoqiang", 26, 90)

        val choose = new UpperBound[Girl].choose(g1, g2)
        println(choose)
    }
}

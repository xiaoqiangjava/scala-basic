package com.xiaoqiang.scala.basic.matcher
/*
 * 匹配数组，元组，集合
 */
object MatchList {
    def main(args: Array[String]): Unit = {
        // 匹配数组
        val arr = Array(4, 2, 5)
        arr match {
            case Array(4, x, y, z) => println(s"case: $x, $y, $z")
            case Array(_, x, y) => println(s"case: $x, $y")
            case _ => println("case nothing")
        }

        // 匹配元组
        val tuple = (2, 3, 4 )
        tuple match {
            case (1, x, y) => println(s"case: $x, $y")
            case (_, x, y) => println(s"case: $x, $y")
            case (x) => println(s"case: $x")
            case _ => println("Nothing")
        }

        // 匹配list
        val list = List(2, 2, 3, 4)
        list match {
            case 0 :: Nil => println("Case1: 0")
            case a :: b :: c :: Nil => println(s"case2: $a, $b, $c")
            case 1 :: a :: b :: c :: Nil => println(s"case3: $a, $b, $c")
            case a :: b :: c :: d => println(s"case4: $a, $b, $c, $d")
            case _ => println("Not match")
        }

    }
}

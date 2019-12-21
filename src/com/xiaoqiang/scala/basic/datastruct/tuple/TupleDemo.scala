package com.xiaoqiang.scala.basic.datastruct.tuple

/*
 * scala中的tuple元组: Tuple实际是一个case class，_1, _2...等都是case class中定义的属性，因此可以直接
 * 通过对象.的形式来访问，访问时访问的是get方法，只是get方法和属性同名而已
 */
object TupleDemo {
    def main(args: Array[String]): Unit = {
        // 声明一个元组, 元组的类型： Tuple1, Tuple2 ...
        val t1 = (1, "abc", true)
        println(t1)
        // 元组的访问, 通过顺序号访问，元组中的顺序号从1开始， _3是一个方法
        println(t1._3)
        // 通过下标访问元组：下标从0开始，使用的是productElement方法来访问下标
        println(t1.productElement(0))
        // 元组的遍历: 使用productIterator方法返回一个迭代器
        for (x <- t1.productIterator) {
            println(x)
        }
    }
}

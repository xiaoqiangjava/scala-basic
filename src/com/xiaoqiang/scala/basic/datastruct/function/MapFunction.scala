package com.xiaoqiang.scala.basic.datastruct.function

/*
 * 集合中的map方法:
 * 将集合中的每一个元素通过指定的功能映射成新的结果集合
 * flatMap方法：
 * 将集合中的每个元素的子元素映射到某个函数并返回新的集合，即如果集合中的元素也是一个集合的话，会将子元素分解成单个元素，然后将分解后的单个元素传递给
 * 指定的函数。
 * filter过滤，将集合中的每一个元素传递给指定的函数，当只当的函数返回的bool类型为true是，返回满足条件的元素组成的集合
 */
object MapFunction {
    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3)
        // 匿名函数
        val f: Int => Int = (x: Int) => x * 2

        def f1(x: Int): Int = x * 2
        var newList = list.map(_*2)
        newList = newList.map(f)
        newList = newList.map(f1)
        println(newList)
        val strList = List("Alice", "Bolb", "Nick")
        val strings = strList.map(_.toUpperCase())
        println(strings)
        // flatMap将集合中元素的子元素传递给指定的函数
        val chars = strList.flatMap(_.toUpperCase())
        println(chars)
        val filters = strList.filter(_.startsWith("A"))
        println(filters)

    }
}

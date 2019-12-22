package com.xiaoqiang.scala.basic.datastruct.list

/*
 * scala中的列表：List
 * 往集合中添加元素，有三个方法：+:, :+和::
 * +:表示往集合的头部添加元素，:+表示往集合的尾部追加元素, 使用::时，集合对象必须放置在后边
 */
object ListDemo {
    def main(args: Array[String]): Unit = {
        // 创建列表: 使用apply方法创建list。scala中默认使用的都是scala.collection.immutable中的集合
        // 默认创建的集合是不可变的
        val list = List(1, 3, 5)
        println(list)
        // 创建空列表
        val list1 = Nil
        println(list1)
        // 访问列表中的元素: 通过下标获取，类似于Array的操作
        println(list(0))
        // list元素的追加: list默认是一个不可变的列表，追加元素时，会生成一个新的列表，而list本身没有发生变化，这就是不可变，类似于Java中到了String
        val list2 = list :+ 99
        println(list)
        println(list2)
        val list3 = list.:+(100)
        println(list3)
        // 在列表的头部添加元素，+:  +靠近元素，:靠近list
        val list4 = 101 +: list
        println(list4)
        // list的创建和追加
        // 使用::运算符时，集合对象一定要放置在最右边，运算规则是从右向左，由于数字在前，因此是在头部增加元素。
        val list5 = 1 :: 2 :: 3 :: 4 :: list :: Nil
        val list6 = 1 :: 2 :: 3 :: 4 :: list
        println(list5) // List(1, 2, 3, 4, List(1, 3, 5))
        println(list6) // List(1, 2, 3, 4, 1, 3, 5)
        // :::表示将list中的元素添加集合Nil中
        val list7 = 1 :: 2 :: 3 ::4 :: list ::: Nil
        println(list7)
    }
}

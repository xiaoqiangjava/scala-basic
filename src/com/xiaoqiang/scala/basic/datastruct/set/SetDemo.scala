package com.xiaoqiang.scala.basic.datastruct.set

import scala.collection.mutable

/*
 * scala中的set
 */
object SetDemo {
    def main(args: Array[String]): Unit = {
        // 创建set, 默认是immutable的
        val set = Set(1, 2, 3)
        println(set)
        var set1 = mutable.Set(1, 2, 3)
        println(set1)
        // 增加元素
        set1.add(4)
        println(set1)
        // +=也可以增加元素
        set1 += 5
        println(set1)
        // .+会生成一个新的集合, .+ 也就是+
        set1 = set1 + 6
        println(set1)
        // 删除元素
        set1 -= 6
        println(set1)
        set1.remove(5)
        println(set1)

        // 循环遍历
        for (item <- set1) {
            println(item)
        }

    }
}

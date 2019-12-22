package com.xiaoqiang.scala.basic.datastruct.map

import scala.collection.mutable

/*
 * scala中的map映射: map中存储的元素类型是Tuple2
 */
object MapDemo {
    def main(args: Array[String]): Unit = {
        // 创建映射集合，默认使用的是不可变集合
        // 构建map中的元素时，集合中的元素其实是Tuple2类型
        val map = Map("name" -> "xiaoqiang", "age" -> 27)
        println(map)
        // 创建可变映射集合
        val map2 = mutable.Map("name" -> "xiaoqiang", "age" -> 27)
        println(map2)
        // 创建空的map集合
        val map3 = new mutable.HashMap[String, Int]()
        println(map3)
        // 使用元组的方式构建map
        val map4 = Map(("name", "xiaoqiang"), ("age", 27))
        println(map4)
        // 取值, 当指定的key不存在时，会抛出异常NoSuchElementException
        println(map("name"))
        // 使用get方法获取的是一个Option
        println(map.get("name"))
        // getOrElse当获取的值不存在时，给一个默认值
        println(map.getOrElse("wenwen", 28))
        // 更新映射中的数据
        map3("wenwen") = 29
        println(map3)
        // 追加元素
        map3 += ("D" -> 1)
        println(map3)
        // 删除元素: 删除不存在的元素，不会报错
        map3 -= "wenwen"
        map3 -= ("wenwen", "D")
        println(map3)

        // 增加多个元素: 使用+时，会生成一个新的map
        val map5 = map3 + ("A" -> 1, "B" -> 2)
        println(map5)
        // 遍历
        for ((k, v) <- map5) {
            println(k + ": " + v)
        }
        println("*" * 10)
        // 遍历所有的key
        for (k <- map5.keys) {
            println(k + ": " + map5(k))
        }
        println("*" * 10)
        // 遍历value
        for (v <- map5.values) {
            println("v: " + v)
        }
        // 直接循环: t是个元组Tuple2
        println("*" * 10)
        for (t <- map5) {
            println(t._1 + ": " + t._2)
        }
    }
}

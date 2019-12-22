package com.xiaoqiang.scala.basic.datastruct.queue

import scala.collection.mutable

/*
 * scala中的队列
 */
object QueueDemo {
    def main(args: Array[String]): Unit = {
        // 创建队列
        val queue = new mutable.Queue[Int]()
        println(queue)
        // 队列中追加元素: 使用+=,把+=后面的元素当做一个整体追加到queue中，如果需要添加集合中的元素，需要使用++=, 类似于list操作:::
        queue += 1
        queue +=2
        println(queue)
        // 往队列中追加list中的元素
        queue ++= List(3, 4, 5)
        println(queue)
        // 删除元素: 符合FIFO的规定，1先进，使用dequeue出队时先出
        queue.dequeue()
        println(queue)
        // 增加元素
        queue.enqueue(6, 7, 8)
        println(queue)
        // 返回队列中的第一个元素, 不会删除队列中的元素
        println(queue.head)
        // 返回队列中的最后一个元素, 不会删除队列中的元素
        println(queue.last)
        println(queue)
        // 返回队列中的尾部数据: 尾部数据就是排除头部的一个元素，剩下的数据集合称作尾部数据
        println(queue.tail)
    }
}

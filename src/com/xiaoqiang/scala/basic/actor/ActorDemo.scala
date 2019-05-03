package com.xiaoqiang.scala.basic.actor

import scala.actors.Actor

/*
 * Actor：Scala中利用actor模型实现并发编程，Java中需要实现的方法名是run，而在scala中需要实现的方法名
 * 是act，对应在Actor特质中
 * 启动线程的方法跟Java中相同，使用start方法
 */
object ActorDemo extends Actor{
    override def act(): Unit = {
        for(i <- 1 to 10) {
            println("act: " + i)
        }
    }
}

object ActorTest {
    def main(args: Array[String]): Unit = {
        // 使用start方法启动线程
        ActorDemo.start()
    }
}
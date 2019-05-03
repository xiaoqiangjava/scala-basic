package com.xiaoqiang.scala.basic.actor

import scala.actors.{Actor, Future}

/*
 * 用Actor实现同步和异步消息的发送以及接收
 * 发送消息的类型：
 * !  异步发送消息，没有返回值
 * !? 同步发送消息，有返回值
 * !! 异步发送消息，有返回值，使用Future对象接收，跟Java中类似
 */
class ActorMsg extends Actor {
    override def act(): Unit = {
        while(true) {
            // 接收消息的方法，需要传入一个偏函数作为参数类型
            receive(receiveFunc)
        }
    }

    def receiveFunc: PartialFunction[Any, Unit] = {
        case "start" => println("Starting")
        case AsyncMsg(id, msg) => {
            println(s"AsyncMsg--id: $id, msg: $msg")
            Thread.sleep(2000)
            sender ! ReplyMsg(5, "success")
        }
        case SyncMsg(id, msg) => {
            println(s"SyncMsg--id: $id, msg: $msg")
            Thread.sleep(2000)
            sender ! ReplyMsg(4, "success")
        }
    }
}

object ActorMsg {
    def main(args: Array[String]): Unit = {
        val actorMsg = new ActorMsg
        actorMsg.start()

        // 异步发送消息，没有返回值
        actorMsg ! AsyncMsg(4, "异步发送没有返回值的消息内容")
        println("异步没有返回值得消息发送成功")

        // 同步发送消息，线程等待返回值
        val res = actorMsg !? SyncMsg(5, "同步发送的消息内容")
        println("有返回值的同步消息发送成功")
        println("同步发送消息的返回值：" + res)

        // 异步发送消息，有返回值，返回值是Future[Any]类型
        val future: Future[Any] = actorMsg !! AsyncMsg(10, "异步发送的有返回值得消息类容")
        // 异步发送的又返回值的消息线程不会等待，直接拿返回值可能异步内容没有走完，拿不到返回值
        Thread.sleep(4000)
        if(future.isSet) {
            val content = future.apply()
            println("异步Result：" + content)
        }else{
            println("None")
        }
    }
}

case class AsyncMsg(id: Int, msg: String)

case class SyncMsg(id: Int, msg: String)

case class ReplyMsg(id: Int, msg: String)

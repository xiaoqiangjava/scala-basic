package com.xiaoqiang.scala.basic.actor

import scala.actors.{Actor, Future}
import scala.collection.mutable.ListBuffer
import scala.io.Source

/*
 * 使用Actor并发编程实现WordCount
 * 发送消息步骤：
 * 1. 创建Actor实例 task
 * 2. 调用start方法启动线程
 * 3. 发送消息，使用task !/!!/!?三种方法
 */
object ActorWordCount {
    def main(args: Array[String]): Unit = {
        val files: Array[String] = Array("D:\\data\\a.txt", "D:\\data\\b.txt", "D:\\data\\c.txt")
        val replyList = new ListBuffer[Future[Any]]
        val doneList = new ListBuffer[Map[String, Int]]
        for(file <- files) {
            val task = new Task
            task.start()
            val reply: Future[Any] = task !! SubmitTask(file)
            // 将每个文件读取的结果存放到listBuffer中
            replyList += reply
        }
        // 处理每个文件中的局部结果，得到全局的单词统计
        while(replyList.size > 0) {
            // 过滤掉返回为None的值
            val dones = replyList.filter(_.isSet)
            for(done <- dones){
                doneList += done.apply().asInstanceOf[Map[String, Int]]
                replyList -= done
            }
        }
        // 聚合
        val count = doneList.flatten.groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
        println(count)
    }
}

class Task extends Actor {
    override def act(): Unit = {
        /*
         * receive接受一个偏函数，可以在次数定义一个匿名偏函数，在scala中当
         * 如果参数列表是一个代码块的时候可以省略（）
         */
        receive{
            case SubmitTask(file) => {
                val lines: List[String] = Source.fromFile(file).getLines().toList
                val words: List[String] = lines.flatMap(_.split(" "))
                // 统计单词次数
                val res = words.map((_,1)).groupBy(_._1).mapValues(_.size)
                sender ! res
            }
            case _ => println("请输入正确的文件路径")
        }
    }
}

case class SubmitTask(file: String)

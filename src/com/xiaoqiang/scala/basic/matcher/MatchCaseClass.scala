package com.xiaoqiang.scala.basic.matcher

import scala.util.Random

/*
 * 模式匹配之样例类匹配case class
 * case class类默认提供了apply方法，实例化case class类时不需要使用new关键字
 * 在模式匹配中，匹配的类型会调用unapply方法提取构造器中的参数
 */
object MatchCaseClass {
    def main(args: Array[String]): Unit = {
        val array = Array(HeartBeat(1000), SubmitTask("00001", "1500"), CheckTimeoutTask)
        array(Random.nextInt(array.length)) match {
            case HeartBeat(time) => println(s"心跳时间： $time")
            case SubmitTask("00001", taskTime) => println(s"SubmitTask: $taskTime")
            case CheckTimeoutTask => println("CheckTimeoutTask")
        }
    }
}

case class HeartBeat(time: Long)

case class SubmitTask(id: String, taskTime: String)

case object CheckTimeoutTask
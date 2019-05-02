package com.xiaoqiang.scala.basic.matcher

import scala.util.Random

/*
 * 模式匹配之字符串匹配
 */
object MatchStr {
    def main(args: Array[String]): Unit = {
        val array = Array("zhoudongyu", "guanxiaotong", "yangzi", "zhengshuang")
        def matcher(param: String) = {
            param match {
                case "zhoudongyu" => println("周冬雨")
                case "guanxiaotong" => println("关晓彤")
                case "yangzi" => println("杨紫")
                case "zhengshuang" => println("郑爽")
                case _ => println("Nothing")
            }
        }
        val name = array(Random.nextInt(array.length))
        matcher(name)
    }
}

package com.xiaoqiang.scala.basic.matcher

import scala.util.Random

/*
 * 模式匹配之类型匹配
 */
object MatchType {
    def main(args: Array[String]): Unit = {
        val arr = Array("abcde", 100, 3.14, true, MatchType)
        // 使用一个方法接受match方法的返回值，在scala中有一种简便的写法叫做偏函数
        def matcher(param: Any) = {
            param match {
                case str: String => println(s"match String: $str")
                case int: Int => println(s"match Int: $int")
                case bool: Boolean => println(s"match boolean: $bool")
                case matchType: MatchType => println(s"match matchType: $matchType")
                case _: Any => println("not match")
            }
        }
        val typeVal = arr(Random.nextInt(arr.length))
        matcher(typeVal)
    }
}

class MatchType

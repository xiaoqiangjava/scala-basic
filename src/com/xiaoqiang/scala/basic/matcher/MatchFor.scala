package com.xiaoqiang.scala.basic.matcher

/*
 * for循环中使用模式匹配
 */
object MatchFor {
    def main(args: Array[String]): Unit = {
        // for遍历
        for ((k, v) <- Map("a"->1, "b"->2)) {
            println(s"$k, $v")
        }
        // for循环中会自动忽略匹配失败的结果: 只输出匹配的结果，类似于循环中的守卫。
        for ((k, 1) <- Map("a"->1, "b"->2)) {
            println(k)
        }
    }
}

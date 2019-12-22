package com.xiaoqiang.scala.basic.datastruct.function

/*
 * Reduce函数：化简，需要的函数必须接受两个参数列表, 参数的返回值类型和第一个参数的类型相同，reduce默认是reduceLeft, 即从左边开始，
 * 返回值结果放置在函数的左参数列表中。
 * reduceRight是从右边开始，将函数的运算结果放置在函数的第二个参数列表中，即右边的参数列表
 * fold函数：折叠，默认使用的是foldLeft()(),第一个参数放置在集合的左边即头部
 * foldRight是将第一个参数放置在集合的尾部，即右边
 * foldLeft和foldRight有一个简单的写法：/: 和:\
 * zip: 拉链，List(1, 2, 3), List(4, 5) 结果：List((1, 4), (2, 5))
 */
object ReduceFunction {
    def main(args: Array[String]): Unit = {
        // 创建数据列表
        val list = List(1, 2, 3, 4, 5)
        // 定义一个符合reduce函数签名的函数：接受两个参数列表，返回一个跟第一个参数类型相同的返回值
        def minus(x: Int, y: Int): Int = x - y
        // reduceLeft从左边化简: 将相邻的两个元素传递的minus函数中，然后将计算结果放置到第一个参数中，集合中的下一个元素做为minus函数的
        // 第二个参数，这也就是要求第一个参数的类型跟返回值类型的相同。
        // (((1-2)-3)-4)-5 = 13
        var res: Int = list.reduceLeft(minus)
        println(res)
        // reduceRight从右边化简
        // right函数将计算结果放置到第二个参数列表中
        // 1-(2-(3-(4-5))) = 3
        res = list.reduceRight(minus)
        println(res)
        // reduce默认是reduceLeft
        res = list.reduce(minus)
        println(res)

        // fold函数
        val list2 = List(2, 3, 4, 5)
        // foldLeft中的第一个参数是list中的head, (((1-2)-3)-4)-5 = -13
        res = list2.foldLeft(1)(minus)
        println(res)
        // foldRight中的第一个参数放在了集合的尾部
        // 2-(3-(4-(5-5))): right函数中将函数处理的结构传递给minus的第二个参数
        res = list2.foldRight(5)(minus)
        println(res)

        println(count("aaaabbbbcccc"))
    }

    /*
     * 统计给定的字符串中每个字符出现的次数
     */
    def count(content: String): Map[Char, Int] = {
        def sum(map: Map[Char, Int], char: Char): Map[Char, Int] = {
            map + (char -> (map.getOrElse(char, 0) + 1))
        }
        content.foldLeft(Map[Char, Int]())(sum)
    }
}

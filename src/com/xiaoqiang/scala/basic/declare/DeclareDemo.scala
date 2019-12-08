package com.xiaoqiang.scala.basic.declare

/*
 * scala中变量的声明：
 * 1. 如果首字符为操作运算符，那么后面的全部要跟运算符
 * 2. 用反引号`....`包含的任意字符串，即使是关键字也可以
 */
object DeclareDemo {
    def main(args: Array[String]): Unit = {
        // 1. 声明变量
        val user$name_1 = "xiaoqiang"
        // 2. 首字符为操作符, 后面的全部为运算符
        val +- = "name"
        val ++ = "age"
        printf("username: %s, %s, %s", user$name_1, +-, ++)
        // 3. 用反引号包含的任意字符串，可以是关键字
        val `true` = "true"
        val `+--` = "加号"
        println(`+--`)

    }

}

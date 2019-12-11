package com.xiaoqiang.scala.basic.exception

/*
 * scala中的异常处理
 */
object ExceptionDemo {
    def main(args: Array[String]): Unit = {
        // try的返回结果是程序运行的最后一行代码的值, 可能是异常里面的最后一行代码， 不是finally的值
        val res = try {
            val x = 10
            val y = 0
            x / y
        } catch {
            case e: ArithmeticException => e.printStackTrace()
            case e: Exception => e.printStackTrace()
        } finally {
            println("finally")
        }
        println("res: " + res)

        val num = try {
            f("abc")
        } catch {
            case e: NumberFormatException => 0
        }
        println("num: " + num)
    }

    /*
     * 可以使用throws注解声明一个函数可能抛出异常
     */
    @throws(classOf[NumberFormatException])
    def f(num: String): Int = num.toInt
}

package com.xiaoqiang.scala.basic.matcher

/*
 * 对象匹配：使用对象的unapply方法提取对象中的值，如果返回为Some则匹配成功，否则匹配失败。
 * case Test("123")当伴生对象创建对象的时候前面加了case就是提取unapply方法的返回值。
 * match之前的值传递给unapply方法作为参数，unapply函数的返回值给case后面的变量。
 */
object matchObj {
    def main(args: Array[String]): Unit = {
        // 对象匹配
        object Square {
            def unapply(number: Double): Option[Double] = Some(math.sqrt(number))
        }
        val number = 36.0
        number match {
            case Square(n) => println("n: " + n)
            case _ => println("nothing match")
        }
        println("*" * 10)
        // 匹配序列
        object Names {
            def unapplySeq(name: String) = if (name.contains(",")) {Some(name.split(","))} else None
        }
        val names = "Alice, Bob, Thomas"
        names match {
            case Names(x, y, z) => println("x: " + x + ", y: " + y + ", z" + z)
            case _ => println("match nothing")
        }
    }
}

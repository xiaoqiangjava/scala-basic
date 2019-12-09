package com.xiaoqiang.scala.basic.ctl

import util.control.Breaks._
/*
 * scala中的控制语句：
 * 1. scala中任意表达式都是有返回值的，也就意味着if else语句其实是有返回结果的，具体的返回结果取决于满足条件的最后一行代码执行结果
 * 2. 返回值得类型取决于各个分支的代码返回的类型，如果每个分支的类型相同，则直接推断出类型，否则是各个分支的返回类型的共同基类，不如Any
 * 3. 如果控制语句中只有一个if，那么不满足时scala认为返回值类型是Unit，因此表达式返回值的类型由另一个返回和Unit返回的共同超类决定。
 * scala中的for循环：to前后都是闭区间，util前闭后开区间
 * 1. scala也为for循环这一常见的控制结构提供了非常多的特性，这些for循环的特性成为for推导式。
 * 2. 循环的中断，不在使用关键字，而是采用函数式编程中的函数来实现类似的功能。
 * 3. 循环中可以引入循环守卫，类似于Java中的continue
 * 4. 循环返回值：将遍历之后生成的结果返回到一个新的列表中，使用yield关键字
 * scala中的while循环：
 * 1. while循环返回的类型是Unit，因此是()
 *
 */
object Control {
    def main(args: Array[String]): Unit = {
        val flag = 0
        // 控制语句有返回值
        val result = if (flag == 1) {
            1
        } else {
            println("flag != 1")
        }
        println("if结果：" + result)
        println("=========================")
        // while循环
        var n = 0
        val whileRes = while(n < 10) n += 1
        println("while结果：" + whileRes)
        println("=========================")
        // 循环的中断: 在scala中函数调用时的参数列表声明可以使用大括号{}来代替小括号()
        // 将一段逻辑代码作为参数传递给另一个函数，这个函数称之为高阶函数。
        breakable {
            while (n < 20) {
                n += 1
                if (n == 15) {
                    break() // break()函数抛出异常，breakable方法会捕获异常
                }
            }
        }
        // 调用函数时，参数列表可以使用{}来代替
        sum{n}
        println("=========================")
        // for循环: 全闭区间, to是个函数，第二个参数时步长
        val resFor = for (i <- 1 to (10, 2)) {
            println("i: " + i)
        }
        println("resFor: " + resFor)
        println("=========================")
        // for循环：前闭后开区间
        for (i <- 1 until 10) {
            println("i: " + i)
        }
        println("=========================")
        // 循环守卫: 当i!=3是不跳过循环进入下次循环
        for (i <- 1 until 5 if i != 3) {
            println("i: " + i)
        }
        println("=========================")
        // 在for中引入其他逻辑
        for (i <- 1 until 10; j = 4 - i ) {
            println("j: " + j)
        }
        println("=========================")
        // 嵌套for循环, 不需要写两层for循环
        for (i <- 1 until 3; j <- 1 until 5) {
            println("i: " + i + ", j: " + j)
        }
        println("=========================")
        // yield关键字使用: 表示将i放到一个新的集合中
        val res = for (i <- 1 until 5) yield i
        println("res yield: " + res)

    }

    def sum(x : Int) : Unit = { println(x)}
}

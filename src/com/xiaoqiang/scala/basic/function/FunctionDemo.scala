package com.xiaoqiang.scala.basic.function

/*
 * 函数在函数式编程中是一等公民，即函数跟其他的类型一样，都可以作为变量的声明，参数，返回值
 */
object FunctionDemo {
    def main(args: Array[String]): Unit = {
        // val是values的缩写, var是variable的缩写
        // scala中函数是一等公民, 即函数就是一个values
        // 函数可以带有参数列表, 需要声明参数类型
        // =>左边是参数列表, 右边是body
        // 函数的返回值类型需要指定A => B, 即接受参数列表的类型到返回值的类型
        val addOne: Int => Int = (x: Int) => x + 2
        println(addOne(1))
        // 带有两个参数的函数
        val addTwo = (x: Int, y: Int) => x + y
        println(addTwo(3, 5))
        // 不带参数的函数, 调用时需要加上()
        val add = () => 1 + 1
        println(add())
        // 匿名函数
        println((x: Int) => x + 1)
        // 当函数体有多个表达式时需要用{}包围, 最后一个表达式结果就是整个块的结果
        val addThree = (x: Int, y: Int, z: Int) =>{
            val sum = x + y
            sum + z
        }
        println(addThree(1, 2, 3))
        // 调用函数
        print("hello world")
    }

    /*
     * 声明一个函数: def 函数名[(参数名[: 参数类型]...)][: 返回值类型] = {函数体: 当函数body体只有一行时可以省略{}。}
     */
    def print(msg: String): Unit = println(msg)

    /*
     * 当函数只有一个参数列表时，小括号可以省略
     */
    def print: Unit = println("hello world")

    /*
     * 当函数没有返回值时，Unit可以省略
     */
    def printMsg = print

    /*
     * scala中可以不只用return来表示函数的返回值：
     * 1. 如果明确函数没有返回值，那么可以采用Unit来声明，类似于Java中的void
     * 2. 如果函数体采用return关键字返回结果，那么函数在声明时应该增加返回值类型
     *      2.1 如果返回值为Unit，那么return关键字会忽略，但是建议没有返回值时最好不要省略返回值类型
     * 3. 如果函数省略了函数的返回值类型，那么函数体中不能显示调用return关键字，函数体会根据最后一行代码来推断函数的返回值类型。
     */
    def sum(x: Int, y: Int) = x + y
}

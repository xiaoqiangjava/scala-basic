package com.xiaoqiang.scala.basic.datatype

/*
 * 1. scala中一切皆对象，所以没有基本类型，用的都是对象：Byte, Char, Short, Int, Long, Double, Float, Boolean, String称作常用类型。
 * 注：既然Java中的基本类型在Scala中都是对象，那么也就意味着Java中基本类型的数据在scala中都是可以调用对象的方法的。
 * 2. scala中所有的值都是类对象，而所有的类，包括值类型，都最终继承自一个统一的根类型Any。
 * 3. scala中定义了几个底层类型：Null, Nothing:
 *   3.1 Null是所有引用类型的子类，而Nothing是所有类型的子类，Null类型只有一个实例对象，null，类似于Java中的引用null。null可以赋值给任意
 *   引用类型，但是不能赋值为值类型。
 *   3.2 Nothing可以作为没有正常返回值得方法的返回类型，非常直观的告诉你这个方法不会正常返回，而且由于Nothing是其他任何类型的子类，它还能跟要求
 *   返回值的方法兼容。
 *   3.3 Unit类型用来标识过程，也就是没有明确返回值得函数。由此可见Unit类似于Java中的void。Unit只有一个实例，(), 这个实例也没有实质意义。
 */
object DataTypeDemo {
    def main(args: Array[String]): Unit = {
        // Java中的基本类型可以在scala中调用对象的方法, 编译之后1会被变成Integer
        println(1.toString)
        test
    }

    /*
     * Nothing类型是没有正常返回的返回值类型，Java中抛出受检异常时必须处理或者throws抛出，scala中只要Nothing标识就好。
     */
    def test: Nothing = {
        throw new Exception()
    }
}

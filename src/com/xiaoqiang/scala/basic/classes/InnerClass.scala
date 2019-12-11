package com.xiaoqiang.scala.basic.classes

import com.xiaoqiang.scala.basic.classes

/*
 * scala中的内部类:
 * Java中的内部类从属于外部类，scala中的内部类从属于实例
 */
object InnerClass {
    def main(args: Array[String]): Unit = {
        val outer: OuterClass = new OuterClass()
        // scala中创建内部类的方式跟Java中的不同，Java中是outer.new InnerClass()
        // scala中内部类从属于外部类的对象，所以外部类的对象不一样，创建出来的内部类的类型也不一样，无法互换使用
        val innerClass: outer.InnerClass = new outer.InnerClass()
        innerClass.test
        innerClass.print
        innerClass.alias
        // 静态内部类
        val staticInner: OuterClass.StaticInnerClass = new classes.OuterClass.StaticInnerClass()
        // 交互传参
        val outer1: OuterClass = new OuterClass()
        val outer2: OuterClass = new OuterClass()
        val inner1 = new outer1.InnerClass()
        val inner2 = new outer2.InnerClass()
        // inner1.test(inner2) // 报错
        inner1.test(inner1)
        inner2.test(inner2)
        // 类型投影： 忽略对象的创建方式
        inner1.test1(inner2)

    }
}

/*
 * 内部类成员
 */
class OuterClass {
    // 比较特殊的方式：给外部类起别名，用来在内部类中使用外部类的别名来访问外部类的属性
    outer =>
    class InnerClass {
        def test = println("test: " + name)
        // 通过类名.this访问外部类属性
        def print = println("name: " + OuterClass.this.name)
        // 通过别名来访问外部类的属性
        def alias = println("alias: " + outer.name)
        // scala中的内部类不能交互传参: 下面的写法类型是outer.InnerClass, 即外部对象.InnerClass
        def test(inner: InnerClass): Unit = println(inner)
        // scala中内部类的类型跟外部类对象密切相关，当需要对象之间交互传参数时，需要写成下面的方式
        // 在方法声明上，如果使用 外部类#内部类的方式传递类型，表示忽略内部类的对象关系，等同于Java中的语法操作，我们将这种方式成为"类型投影"
        // 这种传参忽略对象的创建方式，只考虑类型。
        def test1(inner: OuterClass#InnerClass): Unit = println(inner)
    }
    val name = "xiaoqiang"
}

/*
 * 静态内部类必须放置在伴生对象中
 */
object OuterClass {
    class StaticInnerClass {

    }
}
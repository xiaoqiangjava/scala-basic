package com.xiaoqiang.scala.basic.apply

/*
 * apply方法用于伴生对象中，创建对象时就可以省略new关键字，在伴生对象中使用类名加apply方法
 * 的参数列表形式就可以默认去调用apply方法，该方法的返回值是类对象
 * unapply方法用于提取一个对象中的值，返回值是一个Option对象，一般用于模式匹配中
 */
class ApplyDemo {
    var name: String = _

    var age: Int = _
    // 辅助构造器用于构造器方法的重载
    def this(name: String, age: Int){
        this()
        this.name = name
        this.age = age
    }
}

object ApplyDemo{ // ApplyDemo的类型是ApplyDemo$, ApplyDemo是一个对象
    /*
     * apply方法，参数列表可以与伴生类的构造器参数列表保持一致，也可以不用保持一直
     * apply方法类似于Java中getInstance方法，用来获取伴生类的实例
     */
    def apply(name: String, age: Int): ApplyDemo = new ApplyDemo(name, age)

    /*
     * unapply方法，参数列表是伴生对象对应的类实例，返回值是一个Option[(String, Int)], 返回的元组可以不包含所有的
     * apply参数列表，只需要返回需要提取的值即可
     */
    def unapply(arg: ApplyDemo): Option[(String, Int)] = if (arg == null) None else Some(arg.name, arg.age)
}

object Test{
    def main(args: Array[String]): Unit = {
        // 创建对象时调用伴生对象中的apply方法
        val demo = ApplyDemo("xiaoqiang", 26)
        // 模式匹配时，匹配类型的参数列表跟unapply方法返回的元组元素的个数要保持一直，不然会报错
        demo match {
            case ApplyDemo(name, 26) => println(s"name: $name")
            case _ => println("no match")
        }

    }
}

package com.xiaoqiang.scala.basic.matcher

/*
 * Scala中的模式匹配，类似于Java中的switch case, 但是功能比switch强大的多
 * 1. 模式匹配中的case可以匹配任何类型的值
 * 2. 如果在模式匹配的case后面跟变量名，那么match前表达式的值会赋值给那个变量
 * 3. 模式匹配的case后面可以增加守卫。
 * 4. 可以进行类型匹配，这样做的好处时避免使用isInstanceOf, asInstanceOf, case x: String => 这个写法跟异常中的写法是一回事。
 *    模式匹配在类型匹配时，不匹配泛型，但是Array[String], Array[Int]是能够匹配的，因为Array的底层他不是一个数组，是String[], int[].
 *    模式匹配类型时，如果变量名不使用，那么不需要声明，可以使用_来代替。
 * 5. 匹配数组、列表、元组：
 *    Array(0)匹配只有一个元素且为0的数组
 *    Array(x, y)匹配数组有两个元素，并将两个元素赋值给x和y
 *    Array(0, _*)匹配数组以0开始。
 * 6. 对象匹配：
 *    对象匹配：什么才算是匹配呢？即case中对象的unapply(提取器)方法返回some集合则为匹配成功，返回none则为匹配失败。match之前的变量会传递给unapply
 *    方法作为参数，unapply函数的返回值作为case后面的变量，当case后面的变量有多个时，就会调用unapplySeq函数，将返回值给case后面的多个参数。
 * 7. 变量声明中的模式匹配：match中的每一个case都可以单独提取出来，意思是一样的, 即省略match和case，只写case后面的部分。val(x, y) = (1, 3)
 *      val arr = Array(1, 2, 3, 5, 6) val Array(x, y, _*) = arr
 * 8. for循环中使用模式匹配，for循环中会自动忽略失败的匹配
 * 9. 模式匹配中匹配样例类：case class，匹配样例类跟匹配对象是一样的，匹配对象时需要自己手动写伴生对象，并且在伴生对象中声明unapply方法，而匹配样例类时，
 *    会自动生成unapply方法。当声明样例类时，一下几件事情会自动发生：1>. 构造器中的每一个参数都成为val--除非他被显示的声明为var。2>. 在伴生对象中提供apply
 *    方法，让你不用new关键字就能构造出相应的对象，比如：Dollar(21.32). 3>. 提供unapply方法，让模式匹配可以工作。4.> 将生成toString，hashCode，
 *    equals, copy方法。在样例类中可以直接使用copy方法和带名参数来赋值一个修改了某些属性的样例类   case class Dollar(value: Int, name: String)
 *    val x = Dollar(12, "$"); val y = x.copy(value=22);生成的y为：Dollar(22, "$);
 * 10. 匹配嵌套结构：可以通过@表示法将嵌套结构的值绑定到变量。rest@_*表示绑定剩余的到rest变量。art@Article(_, _)表示将Article(_, _)结构绑定到art
 * 11. 密封类：使用sealed关键字
 */
object MatchDemo {
    def main(args: Array[String]): Unit = {
        // 匹配字符串
        val str = "+=3!"
        for (i <- str.indices)
        str(i) match {
            case '+' => println("+")
            case '=' => println("=")
            case ch if Character.isDigit(ch) => println("number: " + Character.digit(ch, 10))
            case _ if str(i).toString.equals("!") => println("!")
            case _ => println("nothing")
        }
        // 模式匹配匹配泛型
        println("=" * 10)
        val i = 4
        val obj = if (i == 0) {
            i
        }else if (i == 1) {
            Array[Int](1, 2)
        }else if (i == 2) {
            Array[String]("scala", "java")
        }else if (i == 3) {
            Map[String, Int]("age" -> 27)
        }else if (i == 4) {
            Map[Int, String](1 -> "1")
        }else if (i == 5) {
            BigInt(3)
        }else {
            //
        }
        obj match {
            case _: Int => println("int")  // 不需要使用变量，因此使用_来代替。
            case _: Array[String] => println("str数组")
            case x: Array[Int] => println("int数组")
            case x: Map[String, Int] => println("map") // 由于模式匹配是不匹配泛型，因此不管是3还是4都会匹配到map
            case _: BigInt => println("BigInt")
            case _ => println("都不匹配")
        }
    }
}

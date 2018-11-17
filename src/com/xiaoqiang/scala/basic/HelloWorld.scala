package com.xiaoqiang.scala.basic

object HelloWorld{
    def main(args: Array[String]): Unit = {
        val a: Int = 2;
        val b: String = "xiaoqiang";
        val name_list: List[String] = List("张三", "李四", "王五")
        printf("a的值为: %d \n", a);
        printf("b的值为: %s \n", b);
        printf("name_list: %s \n", name_list)
        printf("Hello World! \n")
        for (name <- name_list) {
            println(name)
        }
        val age: Int = 23;
        if (age > 18) {
            println("你已经成年了")
        }
        else if (age > 6) {
            println("你是青少年")
        }
        else {
            println("你是一个孩子")
        }

        name_list.foreach((name: String) => printf(name + "; "))
    }
}

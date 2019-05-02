package com.xiaoqiang.scala.basic.function
/*
 * Scala内库中Predef类中声明了很多隐式转换函数
 * 隐式转换函数的作用：丰富类库，增加方法
 * 隐式函数：接受一个参数列表，返回一个新的参数列表，接受的参数为转换前的类型，返回的参数为转换后的类型
 */
object MyPredef {
    /*
     * 该隐式函数将String类型转换成了RichFile类型
     */
    implicit def file2RichFile(file: String) = new RichFile(file)
}

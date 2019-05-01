package com.xiaoqiang.scala.basic.list

/*
 * List常用操作
 */
object ListExercise {
    def main(args: Array[String]): Unit = {
        // 创建一个list
        val list0 = List(2,6,7,4,1,8,0,3,5,9)
        // 将list0中的每个元素乘以2之后生成一个新的集合
        val list1 = list0.map(_*2)
        println(list1)
        // 将list0中的所有偶数取出来之后生成一个新的集合
        val list2 = list0.filter(_ % 2 == 0)
        println(list2)
        // 将list0排序后生成一个新的集合
        val list3 = list0.sorted
        println(list3)
        // 反转排序顺序
        val list4 = list3.reverse
        println(list4)
        // 将list0中的元素每4个分成一组， 生成一个类型Iterator[List[int]]
        val iterator = list0.grouped(4)
        // println(iterator.toBuffer)  执行toBuffer方法之后Iterator中的元素为空
        // 将iterator类型转成一个List
        val list5 = iterator.toList
        println(list5)
        // 将多个list压扁成一个list
        val list6 = list5.flatten
        println(list6)
        // 先按空格切分， 在压平
        val list7 = List("Java Python Scala", "JS Jquery")
        val list8 = list7.flatMap(_.split(" "))
        println(list8)
        // 并行计算求和, 和线程有关，每个线程计算一部分
        val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        println(array.sum)
        val res = array.par.sum  // 并行计算求和
        println(res)
        // 按照特定的顺序进行聚合
        val res1 = array.reduce((x, y) => x + y)
        println(res1)
        val res2 = array.reduce(_+_)  // scala中当一个参数在函数体中只是用一次是，可以使用_代替
        println(res2)
        // 并行聚合
        val res3 = array.par.reduce(_+_)
        println(res3)
        // 聚合--fold方法需要指定初始值，聚合时会加上初始值
        val res4 = array.fold(10)(_+_)
        println(res4)
        val res5 = array.foldLeft(0)(_+_)
        println(res5)
        // 聚合--aggregate支持局部聚合, 第一个参数是初始值，后面两个参数，第一个参数可以接受两种不同类型的参数，
        // 第二个参数感觉没什么用，内部调用的是foldLeft(z:B)(op: (A, {}) => B)
        val list9 = List(List(1, 3, 4), List(2, 5, 6), List(7, 8, 9))
        val res6 = list9.aggregate(10)(_+_.sum, _*_)
        println(res6)
        val list10 = list9.flatten
        val res7 = list10.aggregate(10)(_+_, _+_)
        println(res7)
        // 求并集
        val lista = List(1, 2, 3)
        val listb = List(4, 5, 6, 3)
        val list11 = lista union(listb)
        println(list11)
        // 求交集
        val list12 = lista.intersect(listb)
        println(list12)
        // 求差集
        val list13 = lista.diff(listb)
        val list14 = listb.diff(lista)
        println(list13)
        println(list14)
    }
}

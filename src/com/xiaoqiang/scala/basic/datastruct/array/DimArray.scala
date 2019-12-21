package com.xiaoqiang.scala.basic.datastruct.array

/*
 * scala中多维数组
 */
object DimArray {
    def main(args: Array[String]): Unit = {
        // 多维数组[[1, 2, 3, 4], [2, 3, 4, 5], [3, 4, 5, 6]]
        val arr = Array.ofDim[Int](3, 4)
        println(arr)
        // 存值
        arr(0)(0) = 1
        arr(0)(1) = 2
        println(arr(0)(0))
    }
}

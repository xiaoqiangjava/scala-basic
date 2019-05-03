package com.xiaoqiang.scala.basic.function

import com.xiaoqiang.scala.basic.generics.Girl

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

    implicit def girl2Ordered(girl: Girl): Ordered[Girl] = new Ordered[Girl]{
        override def compare(that: Girl): Int = {
            if(girl.faceVal == that.faceVal) {
                // 当颜值相同时，选择年龄小的
                that.age - girl.age
            }else{
                girl.faceVal - that.faceVal
            }
        }
    }

    implicit object OrderingGirl extends Ordering[Girl]{
        override def compare(x: Girl, y: Girl): Int = x.faceVal - y.faceVal
    }
}

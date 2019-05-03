package com.xiaoqiang.scala.basic.generics

class Girl(val name: String, val age: Int, val faceVal: Int) extends Comparable[Girl]{
    override def compareTo(that: Girl): Int = this.faceVal - that.faceVal

    override def toString: String = s"name: $name, age：$age, faceVal: $faceVal"
}

package com.xiaoqiang.scala.basic.matcher

/**
  * 密封类：所有的样例类都写在同一个源文件中，使用sealed关键限制。
  */
abstract sealed class CaseClass {

}

case class A(s: String) extends CaseClass

case class B(s: String) extends CaseClass

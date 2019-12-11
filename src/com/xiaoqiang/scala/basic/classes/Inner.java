package com.xiaoqiang.scala.basic.classes;

/**
 * @author xiaoqiang
 * @date 2019/12/11 23:23
 */
public class Inner
{
    public static void main(String[] args)
    {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer.StaticInner staticInner = new Outer.StaticInner();
    }
}

class Outer {
    // 内部类里面不能有静态的方法或者属性
    class Inner {
        public void test()
        {

        }
    }

    static class StaticInner {
        public void test()
        {

        }
    }
}
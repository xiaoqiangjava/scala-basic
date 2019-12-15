package com.xiaoqiang.scala.basic.constructor;

/**
 * @author xiaoqiang
 * @date 2019/12/15 13:51
 */
public class JavaObject
{
    public static void main(String[] args)
    {
        User user = new User("xiaoqiang");
        User user1 = new User("xiaoqiang", 28);
    }
}

class User
{
    private String name;

    private Integer age;

    public User(String name)
    {
        // Java中在构造器中调用另一个构造器，使用this
        this(name, 10);
    }

    public User(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }
}
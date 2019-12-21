package com.xiaoqiang.scala.basic.traitdemo

/*
 * scala中的特质：使用extends关键字来实现一个特质，使用with关键字来实现多个特质, 特质中可以由默认实现的方法，类似于Java接口中的default
 */
object TraitDemo {
    def main(args: Array[String]): Unit = {
        val mysql = new Mysql
        mysql.insert(1)
        // getInterfaces方法获取的是类的直接接口，间接的接口不计入在内
        println(mysql.getClass.getInterfaces.length)
        // scala中在创建对象的时候可以动态混入(mixed in)特质，在不修改类的继承关系的前提下给类增加方法
        // 特别注意，使用动态混入特质时，Oracle类可以是abstract修饰的，此时创建对象不需要实现匿名子类
        // 同时混入多个特质时，称为叠加，混入时，特质的声明顺序是从左向右，方法执行的顺序是从右向左
        val oracle = new Oracle with DB
        oracle.insert(2)
        val mongoDB = new MongoDB with DB  // 实例化动态混入特质的抽象类，不需要{}
        mongoDB.insert(3)
        // 动态混入多个特质
        val oracle1 = new Oracle with DB with File
        // 输出的结果：从右向左的顺序执行方法
        // scala中特质中如果调用super，并不是表示调用父特质的方法，而是向左边继续查找特质，如果找不到，才会去父特质查找。
        // 如果想通过super直接调用具体特质的方法，可以指定：super[Operate].insert(),其中泛型必须是特质的直接超类型
        oracle1.insert(44)    // 向文件中往数据库中插入一条数据 = 44
    }
}

trait Operate {
    def insert(id: Int): Unit = {
        println("插入一条数据 = " + id)
    }
}

trait DB extends Operate {
    override def insert(id: Int): Unit = {
        print("往数据库中")
        super.insert(id)
    }
}

trait File extends Operate {
    override def insert(id: Int): Unit = {
        print("向文件中")
        super.insert(id)
    }
}

class Mysql extends DB {
    // 明确指定需要调用的超类的方法
    super[DB].insert(11)
}

class Oracle{

}

abstract class MongoDB {

}



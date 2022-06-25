package JDBC.Test;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 此类用于演示JDBC的步骤1:加载驱动
 * 类的加载时机:
 * 1.new 对象
 * 2.加载子类
 * 3.调用类的静态成员
 * 4.通过反射
 *
 * 使用new 对象的方式加载类的不足:
 * 1、属于编译器加载,如果编译期间该类不存在,则直接报编译错误,也就是依赖性太强
 * 2、导致Driver对象创建了两遍,效率较低
 * 采用反射的方式加载类!
 *1、属于运行期加载,大大降低了类的依赖性
 *2、Driver对象仅仅创建了1遍,效率较高
 *
 *
 * */

public class TestJDBC01 {
    public static void main(String[] args) throws Exception {
        //老方式 不推荐,加载两次
        DriverManager.deregisterDriver(new Driver());

        Class.forName("com.mysql.jdbc.Driver");


    }

}

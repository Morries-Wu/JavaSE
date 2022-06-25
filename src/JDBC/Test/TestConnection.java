package JDBC.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 此类用于演示JDBC的简单使用步骤
 * 前提:准备mysql的驱动包,加载到项目中
 *
 * 1、加载驱动
 * 2、获取连接
 * 3、执行增删改查操作
 * 4、关闭连接
 * */
public class TestConnection {
    private static String dbUrl = "jdbc:mysql://localhost:3306/girls?useUnicode=true&characterEncoding=UTF8&useSSL=false";// 数据库连接地址
    private static String dbUserName = "root";// 用戶名
    private static String dbpassword = "qq1802702683";// 密碼
    private static String jdbcName = "com.mysql.jdbc.Driver";// 驱动名称


    // 获取数据库连接
    public static void main(String[] args) throws Exception {
        //1、加载驱动
        Class.forName(jdbcName);
        //2、获取连接
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbpassword);
        //3、执行增删改查

        //3.1、编写sql语句
        //删除
        //String sql = "delete from beauty where id=9";
        //更新
        //String sql = "update beauty set name='关晓彤' where id=1";
        //增加
        String sql = "insert into beauty values(null,'小龙女','女','1998-1-1','100',null,3)";

        //3-2、获取执行sql语句的命令对象
        Statement statement = con.createStatement();
        //3-3、使用命令对象执行sql语句
        int update = statement.executeUpdate(sql);
        //3-4、处理执行结果
        System.out.println(update > 0 ? "success" : "failure");
        //4、关闭连接
        statement.close();
        con.close();
    }

}

package JDBC.Test;
/*
 * 此类用于演示Preparestatement和Statement的区别
 * 案例:登录验证
 *
 *
 * 使用Preparedstatement的好处:
 * 1、不再使用+拼接SQL语句,减少语法错误,语义性强
 * 2、将模板sql(固定的部分)和参数部分进行了分离,提高了维护性
 * 3、有效的解决了sql注入问题
 * 4、效率高
 * 10条sql语句,仅仅只是参数不同
 * 使用Statement,则需要编译10次,执行10次
 * 使用PreparedStatement,只需要编译1次,执行10次
 *
 * */

import JDBC.Utils.JDBCUtils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class TestPrepareStatement {

    //使用Statement实现登录
    public void testStatement() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please inptut username:");
        String username = input.next();
        System.out.println("Please inptut password:");
        String pwd = input.next();


        //--------------以下为连接数据库的步骤-----------------------
        //1、获取Properties对象
        Properties info = new Properties();
        info.load(new FileInputStream("src\\JDBC\\jdbc.properties"));
        info.list(System.out);
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String driver = info.getProperty("driver");
        String url = info.getProperty("url");

        //1、注册驱动
        Class.forName(driver);
        //2、获取连接
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("连接成功");

        //3、执行查询
        String sql = "select count(*) from admin where username=" + username + " and password=" + pwd;
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println(count > 0 ? "Login Success" : "Login Failure!");
        }

        //4、关闭
        resultSet.close();
        statement.close();
        con.close();
    }

    //使用PreparedStatement实现登录
    public void testPreparedStatement() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please inptut username:");
        String username = input.next();
        System.out.println("Please inptut password:");
        String pwd = input.next();


        //--------------以下为连接数据库的步骤-----------------------
        //1、获取连接
        Connection con = JDBCUtils.getConnection();

        //3、执行查询
        //3-1、编写sql
        String sql = "select count(*) from admin where username=? and password=?";
        //3-2、获取Preparedstatement命令对象
        PreparedStatement statement = con.prepareStatement(sql);

        //3-2、设置占位符的值
        statement.setString(1, username);
        statement.setString(2, pwd);

        //3-3、执行SQL命令
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println(count > 0 ? "Login Success" : "Login Failure!");
        }
        //4、关闭
        JDBCUtils.close(null, statement, con);
    }

    public static void main(String[] args) throws Exception {
        new TestPrepareStatement().testPreparedStatement();
    }

}

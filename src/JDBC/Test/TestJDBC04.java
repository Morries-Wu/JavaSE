package JDBC.Test;
/*
 * 此类用于演示JDBC的使用步骤2:获取连接
 *
 *
 *
 * */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

public class TestJDBC04 {
    public static void main(String[] args) throws Exception {

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
        //3、执行增删改查
        String sql = "select id,name,sex,borndate from beauty";
        //获取执行SQL命令对象
        Statement statement = con.createStatement();//创建一个statement对象将SQL语句发送到数据库
        //执行SQL语句
        //boolean execute = statement.execute(sql);//可以执行任何的SQL语句
        //int update = statement.executeUpdate(sql);//执行增删改语句
        ResultSet resultSet = statement.executeQuery(sql); //执行查詢语句,返回一个结果集
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        resultSet.close();
        statement.close();
    }

}

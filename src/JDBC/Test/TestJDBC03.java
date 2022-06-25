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
import java.util.Properties;

public class TestJDBC03 {
    public static void main(String[] args) throws Exception {

        //1、获取Properties对象
        Properties info = new Properties();
        info.load(new FileInputStream("src\\JDBC\\jdbc.properties"));
        info.list(System.out);
        String user = info.getProperty("user");
        String password = info.getProperty("passoword");
        String driver = info.getProperty("driver");
        String url = info.getProperty("url");

        //1、注册驱动
        Class.forName(driver);
        //2、获取连接
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("连接成功");

    }

}

package JDBC.Test;

import java.sql.DriverManager;

public class TestJDBC02 {
    public static void main(String[] args) throws Exception {
        //方式一、获取连接
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接
        DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?user=root&password=qq1802702683");

    }
}

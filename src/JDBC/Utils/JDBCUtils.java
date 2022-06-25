package JDBC.Utils;
/*
 * 此类是封装JDBC连接工具类
 * 功能:
 * 1、获取连接
 * 2、释放资源
 *
 *
 * */


import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    static String user;
    static String password;
    static String url;
    static String driver;


    static {
        try {
            //--------------以下为连接数据库的步骤-----------------------
            //1、获取Properties对象
            Properties info = new Properties();
            info.load(new FileInputStream("src\\JDBC\\lib\\jdbc.properties"));
            info.list(System.out);
            user = info.getProperty("user");
            password = info.getProperty("password");
            driver = info.getProperty("driver");
            url = info.getProperty("url");
            //1、注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //2、获取连接
    public static Connection getConnection() {
        try {
            System.out.println("连接数据库成功");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet set, Statement statement, Connection con) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }




    public static void main(String[] args) {
        JDBCUtils.getConnection();
    }
}

package JDBC.Utils;
/*
 * �����Ƿ�װJDBC���ӹ�����
 * ����:
 * 1����ȡ����
 * 2���ͷ���Դ
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
            //--------------����Ϊ�������ݿ�Ĳ���-----------------------
            //1����ȡProperties����
            Properties info = new Properties();
            info.load(new FileInputStream("src\\JDBC\\lib\\jdbc.properties"));
            info.list(System.out);
            user = info.getProperty("user");
            password = info.getProperty("password");
            driver = info.getProperty("driver");
            url = info.getProperty("url");
            //1��ע������
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //2����ȡ����
    public static Connection getConnection() {
        try {
            System.out.println("�������ݿ�ɹ�");
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

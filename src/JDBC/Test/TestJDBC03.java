package JDBC.Test;
/*
 * ����������ʾJDBC��ʹ�ò���2:��ȡ����
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

        //1����ȡProperties����
        Properties info = new Properties();
        info.load(new FileInputStream("src\\JDBC\\jdbc.properties"));
        info.list(System.out);
        String user = info.getProperty("user");
        String password = info.getProperty("passoword");
        String driver = info.getProperty("driver");
        String url = info.getProperty("url");

        //1��ע������
        Class.forName(driver);
        //2����ȡ����
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("���ӳɹ�");

    }

}

package JDBC.Test;

import java.sql.DriverManager;

public class TestJDBC02 {
    public static void main(String[] args) throws Exception {
        //��ʽһ����ȡ����
        //1��ע������
        Class.forName("com.mysql.jdbc.Driver");
        //2����ȡ����
        DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?user=root&password=qq1802702683");

    }
}

package JDBC.Test;
/*
 * ����������ʾPreparestatement��Statement������
 * ����:��¼��֤
 *
 *
 * ʹ��Preparedstatement�ĺô�:
 * 1������ʹ��+ƴ��SQL���,�����﷨����,������ǿ
 * 2����ģ��sql(�̶��Ĳ���)�Ͳ������ֽ����˷���,�����ά����
 * 3����Ч�Ľ����sqlע������
 * 4��Ч�ʸ�
 * 10��sql���,����ֻ�ǲ�����ͬ
 * ʹ��Statement,����Ҫ����10��,ִ��10��
 * ʹ��PreparedStatement,ֻ��Ҫ����1��,ִ��10��
 *
 * */

import JDBC.Utils.JDBCUtils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class TestPrepareStatement {

    //ʹ��Statementʵ�ֵ�¼
    public void testStatement() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please inptut username:");
        String username = input.next();
        System.out.println("Please inptut password:");
        String pwd = input.next();


        //--------------����Ϊ�������ݿ�Ĳ���-----------------------
        //1����ȡProperties����
        Properties info = new Properties();
        info.load(new FileInputStream("src\\JDBC\\jdbc.properties"));
        info.list(System.out);
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String driver = info.getProperty("driver");
        String url = info.getProperty("url");

        //1��ע������
        Class.forName(driver);
        //2����ȡ����
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("���ӳɹ�");

        //3��ִ�в�ѯ
        String sql = "select count(*) from admin where username=" + username + " and password=" + pwd;
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println(count > 0 ? "Login Success" : "Login Failure!");
        }

        //4���ر�
        resultSet.close();
        statement.close();
        con.close();
    }

    //ʹ��PreparedStatementʵ�ֵ�¼
    public void testPreparedStatement() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please inptut username:");
        String username = input.next();
        System.out.println("Please inptut password:");
        String pwd = input.next();


        //--------------����Ϊ�������ݿ�Ĳ���-----------------------
        //1����ȡ����
        Connection con = JDBCUtils.getConnection();

        //3��ִ�в�ѯ
        //3-1����дsql
        String sql = "select count(*) from admin where username=? and password=?";
        //3-2����ȡPreparedstatement�������
        PreparedStatement statement = con.prepareStatement(sql);

        //3-2������ռλ����ֵ
        statement.setString(1, username);
        statement.setString(2, pwd);

        //3-3��ִ��SQL����
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println(count > 0 ? "Login Success" : "Login Failure!");
        }
        //4���ر�
        JDBCUtils.close(null, statement, con);
    }

    public static void main(String[] args) throws Exception {
        new TestPrepareStatement().testPreparedStatement();
    }

}

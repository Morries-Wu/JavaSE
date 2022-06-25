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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

public class TestJDBC04 {
    public static void main(String[] args) throws Exception {

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
        //3��ִ����ɾ�Ĳ�
        String sql = "select id,name,sex,borndate from beauty";
        //��ȡִ��SQL�������
        Statement statement = con.createStatement();//����һ��statement����SQL��䷢�͵����ݿ�
        //ִ��SQL���
        //boolean execute = statement.execute(sql);//����ִ���κε�SQL���
        //int update = statement.executeUpdate(sql);//ִ����ɾ�����
        ResultSet resultSet = statement.executeQuery(sql); //ִ�в�ԃ���,����һ�������
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

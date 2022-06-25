package JDBC.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ����������ʾJDBC�ļ�ʹ�ò���
 * ǰ��:׼��mysql��������,���ص���Ŀ��
 *
 * 1����������
 * 2����ȡ����
 * 3��ִ����ɾ�Ĳ����
 * 4���ر�����
 * */
public class TestConnection {
    private static String dbUrl = "jdbc:mysql://localhost:3306/girls?useUnicode=true&characterEncoding=UTF8&useSSL=false";// ���ݿ����ӵ�ַ
    private static String dbUserName = "root";// �Ñ���
    private static String dbpassword = "qq1802702683";// �ܴa
    private static String jdbcName = "com.mysql.jdbc.Driver";// ��������


    // ��ȡ���ݿ�����
    public static void main(String[] args) throws Exception {
        //1����������
        Class.forName(jdbcName);
        //2����ȡ����
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbpassword);
        //3��ִ����ɾ�Ĳ�

        //3.1����дsql���
        //ɾ��
        //String sql = "delete from beauty where id=9";
        //����
        //String sql = "update beauty set name='����ͮ' where id=1";
        //����
        String sql = "insert into beauty values(null,'С��Ů','Ů','1998-1-1','100',null,3)";

        //3-2����ȡִ��sql�����������
        Statement statement = con.createStatement();
        //3-3��ʹ���������ִ��sql���
        int update = statement.executeUpdate(sql);
        //3-4������ִ�н��
        System.out.println(update > 0 ? "success" : "failure");
        //4���ر�����
        statement.close();
        con.close();
    }

}

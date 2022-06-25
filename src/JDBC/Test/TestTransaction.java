package JDBC.Test;


import JDBC.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * ����������ʾJDBC�е�����
 *
 * ʹ�ò���:
 * 1������������
 * ȡ����ʽ�����Զ��ύ�Ĺ���
 * setAutoCommit(false);
 *
 * 2����д��������һ��sql���
 * commit();�ύ
 * rollback();�ع�
 * ϸ��:
 * Ҫ������������Ӷ���ͻ�ȡ��������Ӷ��������ͬһ��������������Ч
 *
 * 3����������
 *
 * ����:ת�˰���
 * ����������ʦ̫ת5000
 *
 * */
public class TestTransaction {


    public void testNoTransaction() throws Exception {
        //1����ȡ����
        Connection con = JDBCUtils.getConnection();

        //2��ִ��sql���
        PreparedStatement pst = con.prepareStatement("update account set balance=? where username=?");

        //����1:�������Ǯ-5000
        pst.setDouble(1, 5000);
        pst.setString(2, "������");
        pst.executeUpdate();

        //����2:���ʦ̫��Ǯ+5000
        pst.setDouble(1, 15000);
        pst.setString(2, "���ʦ̫");
        pst.executeUpdate();

        //3���ͷ���Դ
        JDBCUtils.close(null, pst, con);
    }

    //ʹ������
    public void testTransaction() {

        Connection con = null;
        PreparedStatement pst = null;
        try {
            //1����ȡ����
            con = JDBCUtils.getConnection();

            //�����ʹ�ò���1:��������
            con.setAutoCommit(false);

            //�����ʹ�ò���2:��дsql���,��ִ��
            pst = con.prepareStatement("update account set balance=? where username=?");

            //����1:�������Ǯ-5000
            pst.setDouble(1, 5000);
            pst.setString(2, "������");
            pst.executeUpdate();

            //ģ���쳣
            //int i = 1 / 0;

            //����2:���ʦ̫��Ǯ+5000
            pst.setDouble(1, 15000);
            pst.setString(2, "���ʦ̫");
            pst.executeUpdate();

            //�����ʹ�ò���3:��������
            con.commit();
        } catch (SQLException e) {

            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            JDBCUtils.close(null, pst, con);
        }

    }


    public static void main(String[] args) throws Exception {
        new TestTransaction().testTransaction();
    }

}

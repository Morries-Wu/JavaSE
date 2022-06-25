package JDBC.Test;
/*
 * ����������ʾ�����������
 * ����:��admin���в���5000������
 * ���API:
 * addBatch
 * executeBatch
 * clearBatch
 * ˵����������������PreparedStatementһ�������,���Լ��ٱ������,Ҳ���Լ������д���,Ч�ʺܴ����
 *
 *
 *
 *
 * */

import JDBC.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestBatch {

    //�]��ʹ��������
    public void testNoBatch() throws SQLException {
        //1����ȡ����
        Connection con = JDBCUtils.getConnection();

        //2��ִ�в���
        PreparedStatement pst = con.prepareStatement("insert into admin values(null,?,?)");

        for (int i = 1; i < 50000; i++) {
            pst.setString(1, "john" + 1);
            pst.setString(2, "0000");
            pst.executeUpdate();//ִ��
        }

        //3���ͷ���Դ
        JDBCUtils.close(null, pst, con);

    }

    //ʹ��������
    public void testBatch() throws SQLException {
        //1����ȡ����
        Connection con = JDBCUtils.getConnection();

        //2��ִ�в���
        PreparedStatement pst = con.prepareStatement("insert into admin values(null,?,?)");

        for (int i = 1; i < 50000; i++) {
            pst.setString(1, "john" + 1);
            pst.setString(2, "0000");

            pst.addBatch();//���sql��䵽�����������
            if (i % 1000 == 0) {
                pst.executeBatch(); //ִ����������е�SQL���
                pst.clearBatch();   //�����������е�SQL���
            }

        }

        //3���ͷ���Դ
        JDBCUtils.close(null, pst, con);

    }

    public static void main(String[] args) throws SQLException {
        new TestBatch().testBatch();
    }

}

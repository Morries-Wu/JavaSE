package JDBC.Test;

import JDBC.Utils.JDBCUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/*
 * ����������ʾBlob�������ݵĴ�ȡ
 *
 *
 * */
public class TestBlob {

    //�洢ͼƬ
    public void testSave() throws Exception {
        //1����ȡ����
        Connection con = JDBCUtils.getConnection();

        //2��ִ���޸����
        PreparedStatement pst = con.prepareStatement("update  beauty set photo=? where id=1");
        pst.setBlob(1, new FileInputStream("src\\JDBC\\img\\1.jpg"));

        pst.executeUpdate();
        JDBCUtils.close(null, pst, con);
    }

    //��ȡͼƬ
    public void testRead() throws Exception {
        //1����ȡ����
        Connection con = JDBCUtils.getConnection();

        //2��ִ�в�ѯ���
        PreparedStatement pst = con.prepareStatement("select photo from beauty where id=1");
        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            //��ʽ1:
            //Blob blob = resultSet.getBlob("photo");
            //InputStream binaryStream = blob.getBinaryStream();

            //��ʽ2:
            InputStream in = resultSet.getBinaryStream("photo");
            FileOutputStream out = new FileOutputStream("src\\JDBC\\img\\copy.jpg");
            int len = -1;
            byte flush[] = new byte[1024];
            while ((len = in.read(flush)) != -1) {
                out.write(flush, 0, len);
            }
            out.close();
            in.close();
            resultSet.close();
        }

        JDBCUtils.close(null, pst, con);
    }


    public static void main(String[] args) throws Exception {
        new TestBlob().testRead();
    }

}

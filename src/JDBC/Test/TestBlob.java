package JDBC.Test;

import JDBC.Utils.JDBCUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/*
 * 此类用于演示Blob类型数据的存取
 *
 *
 * */
public class TestBlob {

    //存储图片
    public void testSave() throws Exception {
        //1、获取连接
        Connection con = JDBCUtils.getConnection();

        //2、执行修改语句
        PreparedStatement pst = con.prepareStatement("update  beauty set photo=? where id=1");
        pst.setBlob(1, new FileInputStream("src\\JDBC\\img\\1.jpg"));

        pst.executeUpdate();
        JDBCUtils.close(null, pst, con);
    }

    //读取图片
    public void testRead() throws Exception {
        //1、获取连接
        Connection con = JDBCUtils.getConnection();

        //2、执行查询语句
        PreparedStatement pst = con.prepareStatement("select photo from beauty where id=1");
        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            //方式1:
            //Blob blob = resultSet.getBlob("photo");
            //InputStream binaryStream = blob.getBinaryStream();

            //方式2:
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

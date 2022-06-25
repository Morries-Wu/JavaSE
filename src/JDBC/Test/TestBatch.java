package JDBC.Test;
/*
 * 此类用于演示批处理的作用
 * 案例:向admin表中插入5000行数据
 * 相关API:
 * addBatch
 * executeBatch
 * clearBatch
 * 说明：批处理往往和PreparedStatement一起搭配用,可以减少编译次数,也可以减少运行次数,效率很大提高
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

    //沒有使用批处理
    public void testNoBatch() throws SQLException {
        //1、获取连接
        Connection con = JDBCUtils.getConnection();

        //2、执行插入
        PreparedStatement pst = con.prepareStatement("insert into admin values(null,?,?)");

        for (int i = 1; i < 50000; i++) {
            pst.setString(1, "john" + 1);
            pst.setString(2, "0000");
            pst.executeUpdate();//执行
        }

        //3、释放资源
        JDBCUtils.close(null, pst, con);

    }

    //使用批处理
    public void testBatch() throws SQLException {
        //1、获取连接
        Connection con = JDBCUtils.getConnection();

        //2、执行插入
        PreparedStatement pst = con.prepareStatement("insert into admin values(null,?,?)");

        for (int i = 1; i < 50000; i++) {
            pst.setString(1, "john" + 1);
            pst.setString(2, "0000");

            pst.addBatch();//添加sql语句到批处理语句中
            if (i % 1000 == 0) {
                pst.executeBatch(); //执行批处理包中的SQL语句
                pst.clearBatch();   //清空批处理包中的SQL语句
            }

        }

        //3、释放资源
        JDBCUtils.close(null, pst, con);

    }

    public static void main(String[] args) throws SQLException {
        new TestBatch().testBatch();
    }

}

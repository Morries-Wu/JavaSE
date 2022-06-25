package JDBC.Test;


import JDBC.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * 此类用于演示JDBC中的事务
 *
 * 使用步骤:
 * 1、开启新事务
 * 取消隐式事务自动提交的功能
 * setAutoCommit(false);
 *
 * 2、编写组成事务的一组sql语句
 * commit();提交
 * rollback();回滚
 * 细节:
 * 要求开启事务的连接对象和获取命令的连接对象必须是同一个！否则事务无效
 *
 * 3、结束事务
 *
 * 案例:转账案例
 * 张三丰给灭绝师太转5000
 *
 * */
public class TestTransaction {


    public void testNoTransaction() throws Exception {
        //1、获取连接
        Connection con = JDBCUtils.getConnection();

        //2、执行sql语句
        PreparedStatement pst = con.prepareStatement("update account set balance=? where username=?");

        //操作1:张三丰的钱-5000
        pst.setDouble(1, 5000);
        pst.setString(2, "张三丰");
        pst.executeUpdate();

        //操作2:灭绝师太的钱+5000
        pst.setDouble(1, 15000);
        pst.setString(2, "灭绝师太");
        pst.executeUpdate();

        //3、释放资源
        JDBCUtils.close(null, pst, con);
    }

    //使用事务
    public void testTransaction() {

        Connection con = null;
        PreparedStatement pst = null;
        try {
            //1、获取连接
            con = JDBCUtils.getConnection();

            //事务的使用步骤1:开启事务
            con.setAutoCommit(false);

            //事务的使用步骤2:编写sql语句,并执行
            pst = con.prepareStatement("update account set balance=? where username=?");

            //操作1:张三丰的钱-5000
            pst.setDouble(1, 5000);
            pst.setString(2, "张三丰");
            pst.executeUpdate();

            //模拟异常
            //int i = 1 / 0;

            //操作2:灭绝师太的钱+5000
            pst.setDouble(1, 15000);
            pst.setString(2, "灭绝师太");
            pst.executeUpdate();

            //事务的使用步骤3:结束事务
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

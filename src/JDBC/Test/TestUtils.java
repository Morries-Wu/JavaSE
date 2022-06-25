package JDBC.Test;

import JDBC.JavaBean.Boys;
import JDBC.Utils.JDBCUtils;
import JDBC.Utils.JDBCUtilsByDurid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/*
 * 此类用于演示DBUtils的使用
 * 功能的增删改查等等
 *
 * QueryRunner类:
 *      update(connection,sql,params):执行任何增删改语句
 *      query(Connection,sql,ResultSeyHandler,params):执行任何查询语句
 * ResultSetHandler接口
 *      BeanHandler:将结果集的第一行,封装成对象，并返回              new BeanHandler<>(XX.Class)
 *      BeanListHandler:将结果集中的所有行,封装成对象的集合,并返回    new BeanListHandler<>(XX.Class)
 *      ScalarHandler:将结果集中的第一行第一列,以object形式返回      new ScalarHandler()
 * */
public class TestUtils {

    public void testUpdate() {
        //1、获取连接
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            QueryRunner qr = new QueryRunner();

            //2、执行增删改
            int update = qr.update(con, "update boys set boyName=? where id=4", "慕容煞笔");
            System.out.println(update > 0 ? "success" : "failure");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3、关闭连接
            JDBCUtils.close(null, null, con);
        }
    }

    public void testQuerySingle() {
        //1、获取连接
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            QueryRunner qr = new QueryRunner();

            //2、执行增删改
            //Admin admin = qr.query(con, "select * from admin where id=?", new BeanHandler<>(Admin.class), 1);
            //System.out.println(admin.getUsername()+"\t"+admin.getPassword()+"\t"+admin.getId());

            Boys boys = qr.query(con, "select * from boys where userCP=?", new BeanHandler<>(Boys.class), 300);
            System.out.println(boys.getBoyName() + "\t" + boys.getId() + "\t" + boys.getUserCp());

            // System.out.println(update > 0 ? "success" : "failure");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3、关闭连接
            JDBCUtils.close(null, null, con);
        }

    }


    public void testQueryMulti() {
        //1、获取连接
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            QueryRunner qr = new QueryRunner();

            //2、执行增删改
            List<Boys> list = qr.query(con, "select * from boys where userCP>?", new BeanListHandler<>(Boys.class), 10);
            for (Boys boys : list) {
                System.out.println(boys.getBoyName() + "\t" + boys.getId() + "\t" + boys.getUserCp());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3、关闭连接
            JDBCUtils.close(null, null, con);
        }

    }


    public void testScalar() {
        //1、获取连接
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();

            //2、执行单个值
            QueryRunner qr = new QueryRunner();
            Object query = qr.query(con, "select count(*) from beauty", new ScalarHandler<>());
            System.out.println(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3、关闭连接
            JDBCUtils.close(null, null, con);
        }

    }




    public static void main(String[] args) {
        new TestUtils().testScalar();
    }
}

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
 * ����������ʾDBUtils��ʹ��
 * ���ܵ���ɾ�Ĳ�ȵ�
 *
 * QueryRunner��:
 *      update(connection,sql,params):ִ���κ���ɾ�����
 *      query(Connection,sql,ResultSeyHandler,params):ִ���κβ�ѯ���
 * ResultSetHandler�ӿ�
 *      BeanHandler:��������ĵ�һ��,��װ�ɶ��󣬲�����              new BeanHandler<>(XX.Class)
 *      BeanListHandler:��������е�������,��װ�ɶ���ļ���,������    new BeanListHandler<>(XX.Class)
 *      ScalarHandler:��������еĵ�һ�е�һ��,��object��ʽ����      new ScalarHandler()
 * */
public class TestUtils {

    public void testUpdate() {
        //1����ȡ����
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            QueryRunner qr = new QueryRunner();

            //2��ִ����ɾ��
            int update = qr.update(con, "update boys set boyName=? where id=4", "Ľ��ɷ��");
            System.out.println(update > 0 ? "success" : "failure");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3���ر�����
            JDBCUtils.close(null, null, con);
        }
    }

    public void testQuerySingle() {
        //1����ȡ����
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            QueryRunner qr = new QueryRunner();

            //2��ִ����ɾ��
            //Admin admin = qr.query(con, "select * from admin where id=?", new BeanHandler<>(Admin.class), 1);
            //System.out.println(admin.getUsername()+"\t"+admin.getPassword()+"\t"+admin.getId());

            Boys boys = qr.query(con, "select * from boys where userCP=?", new BeanHandler<>(Boys.class), 300);
            System.out.println(boys.getBoyName() + "\t" + boys.getId() + "\t" + boys.getUserCp());

            // System.out.println(update > 0 ? "success" : "failure");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3���ر�����
            JDBCUtils.close(null, null, con);
        }

    }


    public void testQueryMulti() {
        //1����ȡ����
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            QueryRunner qr = new QueryRunner();

            //2��ִ����ɾ��
            List<Boys> list = qr.query(con, "select * from boys where userCP>?", new BeanListHandler<>(Boys.class), 10);
            for (Boys boys : list) {
                System.out.println(boys.getBoyName() + "\t" + boys.getId() + "\t" + boys.getUserCp());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3���ر�����
            JDBCUtils.close(null, null, con);
        }

    }


    public void testScalar() {
        //1����ȡ����
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();

            //2��ִ�е���ֵ
            QueryRunner qr = new QueryRunner();
            Object query = qr.query(con, "select count(*) from beauty", new ScalarHandler<>());
            System.out.println(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3���ر�����
            JDBCUtils.close(null, null, con);
        }

    }




    public static void main(String[] args) {
        new TestUtils().testScalar();
    }
}

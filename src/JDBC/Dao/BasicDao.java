package JDBC.Dao;

import JDBC.Utils.JDBCUtils;
import JDBC.Utils.JDBCUtilsByDurid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class BasicDao <T> {

    private QueryRunner qr = new QueryRunner();

    public int update(String sql, Object... params) {
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            int update = qr.update(con, sql, params);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, null, con);
        }
    }


    public  T querySingle(String sql, Class<T> clazz, Object... params) {
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            return qr.query(con, sql, new BeanHandler<>(clazz), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, null, con);
        }
    }


    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            return qr.query(con, sql, new BeanListHandler<>(clazz), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, null, con);
        }
    }


    public Object scalar(String sql, Object... params) {
        Connection con = null;
        try {
            con = JDBCUtilsByDurid.getconnection();
            return qr.query(con, sql, new ScalarHandler<>(), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, null, con);
        }
    }


}

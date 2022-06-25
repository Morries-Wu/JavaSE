package JDBC.Utils;

import JDBC.JavaBean.Boys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * 此类用于封装通用的增删改查方法
 * 功能:
 * 1、执行增删改
 * 2、执行查询
 * */
public class CRUDUtils {

     /*功能:增删改
    针对于任何表增删改语句
    * */

    public static int update(String sql, Object... params) {//params可变长度参数
        //1、获取连接
        try {
            Connection con = JDBCUtilsByDurid.getconnection();
            //2、执行sql语句
            PreparedStatement pst = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            int update = pst.executeUpdate();
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Boys querySingle(String sql, Object... params) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        try {
            //1、获取连接
            con = JDBCUtilsByDurid.getconnection();

            //2、执行查询
            pst = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            res = pst.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String boyname = res.getString("boyName");
                int userCP = res.getInt("userCP");
                Boys bo = new Boys(id, boyname, userCP);
                return bo;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(res, pst, con);
        }

        return null;
    }


    public static List<Boys> queryMutil(String sql, Object... params) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        List<Boys> list=null;
        try {
            //1、获取连接
            con = JDBCUtilsByDurid.getconnection();

            //2、执行查询
            pst = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            res = pst.executeQuery();
            list=new ArrayList<>();
            while (res.next()) {
                int id = res.getInt("id");
                String boyname = res.getString("boyName");
                int userCP = res.getInt("userCP");
                Boys bo = new Boys(id, boyname, userCP);
                list.add(bo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(res, pst, con);
        }
        return list;
    }

}

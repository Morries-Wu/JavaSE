package JDBC.Utils;

import JDBC.JavaBean.Boys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * �������ڷ�װͨ�õ���ɾ�Ĳ鷽��
 * ����:
 * 1��ִ����ɾ��
 * 2��ִ�в�ѯ
 * */
public class CRUDUtils {

     /*����:��ɾ��
    ������κα���ɾ�����
    * */

    public static int update(String sql, Object... params) {//params�ɱ䳤�Ȳ���
        //1����ȡ����
        try {
            Connection con = JDBCUtilsByDurid.getconnection();
            //2��ִ��sql���
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
            //1����ȡ����
            con = JDBCUtilsByDurid.getconnection();

            //2��ִ�в�ѯ
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
            //1����ȡ����
            con = JDBCUtilsByDurid.getconnection();

            //2��ִ�в�ѯ
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

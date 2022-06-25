package JDBC.Test;

import JDBC.JavaBean.Boys;
import JDBC.Utils.CRUDUtils;
import JDBC.Utils.JDBCUtils;
import JDBC.Utils.JDBCUtilsByDurid;
import Network.SpiderTest01;
import com.alibaba.druid.sql.dialect.mysql.visitor.transform.FromSubqueryResolver;

import java.util.List;

public class TestCRUDUtils {

    public void testupdate() {
        int update = CRUDUtils.update("update beauty set sex=? where name='ÁøÑÒ'", "ÄÐ");
        System.out.println(update > 0 ? "success" : "failure");
    }

    public static void main(String[] args) {
        //Boys boy = CRUDUtils.querySingle("select * from boys where id=?", 2);
        //System.out.println(boy.getBoyName() + "\t\t" + boy.getId() + "\t" + boy.getUserCp());
        List<Boys> list = CRUDUtils.queryMutil("select * from boys");
        for (Boys boys : list) {
            System.out.println(boys.getBoyName() + "\t" + boys.getId() + "\t\t" + boys.getUserCp());
        }

    }

}

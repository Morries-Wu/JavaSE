package JDBC.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;

import java.sql.Connection;
import java.util.Properties;

/*
 * 此类是通过德鲁伊数据库连接池获取连接对象
 * */
public class JDBCUtilsByDurid {

    static Properties properties = null;
    static DataSource ds = null;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src\\JDBC\\lib\\druid.properties"));
            //1、创建了一个指定参数的数据库连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection() throws Exception {
        //从数据库连接池中获取可用的连接对象
        return ds.getConnection();
    }

    public static void main(String[] args) throws Exception {
        getconnection();
    }
}

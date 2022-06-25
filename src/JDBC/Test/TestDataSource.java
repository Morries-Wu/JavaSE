package JDBC.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/*
* 此类用于演示德鲁伊数据库连接池的使用
*
* */
public class TestDataSource {

    public void testDataSource() throws Exception {
        Properties properties=new Properties();
        properties.load(new FileInputStream("src\\JDBC\\lib\\druid.properties"));

        //1、创建了一个指定参数的数据库连接池
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);

        //2、从数据库连接池中获取可用的连接对象
        Connection con = ds.getConnection();
        System.out.println("连接成功");

        //3、关闭连接
        con.close();
    }

    //测试C3P0数据库连接池的方式1:

    public void testC3P0() throws Exception {
        ComboPooledDataSource cpds=new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");//loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/girls");
        cpds.setUser("root");
        cpds.setPassword("qq1802702683");
        cpds.setInitialPoolSize(10); //初始化连接对象
        cpds.setMaxPoolSize(50);
        Connection con = cpds.getConnection();

        System.out.println("数据库连接成功");
        con.close();
    }



}

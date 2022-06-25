package JDBC.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/*
* ����������ʾ��³�����ݿ����ӳص�ʹ��
*
* */
public class TestDataSource {

    public void testDataSource() throws Exception {
        Properties properties=new Properties();
        properties.load(new FileInputStream("src\\JDBC\\lib\\druid.properties"));

        //1��������һ��ָ�����������ݿ����ӳ�
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);

        //2�������ݿ����ӳ��л�ȡ���õ����Ӷ���
        Connection con = ds.getConnection();
        System.out.println("���ӳɹ�");

        //3���ر�����
        con.close();
    }

    //����C3P0���ݿ����ӳصķ�ʽ1:

    public void testC3P0() throws Exception {
        ComboPooledDataSource cpds=new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");//loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/girls");
        cpds.setUser("root");
        cpds.setPassword("qq1802702683");
        cpds.setInitialPoolSize(10); //��ʼ�����Ӷ���
        cpds.setMaxPoolSize(50);
        Connection con = cpds.getConnection();

        System.out.println("���ݿ����ӳɹ�");
        con.close();
    }



}

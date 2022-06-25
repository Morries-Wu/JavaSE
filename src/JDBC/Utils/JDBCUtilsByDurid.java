package JDBC.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;

import java.sql.Connection;
import java.util.Properties;

/*
 * ������ͨ����³�����ݿ����ӳػ�ȡ���Ӷ���
 * */
public class JDBCUtilsByDurid {

    static Properties properties = null;
    static DataSource ds = null;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src\\JDBC\\lib\\druid.properties"));
            //1��������һ��ָ�����������ݿ����ӳ�
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection() throws Exception {
        //�����ݿ����ӳ��л�ȡ���õ����Ӷ���
        return ds.getConnection();
    }

    public static void main(String[] args) throws Exception {
        getconnection();
    }
}

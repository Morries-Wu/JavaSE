package JDBC.Test;

import JDBC.JavaBean.Customer;
import JDBC.Utils.JDBCUtils;
import JDBC.Utils.JDBCUtilsByDurid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.util.Scanner;

public class TestCustomer {
//请输入编号:1
//编号 姓名       邮箱             生日
//1   汪峰    wf@126.com       2010-2-2

    public void testQuery() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入编号:");
        int id = input.nextInt();

        //1、获取连接
        Connection con = JDBCUtilsByDurid.getconnection();

        //2、执行查询
        QueryRunner qr = new QueryRunner();
        Customer customer = qr.query(con, "select id,name,email,birth from customers where id=?", new BeanHandler<>(Customer.class));
        System.out.println(customer);

        //3、关闭连接
        JDBCUtils.close(null, null, con);


    }

}

package JDBC.Test;

import JDBC.JavaBean.Customer;
import JDBC.Utils.JDBCUtils;
import JDBC.Utils.JDBCUtilsByDurid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.util.Scanner;

public class TestCustomer {
//��������:1
//��� ����       ����             ����
//1   ����    wf@126.com       2010-2-2

    public void testQuery() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("��������:");
        int id = input.nextInt();

        //1����ȡ����
        Connection con = JDBCUtilsByDurid.getconnection();

        //2��ִ�в�ѯ
        QueryRunner qr = new QueryRunner();
        Customer customer = qr.query(con, "select id,name,email,birth from customers where id=?", new BeanHandler<>(Customer.class));
        System.out.println(customer);

        //3���ر�����
        JDBCUtils.close(null, null, con);


    }

}

package JDBC.Test;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * ����������ʾJDBC�Ĳ���1:��������
 * ��ļ���ʱ��:
 * 1.new ����
 * 2.��������
 * 3.������ľ�̬��Ա
 * 4.ͨ������
 *
 * ʹ��new ����ķ�ʽ������Ĳ���:
 * 1�����ڱ���������,��������ڼ���಻����,��ֱ�ӱ��������,Ҳ����������̫ǿ
 * 2������Driver���󴴽�������,Ч�ʽϵ�
 * ���÷���ķ�ʽ������!
 *1�����������ڼ���,��󽵵������������
 *2��Driver�������������1��,Ч�ʽϸ�
 *
 *
 * */

public class TestJDBC01 {
    public static void main(String[] args) throws Exception {
        //�Ϸ�ʽ ���Ƽ�,��������
        DriverManager.deregisterDriver(new Driver());

        Class.forName("com.mysql.jdbc.Driver");


    }

}

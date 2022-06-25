package Manger;

import java.util.ArrayList;

public class Demo {

    /**
     *     假设刚开始从程序入口刚开始先利用写好的工具FileToObject,就是把文件信息转换为对象给ArrayList<Person> persons这个类
     *     然后判断这个类persons(集合类)是不是空,如果是空的就在控制台输出文件没数据，第一次运行
     *     然后再新建这个类
     *
     */
    public static void main(String[] args) {
        String filename = "Student.txt"; //文件名
        //注意这个persons的地方因为在判断语句的最上层所以可以看作为全局变量 persons
        ArrayList<Person> persons = (ArrayList<Person>) FileReaderorWriter.FileToObject(filename); //文件读取和文件写入
        if (persons == null) {
            System.out.println("文件没数据，第一次运行");  //123456
            persons = new ArrayList<Person>();        //因为前面的赋值为null[空],所以相当于再一次重新赋值
            System.out.println("请输入账号");
            String in1 = Utils.scan();                //Utils.scan()输入字符串工具
            System.out.println("请输入密码");
            String in2 = Utils.scan();
            persons.add(new Manager(in1, in2, Person.MANAGER));                 //因为一开始没有用户信息所以一开始创建的管理权限为管理员
        }

        //不断循环操作,直到自己不想操作的时候再退出
        while (true) {
            /**
             * 登录函数login会检查用户的权限然后返回一个对象person,每个person都对应自己的身份
             * 如果根本就找不到指定输入的用户信息就会返回一个null空的值,就会在控制台输出登录失败
             */

            Person person = Person.login(persons);

            if (person != null) {
                person.mune(persons);//如果不为空就说明已经登录了自己的账号,进行自己的账号对应的mune
            } else {
                System.out.println("登录失败");
            }
            System.out.println("退出请输入n");
            if ("N".equalsIgnoreCase(Utils.scan())) {
                FileReaderorWriter.objectToFile(persons, filename);
                break;
            }
        }
    }

}

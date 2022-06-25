package Manger;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Person implements Serializable {  //写入的对象Person要作为一种序列化可写入文件
    //这个类是抽象类
    private String ID, PWD;
    private int Role;
    public static final int MANAGER = 1; //Person.MANAGER
    public static final int TEACHER = 2;
    public static final int STUDENT = 3;

    /**
     * 人都有手,脚,身份证,名字,大人、小孩[特征]
     * 后续的管理员是人的一个,管理员继承了人的特征所以他赋予了权力管理他人
     * 学生就是学生,老师就是老师
     */




    // ArrayList<E>是包装了一个集合类，而且该集合是一个对象类集合
    public Person() {
    }

    public Person(String ID, String PWD, int Role) {
        this.ID = ID;
        this.PWD = PWD;
        this.Role = Role;
    }

    //直接在抽象类里面定义一个菜单让子类继承或者实现类实现它才能使用
    public abstract void mune(ArrayList<Person> persons);//实现mune

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public String getPWD() {
        return PWD;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    public int getRole() {
        return Role;
    }

    //修改密码
    public void changePWD() {
        System.out.println("请输入需要修改的密码");
        this.setPWD(Utils.scan()); //输入自己需要的密码Utils工具类自己编写的
        System.out.println("修改成功");
    }

    //检查个人对应的id即身份证
    public Person check(ArrayList<Person> persons, String id) {
        //迭代循环查找这个传入的id,iterator是集合类的一个工具相当于指针
        Iterator iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person P = (Person) iterator.next();
            if (id.equals(P.ID)) {//这里如果查找匹配到的信息就是true
                return P;
            }
        }
        //如果查找不到传入的id返回null
        return null;
    }

    //查询功能查询自己对应身份的信息
    public void search() {
        String roles = "";
        switch (Role) {
            case Person.MANAGER:
                roles = "管理员";
                break;
            case Person.TEACHER:
                roles = "教师";
                break;
            case Person.STUDENT:
                roles = "学生";
                break;
            default:
                break;
        }
        System.out.println(roles + "账号:" + ID + "  密码:" + PWD);
    }

    //登录操作把传入的persons进行处理
    public static Person login(ArrayList<Person> persons) {
        System.out.println("此次操作为验证登录，请您输入您的账号");
        String id = Utils.scan();
        System.out.println("请再次输入您的密码");
        String pwd = Utils.scan();
        Iterator iterator = persons.iterator();//迭代验证账号信息
        while (iterator.hasNext()) {
            Person P = (Person) iterator.next();
            if (id.equals(P.ID) && pwd.equals(P.PWD)) {//两个同时都要符合条件,true
                return P;  //验证成功找到的对象,就是你输入账号密码成功的对象
            }
        }
        // 此处是该程序的重点，因为程序的对比循环在此处找出每个元素的对象出来然后跑到每个类的对象中实现
        return null;
    }
}

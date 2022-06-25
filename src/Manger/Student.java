package Manger;


import java.util.ArrayList;

public class Student extends Person {

    //学生继承了人的特性
    private int score;
    private String name;
    private String class_id;
    private String phone;
    private String dormitory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public Student() {
        super();
    }

    //自定义构造方法
    public Student(String id, String pwd, int role, int score, String name, String class_id, String phone, String dormitory) {
        super(id,pwd,role);//人的最基本的特征构造super调用
        this.score = score;
        this.name = name;
        this.class_id = class_id;
        this.phone = phone;
        this.dormitory = dormitory;
    }

    //重写了人最基本信息查询即在super.search()函数的基础上添加一行代码
    public void search() {
        super.search();
        System.out.println("姓名:" + name + "\t班級:" + class_id + "\t手机:" + phone + "\t宿舍:" + dormitory + "\t成绩:" + score);
    }

    //这个this就是说你当前的这个对象,就相当于说你是本人操作这个方法
    public void mune(ArrayList<Person> persons) {
        boolean flag = true;
        while (flag) {
            System.out.println("1、修改密码\t2、查看个人信息");
            switch (Utils.scanInt()) {
                case 1:
                    this.changePWD();
                    break;
                case 2:
                    this.search();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}

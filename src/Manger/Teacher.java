package Manger;

import java.util.ArrayList;
import java.util.Iterator;


public class Teacher extends Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String ID, String PWD, int role) {
        super();
    }

    public Teacher() {
        this.name = name;
    }

    public Teacher(String ID, String PWD, int Role, String name) {
        super(ID, PWD, Role);
        this.name = name;
    }

    //查询所有学生信息
    public void searchAll(ArrayList<Person> persons) {
        Iterator iterator = persons.iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            Person P = (Person) iterator.next();
            if (P.getRole() == Person.STUDENT) {
                ((Student) P).search();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("暂未录入学生信息");
        }
    }

    //录入学生成绩
    public void luru_score(ArrayList<Person> persons) {
        System.out.println("请输入需要录入学生的账号");
        String id = Utils.scan();
        //输入了学生id之后,利用iterator工具迭代,相当于指针指到当前的信息
        Iterator iterator = persons.iterator();
        while (iterator.hasNext()) {
            //每次迭代都把指向的信息给Person P赋值
            Person P = (Person) iterator.next();
            //然后比对每一个对象的id,和权限是否是一致的,如果一致就直接录入学生的成绩
            if (P.getID().equals(id) && P.getRole() == Person.STUDENT) {
                System.out.println("请输入需要录入的成绩");
                //此处先把person向下转型成Student,Person p=new Student()
                //然后这个P.setScore();就利用设置函数直接输入值就可以设置该学生的成绩
                ((Student) P).setScore(Utils.scanInt());
            }
        }
    }

    //录入学生账号信息
    public void luru_info(ArrayList<Person> persons) {
        //录入操作
        System.out.println("请输入需要录入学生的账号");
        String id = Utils.scan();
        System.out.println("请输入需要录入学生的姓名");
        String name = Utils.scan();
        System.out.println("请输入需要录入学生的手机");
        String phone = Utils.scan();
        System.out.println("请输入需要录入学生的班级");
        String class_id = Utils.scan();
        System.out.println("请输入需要录入学生的宿舍");
        String dormitory = Utils.scan();
        //相当于说我把这个persons放到这个check我要查找关于id这个学生的信息,如果相同存在这个ID就不能再次录入该学生信息
        Person check = this.check(persons, id);
        if (check != null) {
            //查看身份是否是學生,如果身份是學生就不能錄入
            if (check.getRole() == STUDENT) {
                System.out.println("该账号已存在请重试");
                return;
            }
        }
        //为什么这里可以直接录入学生信息,是因为前面的check对象已经为null
        persons.add(new Student(id, "123456", Person.STUDENT, 0, name, class_id, phone, dormitory));
        System.out.println("录入学生信息成功");
    }

    //查找特定的学生信息
    public void check_Stu(ArrayList<Person> persons) {
        System.out.println("请输入需要查询的学生账号信息");
        String id = Utils.scan();
        Person check = this.check(persons, id);
        if (check != null) {
            if (check.getRole() == STUDENT) {
                //相当于说是  check是学生对象是你已经getRole()你已经获取到权限是等于学生
                //Student stu=(Student) check;
                //stu.search();
                ((Student) check).search();
                return;
            }
        }
        System.out.println("未查询到该学生信息");
    }

    //删除学生信息成功
    public void delete(ArrayList<Person> persons) {
        System.out.println("请输入需要删除的学生账号信息");
        String id = Utils.scan();
        Person check = this.check(persons, id);
        //查找到指定的学生id然后比对是否一致并且不为空,就可以直接删除
        if (check != null) {
            if (check.getRole() == STUDENT) {
                persons.remove(check);
                System.out.println("删除学生信息成功");
                return;
            }
        }
        System.out.println("该学生未存在");
    }

    //调用教师菜单
    public void mune(ArrayList<Person> persons) {
        boolean flag = true;
        while (flag) {
            System.out.println("1、修改密码\t2、查看个人信息\t3、录入学生信息\t4、管理学生信息");
            switch (Utils.scanInt()) {
                case 1:
                    this.changePWD();
                    break;
                case 2:
                    this.search();
                    break;
                case 3:
                    this.luru_info(persons);
                    break;
                case 4:
                    this.stu_mune(persons);
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    //管理学生菜单函数
    public void stu_mune(ArrayList<Person> persons) {
        System.out.println("1、查看所有学生信息\t2、录入学生成绩\t3、查找指定学生信息\t4、删除学生信息");
        switch (Utils.scanInt()) {
            case 1:
                this.searchAll(persons);
                break;
            case 2:
                this.luru_score(persons);
                break;
            case 3:
                this.check_Stu(persons);
                break;
            case 4:
                this.delete(persons);
                break;
            default:
                System.out.println("您的输入有误请重试");
                stu_mune(persons);
                break;
        }
    }


}

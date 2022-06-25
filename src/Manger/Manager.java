package Manger;

import java.util.ArrayList;
import java.util.Iterator;

public class Manager extends Person {
    public Manager() {
        super();
    }

    public Manager(String id, String pwd, int Role) {
        super(id, pwd, MANAGER);
    }

    //查询教师信息的函数
    public void searchAll(ArrayList<Person> persons) {
        Iterator iterator = persons.iterator();
        System.out.println("1、查看所有教师信息\t2、账号查找教师信息");
        int flag = Utils.scanInt();
        boolean sentry = false;
        if (flag == 1) {
            while (iterator.hasNext()) {
                Person P = (Person) iterator.next();
                if (P.getRole() == Person.TEACHER) {
                    P.search();
                    System.out.println("姓名:" + ((Teacher) P).getName());
                    sentry = true;
                }
            }
            if (sentry == false)
                System.out.println("暂无教师信息");
        } else if (flag == 2) {
            System.out.println("请输入您所需要查询教师的姓名");
            String name = Utils.scan();
            sentry = false;
            while (iterator.hasNext()) {
                Person P = (Person) iterator.next();
                if (P.getRole() == Person.TEACHER) {
                    Teacher teacher = (Teacher) P;
                    if (name.equals(teacher.getName())) {
                        P.search();
                        System.out.println("姓名:" + teacher.getName());
                        sentry = true;
                    }
                }
            }
            if (sentry == false)
                System.out.println("未查询到该教师信息");
        }
    }

    //删除教师信息的函数
    public void delete(ArrayList<Person> persons) {
        System.out.println("请输入需要删除的教师账号信息");
        //直接找到需要删除教师的对象如果没有找到就返回check对象
        Person check = check(persons, Utils.scan());
        if (check != null) {
            //比对返回的权限是否是教师
            if (check.getRole() == TEACHER) {
                //直接在集合里面remove所需要的对象就可以
                if (persons.remove(check)){
                    System.out.println("删除成功");
                    return;
                }
            }
        }
        //如果上面的条件都不满足则给出删除提示
        System.out.println("删除失败或未找到");
    }

    //录入一个新的教师信息
    public void luru(ArrayList<Person> persons) {
        System.out.println("请设置教师账号");
        String id = Utils.scan();
        System.out.println("请设置教师密码");
        String pwd = Utils.scan();
        System.out.println("请设置教师姓名");
        String name = Utils.scan();
        //查找需要录入教师的信息
        Person check = this.check(persons, id);
        //先判断查找到的对象是否为空,如果为空就跑到下面新建教师,如果不为空则证明需要录入的教师信息是重复的不能再次录入该教师信息
        if (check != null) {
            if (check.getRole() == TEACHER) {
                System.out.println("该账号已存在请重试");
                return;
            }
        }
        //查找不到教师账号,相当于说你输入的账号id
        persons.add(new Teacher(id, pwd, Person.TEACHER, name));
        System.out.println("录入" + name + "教师信息完成");
    }

    //教师信息菜单实现
    public void mune(ArrayList<Person> persons) {
        boolean flag = true;
        while (flag) {
            System.out.println("1、修改密码 \t2、查看个人信息\t3、录入教师信息\t4、管理教师信息");
            switch (Utils.scanInt()) {
                case 1:
                    this.changePWD();
                    break;
                case 2:
                    this.search();
                    break;
                case 3:
                    this.luru(persons);
                    break;
                case 4:
                    this.tea_mune(persons);
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    //修改教师信息操作
    public void fix(ArrayList<Person> persons) {
        System.out.println("1、修改教师密码\t2、修改教师姓名");
        int flag = Utils.scanInt();
        System.out.println("请输入教师的账号信息");
        String id = Utils.scan();
        //查找到直接返回一个对象赋值给check
        Person check = this.check(persons, id);
        //如果查找到了需要修改密码的教师账号信息
        if (check != null) {
            if (check.getRole() != TEACHER) {
                System.out.println("未查询到该账号教师");
                return;
            } else {
                if (flag == 1) {
                    System.out.println("请输入您所需要修改的密码");
                    //直接调用查找到的对象修改密码
                    check.setPWD(Utils.scan());
                } else if (flag == 2) {
                    System.out.println("请输入您所需要修改的姓名");
                    //Teacher teacher=(Teacher) check;  check(Person)
                    //teacher.setName
                    //如果选择了第二个就直接修改教师姓名
                    ((Teacher) check).setName(Utils.scan());
                } else {
                    //这里是利用栈的算法,如果输入的信息有误就再一次调用此方法
                    System.out.println("您的输入有误请重试");
                    fix(persons);
                }
                System.out.println("修改成功");
            }
        } else {
            //如果查找的时候没有查找到教师的信息给一个输出提示
            System.out.println("未查询到该账号教师");
        }

    }

    //需要管理教师个人信息的函数
    public void tea_mune(ArrayList<Person> persons) {
        System.out.println("1、查看教师信息\t2、修改教师信息\t3、删除教师信息");
        switch (Utils.scanInt()) {
            case 1:
                //查找教师信息函数
                this.searchAll(persons);
                break;
            case 2:
                //调用修改教师信息函数
                this.fix(persons);
                break;
            case 3:
                //删除教师信息函数
                this.delete(persons);
                break;
            default:
                System.out.println("您的输入有误请重试");
                tea_mune(persons);
                break;
        }
    }


}

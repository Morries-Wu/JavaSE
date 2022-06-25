package Manger;


import java.util.ArrayList;

public class Student extends Person {

    //ѧ���̳����˵�����
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

    //�Զ��幹�췽��
    public Student(String id, String pwd, int role, int score, String name, String class_id, String phone, String dormitory) {
        super(id,pwd,role);//�˵����������������super����
        this.score = score;
        this.name = name;
        this.class_id = class_id;
        this.phone = phone;
        this.dormitory = dormitory;
    }

    //��д�����������Ϣ��ѯ����super.search()�����Ļ��������һ�д���
    public void search() {
        super.search();
        System.out.println("����:" + name + "\t�༉:" + class_id + "\t�ֻ�:" + phone + "\t����:" + dormitory + "\t�ɼ�:" + score);
    }

    //���this����˵�㵱ǰ���������,���൱��˵���Ǳ��˲����������
    public void mune(ArrayList<Person> persons) {
        boolean flag = true;
        while (flag) {
            System.out.println("1���޸�����\t2���鿴������Ϣ");
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

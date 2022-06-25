package Manger;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Person implements Serializable {  //д��Ķ���PersonҪ��Ϊһ�����л���д���ļ�
    //������ǳ�����
    private String ID, PWD;
    private int Role;
    public static final int MANAGER = 1; //Person.MANAGER
    public static final int TEACHER = 2;
    public static final int STUDENT = 3;

    /**
     * �˶�����,��,���֤,����,���ˡ�С��[����]
     * �����Ĺ���Ա���˵�һ��,����Ա�̳����˵�����������������Ȩ����������
     * ѧ������ѧ��,��ʦ������ʦ
     */




    // ArrayList<E>�ǰ�װ��һ�������࣬���Ҹü�����һ�������༯��
    public Person() {
    }

    public Person(String ID, String PWD, int Role) {
        this.ID = ID;
        this.PWD = PWD;
        this.Role = Role;
    }

    //ֱ���ڳ��������涨��һ���˵�������̳л���ʵ����ʵ��������ʹ��
    public abstract void mune(ArrayList<Person> persons);//ʵ��mune

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

    //�޸�����
    public void changePWD() {
        System.out.println("��������Ҫ�޸ĵ�����");
        this.setPWD(Utils.scan()); //�����Լ���Ҫ������Utils�������Լ���д��
        System.out.println("�޸ĳɹ�");
    }

    //�����˶�Ӧ��id�����֤
    public Person check(ArrayList<Person> persons, String id) {
        //����ѭ��������������id,iterator�Ǽ������һ�������൱��ָ��
        Iterator iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person P = (Person) iterator.next();
            if (id.equals(P.ID)) {//�����������ƥ�䵽����Ϣ����true
                return P;
            }
        }
        //������Ҳ��������id����null
        return null;
    }

    //��ѯ���ܲ�ѯ�Լ���Ӧ��ݵ���Ϣ
    public void search() {
        String roles = "";
        switch (Role) {
            case Person.MANAGER:
                roles = "����Ա";
                break;
            case Person.TEACHER:
                roles = "��ʦ";
                break;
            case Person.STUDENT:
                roles = "ѧ��";
                break;
            default:
                break;
        }
        System.out.println(roles + "�˺�:" + ID + "  ����:" + PWD);
    }

    //��¼�����Ѵ����persons���д���
    public static Person login(ArrayList<Person> persons) {
        System.out.println("�˴β���Ϊ��֤��¼���������������˺�");
        String id = Utils.scan();
        System.out.println("���ٴ�������������");
        String pwd = Utils.scan();
        Iterator iterator = persons.iterator();//������֤�˺���Ϣ
        while (iterator.hasNext()) {
            Person P = (Person) iterator.next();
            if (id.equals(P.ID) && pwd.equals(P.PWD)) {//����ͬʱ��Ҫ��������,true
                return P;  //��֤�ɹ��ҵ��Ķ���,�����������˺�����ɹ��Ķ���
            }
        }
        // �˴��Ǹó�����ص㣬��Ϊ����ĶԱ�ѭ���ڴ˴��ҳ�ÿ��Ԫ�صĶ������Ȼ���ܵ�ÿ����Ķ�����ʵ��
        return null;
    }
}

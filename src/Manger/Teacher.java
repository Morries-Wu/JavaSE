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

    //��ѯ����ѧ����Ϣ
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
            System.out.println("��δ¼��ѧ����Ϣ");
        }
    }

    //¼��ѧ���ɼ�
    public void luru_score(ArrayList<Person> persons) {
        System.out.println("��������Ҫ¼��ѧ�����˺�");
        String id = Utils.scan();
        //������ѧ��id֮��,����iterator���ߵ���,�൱��ָ��ָ����ǰ����Ϣ
        Iterator iterator = persons.iterator();
        while (iterator.hasNext()) {
            //ÿ�ε�������ָ�����Ϣ��Person P��ֵ
            Person P = (Person) iterator.next();
            //Ȼ��ȶ�ÿһ�������id,��Ȩ���Ƿ���һ�µ�,���һ�¾�ֱ��¼��ѧ���ĳɼ�
            if (P.getID().equals(id) && P.getRole() == Person.STUDENT) {
                System.out.println("��������Ҫ¼��ĳɼ�");
                //�˴��Ȱ�person����ת�ͳ�Student,Person p=new Student()
                //Ȼ�����P.setScore();���������ú���ֱ������ֵ�Ϳ������ø�ѧ���ĳɼ�
                ((Student) P).setScore(Utils.scanInt());
            }
        }
    }

    //¼��ѧ���˺���Ϣ
    public void luru_info(ArrayList<Person> persons) {
        //¼�����
        System.out.println("��������Ҫ¼��ѧ�����˺�");
        String id = Utils.scan();
        System.out.println("��������Ҫ¼��ѧ��������");
        String name = Utils.scan();
        System.out.println("��������Ҫ¼��ѧ�����ֻ�");
        String phone = Utils.scan();
        System.out.println("��������Ҫ¼��ѧ���İ༶");
        String class_id = Utils.scan();
        System.out.println("��������Ҫ¼��ѧ��������");
        String dormitory = Utils.scan();
        //�൱��˵�Ұ����persons�ŵ����check��Ҫ���ҹ���id���ѧ������Ϣ,�����ͬ�������ID�Ͳ����ٴ�¼���ѧ����Ϣ
        Person check = this.check(persons, id);
        if (check != null) {
            //�鿴����Ƿ��ǌW��,�������ǌW���Ͳ������
            if (check.getRole() == STUDENT) {
                System.out.println("���˺��Ѵ���������");
                return;
            }
        }
        //Ϊʲô�������ֱ��¼��ѧ����Ϣ,����Ϊǰ���check�����Ѿ�Ϊnull
        persons.add(new Student(id, "123456", Person.STUDENT, 0, name, class_id, phone, dormitory));
        System.out.println("¼��ѧ����Ϣ�ɹ�");
    }

    //�����ض���ѧ����Ϣ
    public void check_Stu(ArrayList<Person> persons) {
        System.out.println("��������Ҫ��ѯ��ѧ���˺���Ϣ");
        String id = Utils.scan();
        Person check = this.check(persons, id);
        if (check != null) {
            if (check.getRole() == STUDENT) {
                //�൱��˵��  check��ѧ�����������Ѿ�getRole()���Ѿ���ȡ��Ȩ���ǵ���ѧ��
                //Student stu=(Student) check;
                //stu.search();
                ((Student) check).search();
                return;
            }
        }
        System.out.println("δ��ѯ����ѧ����Ϣ");
    }

    //ɾ��ѧ����Ϣ�ɹ�
    public void delete(ArrayList<Person> persons) {
        System.out.println("��������Ҫɾ����ѧ���˺���Ϣ");
        String id = Utils.scan();
        Person check = this.check(persons, id);
        //���ҵ�ָ����ѧ��idȻ��ȶ��Ƿ�һ�²��Ҳ�Ϊ��,�Ϳ���ֱ��ɾ��
        if (check != null) {
            if (check.getRole() == STUDENT) {
                persons.remove(check);
                System.out.println("ɾ��ѧ����Ϣ�ɹ�");
                return;
            }
        }
        System.out.println("��ѧ��δ����");
    }

    //���ý�ʦ�˵�
    public void mune(ArrayList<Person> persons) {
        boolean flag = true;
        while (flag) {
            System.out.println("1���޸�����\t2���鿴������Ϣ\t3��¼��ѧ����Ϣ\t4������ѧ����Ϣ");
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

    //����ѧ���˵�����
    public void stu_mune(ArrayList<Person> persons) {
        System.out.println("1���鿴����ѧ����Ϣ\t2��¼��ѧ���ɼ�\t3������ָ��ѧ����Ϣ\t4��ɾ��ѧ����Ϣ");
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
                System.out.println("������������������");
                stu_mune(persons);
                break;
        }
    }


}

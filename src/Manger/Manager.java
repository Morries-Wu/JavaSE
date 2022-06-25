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

    //��ѯ��ʦ��Ϣ�ĺ���
    public void searchAll(ArrayList<Person> persons) {
        Iterator iterator = persons.iterator();
        System.out.println("1���鿴���н�ʦ��Ϣ\t2���˺Ų��ҽ�ʦ��Ϣ");
        int flag = Utils.scanInt();
        boolean sentry = false;
        if (flag == 1) {
            while (iterator.hasNext()) {
                Person P = (Person) iterator.next();
                if (P.getRole() == Person.TEACHER) {
                    P.search();
                    System.out.println("����:" + ((Teacher) P).getName());
                    sentry = true;
                }
            }
            if (sentry == false)
                System.out.println("���޽�ʦ��Ϣ");
        } else if (flag == 2) {
            System.out.println("������������Ҫ��ѯ��ʦ������");
            String name = Utils.scan();
            sentry = false;
            while (iterator.hasNext()) {
                Person P = (Person) iterator.next();
                if (P.getRole() == Person.TEACHER) {
                    Teacher teacher = (Teacher) P;
                    if (name.equals(teacher.getName())) {
                        P.search();
                        System.out.println("����:" + teacher.getName());
                        sentry = true;
                    }
                }
            }
            if (sentry == false)
                System.out.println("δ��ѯ���ý�ʦ��Ϣ");
        }
    }

    //ɾ����ʦ��Ϣ�ĺ���
    public void delete(ArrayList<Person> persons) {
        System.out.println("��������Ҫɾ���Ľ�ʦ�˺���Ϣ");
        //ֱ���ҵ���Ҫɾ����ʦ�Ķ������û���ҵ��ͷ���check����
        Person check = check(persons, Utils.scan());
        if (check != null) {
            //�ȶԷ��ص�Ȩ���Ƿ��ǽ�ʦ
            if (check.getRole() == TEACHER) {
                //ֱ���ڼ�������remove����Ҫ�Ķ���Ϳ���
                if (persons.remove(check)){
                    System.out.println("ɾ���ɹ�");
                    return;
                }
            }
        }
        //�������������������������ɾ����ʾ
        System.out.println("ɾ��ʧ�ܻ�δ�ҵ�");
    }

    //¼��һ���µĽ�ʦ��Ϣ
    public void luru(ArrayList<Person> persons) {
        System.out.println("�����ý�ʦ�˺�");
        String id = Utils.scan();
        System.out.println("�����ý�ʦ����");
        String pwd = Utils.scan();
        System.out.println("�����ý�ʦ����");
        String name = Utils.scan();
        //������Ҫ¼���ʦ����Ϣ
        Person check = this.check(persons, id);
        //���жϲ��ҵ��Ķ����Ƿ�Ϊ��,���Ϊ�վ��ܵ������½���ʦ,�����Ϊ����֤����Ҫ¼��Ľ�ʦ��Ϣ���ظ��Ĳ����ٴ�¼��ý�ʦ��Ϣ
        if (check != null) {
            if (check.getRole() == TEACHER) {
                System.out.println("���˺��Ѵ���������");
                return;
            }
        }
        //���Ҳ�����ʦ�˺�,�൱��˵��������˺�id
        persons.add(new Teacher(id, pwd, Person.TEACHER, name));
        System.out.println("¼��" + name + "��ʦ��Ϣ���");
    }

    //��ʦ��Ϣ�˵�ʵ��
    public void mune(ArrayList<Person> persons) {
        boolean flag = true;
        while (flag) {
            System.out.println("1���޸����� \t2���鿴������Ϣ\t3��¼���ʦ��Ϣ\t4�������ʦ��Ϣ");
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

    //�޸Ľ�ʦ��Ϣ����
    public void fix(ArrayList<Person> persons) {
        System.out.println("1���޸Ľ�ʦ����\t2���޸Ľ�ʦ����");
        int flag = Utils.scanInt();
        System.out.println("�������ʦ���˺���Ϣ");
        String id = Utils.scan();
        //���ҵ�ֱ�ӷ���һ������ֵ��check
        Person check = this.check(persons, id);
        //������ҵ�����Ҫ�޸�����Ľ�ʦ�˺���Ϣ
        if (check != null) {
            if (check.getRole() != TEACHER) {
                System.out.println("δ��ѯ�����˺Ž�ʦ");
                return;
            } else {
                if (flag == 1) {
                    System.out.println("������������Ҫ�޸ĵ�����");
                    //ֱ�ӵ��ò��ҵ��Ķ����޸�����
                    check.setPWD(Utils.scan());
                } else if (flag == 2) {
                    System.out.println("������������Ҫ�޸ĵ�����");
                    //Teacher teacher=(Teacher) check;  check(Person)
                    //teacher.setName
                    //���ѡ���˵ڶ�����ֱ���޸Ľ�ʦ����
                    ((Teacher) check).setName(Utils.scan());
                } else {
                    //����������ջ���㷨,����������Ϣ�������һ�ε��ô˷���
                    System.out.println("������������������");
                    fix(persons);
                }
                System.out.println("�޸ĳɹ�");
            }
        } else {
            //������ҵ�ʱ��û�в��ҵ���ʦ����Ϣ��һ�������ʾ
            System.out.println("δ��ѯ�����˺Ž�ʦ");
        }

    }

    //��Ҫ�����ʦ������Ϣ�ĺ���
    public void tea_mune(ArrayList<Person> persons) {
        System.out.println("1���鿴��ʦ��Ϣ\t2���޸Ľ�ʦ��Ϣ\t3��ɾ����ʦ��Ϣ");
        switch (Utils.scanInt()) {
            case 1:
                //���ҽ�ʦ��Ϣ����
                this.searchAll(persons);
                break;
            case 2:
                //�����޸Ľ�ʦ��Ϣ����
                this.fix(persons);
                break;
            case 3:
                //ɾ����ʦ��Ϣ����
                this.delete(persons);
                break;
            default:
                System.out.println("������������������");
                tea_mune(persons);
                break;
        }
    }


}

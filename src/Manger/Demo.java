package Manger;

import java.util.ArrayList;

public class Demo {

    /**
     *     ����տ�ʼ�ӳ�����ڸտ�ʼ������д�õĹ���FileToObject,���ǰ��ļ���Ϣת��Ϊ�����ArrayList<Person> persons�����
     *     Ȼ���ж������persons(������)�ǲ��ǿ�,����ǿյľ��ڿ���̨����ļ�û���ݣ���һ������
     *     Ȼ�����½������
     *
     */
    public static void main(String[] args) {
        String filename = "Student.txt"; //�ļ���
        //ע�����persons�ĵط���Ϊ���ж��������ϲ����Կ��Կ���Ϊȫ�ֱ��� persons
        ArrayList<Person> persons = (ArrayList<Person>) FileReaderorWriter.FileToObject(filename); //�ļ���ȡ���ļ�д��
        if (persons == null) {
            System.out.println("�ļ�û���ݣ���һ������");  //123456
            persons = new ArrayList<Person>();        //��Ϊǰ��ĸ�ֵΪnull[��],�����൱����һ�����¸�ֵ
            System.out.println("�������˺�");
            String in1 = Utils.scan();                //Utils.scan()�����ַ�������
            System.out.println("����������");
            String in2 = Utils.scan();
            persons.add(new Manager(in1, in2, Person.MANAGER));                 //��Ϊһ��ʼû���û���Ϣ����һ��ʼ�����Ĺ���Ȩ��Ϊ����Ա
        }

        //����ѭ������,ֱ���Լ����������ʱ�����˳�
        while (true) {
            /**
             * ��¼����login�����û���Ȩ��Ȼ�󷵻�һ������person,ÿ��person����Ӧ�Լ������
             * ����������Ҳ���ָ��������û���Ϣ�ͻ᷵��һ��null�յ�ֵ,�ͻ��ڿ���̨�����¼ʧ��
             */

            Person person = Person.login(persons);

            if (person != null) {
                person.mune(persons);//�����Ϊ�վ�˵���Ѿ���¼���Լ����˺�,�����Լ����˺Ŷ�Ӧ��mune
            } else {
                System.out.println("��¼ʧ��");
            }
            System.out.println("�˳�������n");
            if ("N".equalsIgnoreCase(Utils.scan())) {
                FileReaderorWriter.objectToFile(persons, filename);
                break;
            }
        }
    }

}

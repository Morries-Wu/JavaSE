package Thread;

/**
 * ����:�����ͬ��������ɻ��಻�ͷ���Դ
 * �Ӷ�����ȴ�,һ�㷢����ͬ���г��ж���������
 */
public class Syn_Test05{
    public static void main(String[] args) {
        Markup girl1 = new Markup(0, "�Ű�֥");
        Markup girl2 = new Markup(2, "����");
        girl1.start();
        girl2.start();
    }
}
//����:	��Ҫ��ͬһ���������,ͬʱ	���ж���������


//�൱��������ͬʱ����һ�ֶ���,һ�����վ���,һ�����ÿں죬������Ŀ������������һ�������ó�һ����
//������Ϊ�����˶���������ϸ��Է�����ÿ���˾�ֻ���Լ����Լ���
//�ں�
class Lipstick {
}

//����
class Mirror {
}

//��ױ
class Markup extends Thread {
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // ѡ��
    int choice;
    // ����
    String girl;

    public Markup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    public void run() {
        // ��ױ
        markup02();
    }

    // �໥���жԷ��Ķ�����,�����������
    private void markup01() {
        if (choice == 0) {
            synchronized (lipstick) {// ��ÿں����
                System.out.println(this.girl + "Ϳ�ں�");
                // 1�����ӵ�о��ӵ���
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println(this.girl + "�վ���");
                }
            }
        } else {
            synchronized (mirror) {// ��þ��ӵ���
                System.out.println(this.girl + "�վ���");
                // 2�����ӵ�пں����
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    System.out.println(this.girl + "Ϳ�ں�");
                }
            }
        }
    }

    private void markup02() {
        if (choice == 0) {
            synchronized (lipstick) {// ��ÿں����
                System.out.println(this.girl + "Ϳ�ں�");
                // 1�����ӵ�о��ӵ���
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (mirror) {
                System.out.println(this.girl + "�վ���");
            }
        } else {
            synchronized (mirror) {// ��þ��ӵ���
                System.out.println(this.girl + "�վ���");
                // 2�����ӵ�пں����
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstick) {
                System.out.println(this.girl + "Ϳ�ں�");
            }
        }
    }

}

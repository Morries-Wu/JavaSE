package Thread;

//Э��ģ��:������������ʵ�ַ�ʽһ:�̷ܳ�
//����������
public class Cooperation_Test01 {
    public static void main(String[] args) {
        SysContainer container = new SysContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }
}

//������
class Productor extends Thread {
    SysContainer container;

    public Productor(SysContainer container) {
        this.container = container;
    }

    public void run() {
        // ����
        for (int i = 0; i < 100; i++) {
            System.out.println("����" + i + "����ͷ");
            container.push(new Goods(i));
        }
    }
}

//������
class Consumer extends Thread {
    SysContainer container;

    public Consumer(SysContainer container) {
        this.container = container;
    }

    public void run() {
        // ����
        for (int i = 0; i < 1000; i++) {
            System.out.println("����" + container.pop().id + "����ͷ");
        }
    }
}

//������
class SysContainer {
    Goods buns[] = new Goods[10];// �洢��������
    int count = 0;// ������

    // �洢 ����
    public synchronized void push(Goods bun) {
        // ��ʱ������ �������ڿռ�
        if (count == buns.length) {
            try {
                this.wait();// �߳����� ������֪ͨ�������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //���ڿռ� ��������
        buns[count] = bun;
        count++;
        this.notifyAll();//����������,����֪ͨ�Է�������
    }

    // ��ȡ
    public synchronized Goods pop() {
        /**
         *��ʱ���� �������Ƿ��������
         * �������ݿ����� û������ֻ�еȴ�
         */
        if (count == 0) {
            try {
                this.wait();// �߳����� ������֪ͨ���ѽ������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Goods bun = buns[count];
        this.notifyAll();// ���ڿռ���,���Ի��ѶԷ�����
        return bun;
    }
}

//��Ʒ
class Goods {
    int id;

    public Goods(int id) {
        super();
        this.id = id;
    }
}

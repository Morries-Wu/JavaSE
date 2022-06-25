package Thread;

//�̰߳�ȫ:�ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
//synchronized
//1.ͬ������
//2.ͬ����
public class Syn_Test02 {
    public static void main(String[] args) {
        // �˻�
        Account account = new Account(100, "������");
        SynDrawing you = new SynDrawing(account, 80, "˧������");
        SynDrawing wifi = new SynDrawing(account, 90, "happy����");
        you.start();
        wifi.start();

    }
}

class SynDrawing extends Thread {

    Account account;// ȡǮ�˻�
    int drawingMoney;// ȡ��Ǯ��
    int pocketTotal;// �ڴ�������

    public SynDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    public void run() {
        test();
    }

    // Ŀ������ʧ�� ���ﲻ����this Ӧ������account
    public void test() {
        if (account.money <= 0)
            return;
        //ͬ����
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "����ȡ������߳�������������ٴγ���");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawingMoney;
            pocketTotal = pocketTotal + drawingMoney;
            System.out.println(this.getName() + "�˻����Ϊ:" + account.money);
            System.out.println(this.getName() + "�ڴ���ǮΪ:" + pocketTotal);
        }
    }
}

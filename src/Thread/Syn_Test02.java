package Thread;

//线程安全:在并发时保证数据的正确性、效率尽可能高
//synchronized
//1.同步方法
//2.同步块
public class Syn_Test02 {
    public static void main(String[] args) {
        // 账户
        Account account = new Account(100, "结婚礼金");
        SynDrawing you = new SynDrawing(account, 80, "帅气的我");
        SynDrawing wifi = new SynDrawing(account, 90, "happy的她");
        you.start();
        wifi.start();

    }
}

class SynDrawing extends Thread {

    Account account;// 取钱账户
    int drawingMoney;// 取的钱数
    int pocketTotal;// 口袋的总数

    public SynDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    public void run() {
        test();
    }

    // 目标锁定失败 这里不是锁this 应该锁定account
    public void test() {
        if (account.money <= 0)
            return;
        //同步块
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "您的取款金额过高超过存折余额请再次尝试");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawingMoney;
            pocketTotal = pocketTotal + drawingMoney;
            System.out.println(this.getName() + "账户余额为:" + account.money);
            System.out.println(this.getName() + "口袋的钱为:" + pocketTotal);
        }
    }
}

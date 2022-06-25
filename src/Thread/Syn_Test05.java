package Thread;

/**
 * 死锁:过多的同步可能造成互相不释放资源
 * 从而互相等待,一般发生于同步中持有多个对象的锁
 */
public class Syn_Test05{
    public static void main(String[] args) {
        Markup girl1 = new Markup(0, "张柏芝");
        Markup girl2 = new Markup(2, "王菲");
        girl1.start();
        girl2.start();
    }
}
//避免:	不要在同一个代码块中,同时	持有多个对象的锁


//相当于两个人同时用另一种东西,一个人照镜子,一个人用口红，但最终目的是想两个都一起派上用场一起用
//就是因为两个人都拿着死活不肯给对方所以每个人就只能自己干自己的
//口红
class Lipstick {
}

//镜子
class Mirror {
}

//化妆
class Markup extends Thread {
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // 选择
    int choice;
    // 名字
    String girl;

    public Markup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    public void run() {
        // 化妆
        markup02();
    }

    // 相互持有对方的对象锁,可能造成死锁
    private void markup01() {
        if (choice == 0) {
            synchronized (lipstick) {// 获得口红的锁
                System.out.println(this.girl + "涂口红");
                // 1秒后想拥有镜子的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println(this.girl + "照镜子");
                }
            }
        } else {
            synchronized (mirror) {// 获得镜子的锁
                System.out.println(this.girl + "照镜子");
                // 2秒后想拥有口红的锁
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    System.out.println(this.girl + "涂口红");
                }
            }
        }
    }

    private void markup02() {
        if (choice == 0) {
            synchronized (lipstick) {// 获得口红的锁
                System.out.println(this.girl + "涂口红");
                // 1秒后想拥有镜子的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (mirror) {
                System.out.println(this.girl + "照镜子");
            }
        } else {
            synchronized (mirror) {// 获得镜子的锁
                System.out.println(this.girl + "照镜子");
                // 2秒后想拥有口红的锁
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstick) {
                System.out.println(this.girl + "涂口红");
            }
        }
    }

}

package Thread;

//协作模型:生产者消费者实现方式一:管程法
//借助缓冲区
public class Cooperation_Test01 {
    public static void main(String[] args) {
        SysContainer container = new SysContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }
}

//生产者
class Productor extends Thread {
    SysContainer container;

    public Productor(SysContainer container) {
        this.container = container;
    }

    public void run() {
        // 生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产" + i + "个馒头");
            container.push(new Goods(i));
        }
    }
}

//消费者
class Consumer extends Thread {
    SysContainer container;

    public Consumer(SysContainer container) {
        this.container = container;
    }

    public void run() {
        // 消费
        for (int i = 0; i < 1000; i++) {
            System.out.println("消费" + container.pop().id + "个馒头");
        }
    }
}

//缓冲区
class SysContainer {
    Goods buns[] = new Goods[10];// 存储数据容器
    int count = 0;// 计数器

    // 存储 生产
    public synchronized void push(Goods bun) {
        // 何时能生产 容器存在空间
        if (count == buns.length) {
            try {
                this.wait();// 线程阻塞 消费者通知生产解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间 可以生产
        buns[count] = bun;
        count++;
        this.notifyAll();//存在数据了,可以通知对方消费了
    }

    // 获取
    public synchronized Goods pop() {
        /**
         *何时消费 容器中是否存在数据
         * 存在数据可消费 没有数据只有等待
         */
        if (count == 0) {
            try {
                this.wait();// 线程阻塞 生产者通知消费解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Goods bun = buns[count];
        this.notifyAll();// 存在空间了,可以唤醒对方生产
        return bun;
    }
}

//商品
class Goods {
    int id;

    public Goods(int id) {
        super();
        this.id = id;
    }
}

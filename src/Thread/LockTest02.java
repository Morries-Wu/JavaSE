package Thread;

/**
 * 不可重入锁:锁不可以延续使用
 */
public class LockTest02 {
    Lock lock = new Lock();

    public void A() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlock();
    }

    //不可重入
    public void doSomething() throws InterruptedException {
        lock.lock();
        //.....
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest02 test = new LockTest02();
        test.A();
        test.doSomething();
    }

}

//不可重入锁
class Lock {
    //是否占用
    private boolean isLocked = false;

    //使用锁
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
    //释放锁
}

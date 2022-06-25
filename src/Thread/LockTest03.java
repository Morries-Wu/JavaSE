package Thread;

/**
 * 可重入锁:锁可以延续使用
 */
public class LockTest03 {
    ReLock lock = new ReLock();

    public void A() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
    }

    //不可重入
    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        //.....
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest03 test = new LockTest03();
        test.A();
        test.doSomething();
    }

}

//可重入锁
class ReLock {
    //是否占用
    private boolean isLocked = false;
    private Thread lockedBy = null;//存储线程

    public int getHoldCount() {
        return holdCount;
    }

    private int holdCount = 0;

    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (isLocked && lockedBy != thread) {
            wait();
        }
        isLocked = true;
        lockedBy = thread;
        holdCount++;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == lockedBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                notify();
                lockedBy = null;
            }
        }

    }
    //释放锁
}

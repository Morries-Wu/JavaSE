package Thread;

/**
 * ��������:����������ʹ��
 */
public class LockTest03 {
    ReLock lock = new ReLock();

    public void A() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
    }

    //��������
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

//��������
class ReLock {
    //�Ƿ�ռ��
    private boolean isLocked = false;
    private Thread lockedBy = null;//�洢�߳�

    public int getHoldCount() {
        return holdCount;
    }

    private int holdCount = 0;

    //ʹ����
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
    //�ͷ���
}

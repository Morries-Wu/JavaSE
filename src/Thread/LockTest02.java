package Thread;

/**
 * ����������:������������ʹ��
 */
public class LockTest02 {
    Lock lock = new Lock();

    public void A() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlock();
    }

    //��������
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

//����������
class Lock {
    //�Ƿ�ռ��
    private boolean isLocked = false;

    //ʹ����
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
    //�ͷ���
}

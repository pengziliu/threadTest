package lock;

/**
 * Created by liuzp on 2018/5/23.
 */
public class MyLockTest {

    private MyLock lock = new MyLock();

    private int a ;

    public int getNext(){
        lock.lock();
        int c = a++;
        lock.unlock();
        return c;
    }

    public static void main(String[] args) {
        MyLockTest myLockTest = new MyLockTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "--"+myLockTest.getNext());

                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "--"+myLockTest.getNext());

                }
            }
        }).start();


    }


}

package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuzp on 2018/5/23.
 */
public class Demo {

    private int index = 0;
    Lock lock = new ReentrantLock();

    public  int getCreteIndex(){
        lock.lock();
        int a =  index++;
        lock.unlock();
        return  a;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName()+"-"+ demo.getCreteIndex());
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName()+"-"+demo.getCreteIndex());
                }
            }
        }).start();

    }



}

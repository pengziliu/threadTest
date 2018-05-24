package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuzp on 2018/5/24.
 */
public class Singleton {

    private static Singleton singleton = null;
    private static Lock lock = new ReentrantLock();

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton == null){
            lock.lock();
            if(singleton == null){
                singleton = new Singleton();
            }
            lock.unlock();
        }
        return  singleton;
    }

    public static void main(String[] args) {

        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton.getInstance());
                }
            }).start();


        }


    }

}

package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liuzp on 2018/5/24.
 * CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 *
 * 适用于在所有线程执行完后 执行命令
 *
 * 比如，等都干完活了，开始吃完
 *
 */
public class Demo implements Runnable{

    private CountDownLatch countDownLatch;

    public Demo ( CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "=>我干完活了");
        countDownLatch.countDown();
    }


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Demo demo = new Demo(countDownLatch);
        for(int i=0;i<10;i++){
            new Thread(demo).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全都干完了，开始吃饭");

    }

}

package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by liuzp on 2018/5/24.
 * 以人到齐开会为例，人齐了-》开会-》每个人发言
 *
 *  字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，
 * CyclicBarrier可以被重用。我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
 */
public class Demo {

    private static CyclicBarrier cyclicBarrier;

    public Demo(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;

    }

    public static void  metting(){
        System.out.println(Thread.currentThread().getName()+ "到达会议室>"+cyclicBarrier.getNumberWaiting());
        try {
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+ "我发言");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier =  new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("到齐了，开整吧");
            }
        });
        Demo demo = new Demo(cyclicBarrier);

        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.metting();
                }
            }).start();
        }


    }



}

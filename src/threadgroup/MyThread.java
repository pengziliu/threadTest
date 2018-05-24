package threadgroup;

/**
 * Created by liuzp on 2018/5/24.
 */
public class MyThread extends Thread  {


    public MyThread(ThreadGroup threadGroup,String name){
        super(threadGroup,name);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"==跑起来了");
        }

    }
}

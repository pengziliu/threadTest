package threadgroup;

/**
 * Created by liuzp on 2018/5/24.
 */
public class Demo {


    public static void main(String[] args)  {
        ThreadGroup threadGroup = new ThreadGroup("我的线程组");
        for(int i=0;i< 5;i++){
            new MyThread(threadGroup,"i="+i).start();
        }
        try {
            Thread.sleep(4000);
            threadGroup.stop();
            System.out.println("zanting");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuzp on 2018/5/23.
 */
public class Index {

    private AtomicInteger a  = new AtomicInteger(0);

    public int getNext(){
        return a.incrementAndGet();
    }

    public static void main(String[] args) {
        Index index = new Index();
         for(int i=0 ;i< 50;i++){
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println("="+index.getNext());
                 }
             }).start();

         }

    }


}

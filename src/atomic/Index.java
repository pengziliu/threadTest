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
         for(int i=0 ;i< 2;i++){
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     while (true){
                         try {
                             Thread.sleep(100);
                         } catch (InterruptedException e) {
                         }
                         System.out.println(Thread.currentThread().getName()+"="+index.getNext());
                     }
                 }
             }).start();
         }
    }


}

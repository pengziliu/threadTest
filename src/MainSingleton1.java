import singleton.Singleton1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuzp on 2018/5/23.
 */
public class MainSingleton1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for(int i=0;i<20;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton1.getInstance());
                }
            });
        }
        executorService.shutdown();
    }

}

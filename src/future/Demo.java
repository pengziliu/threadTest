package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by liuzp on 2018/5/24.
 * 能够拿到线程执行结果
 *
 */
public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        };

        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        //异步操作
        System.out.println("do some thing");
        new Thread(future).start();
        //拿到线程执行结果
        int a = future.get();
        System.out.println(a);




    }

}

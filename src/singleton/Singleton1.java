package singleton;

/**
 * Created by liuzp on 2018/5/23.
 */
public class Singleton1 {

    private static volatile Singleton1 singleton1 = null;

    private Singleton1(){}

//    public synchronized static Singleton1 getInstance(){
//        if(singleton1 == null){
//            singleton1 =  new Singleton1();
//        }
//        return singleton1;
//    }

    public  static Singleton1 getInstance(){
        if(singleton1 == null){
            synchronized (Singleton1.class){
                //此处可能发生指令重排序问题，如果先执行了if里面的然后再执行if就会出问题，因此此处需要加关键字 volatile修饰即可，禁止指令重排序
                if(singleton1 == null ){
                    singleton1 = new Singleton1();
                }
            }
        }
        return  singleton1;
    }


}

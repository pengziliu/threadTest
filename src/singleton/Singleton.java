package singleton;

/**
 * Created by liuzp on 2018/5/23.
 * 恶汉  线程安全
 */
public class Singleton {

    private static  Singleton singleton = new Singleton();

    private Singleton(){}

    public  static Singleton getInstance(){
        return  singleton;

    }
}

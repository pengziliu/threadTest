import singleton.Singleton;

/**
 * Created by liuzp on 2018/5/23.
 */
public class MainSingleton {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton);
        System.out.println(singleton1);
        //打印出来hash值一致

    }


}

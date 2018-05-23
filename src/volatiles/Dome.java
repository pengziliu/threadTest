package volatiles;

/**
 * Created by liuzp on 2018/5/23.
 */
public class Dome {

     private volatile   int a ;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Dome dome = new Dome();

        new Thread(new Runnable() {
            @Override
            public void run() {
                dome.setA(10);
                System.out.println("111 "+dome.a);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(dome.getA() == 10){
                        System.out.println("222"+dome.a);
                        break;
                    }
                }
            }
        }).start();
    }


}

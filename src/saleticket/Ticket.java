package saleticket;

/**
 * Created by liuzp on 2018/5/23.
 */
public class Ticket implements Runnable {

    private int total;

    public Ticket(int total){
        this.total=total;
    }

    public synchronized void sale(){
        if(total<=0){
            System.out.println(Thread.currentThread().getName()+"卖完了"+total);
            return;
        }
        total --;
        System.out.println(Thread.currentThread().getName()+"当前票为"+total+"--还剩下"+total);
    }

    @Override
    public void run() {
        sale();
    }

    public static void main(String[] args) {
        Ticket ticket  =  new Ticket(100);

        for(int a = 0;a < 130;a++){
            new Thread(ticket).start();
        }

    }


}

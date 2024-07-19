package zcc.base;

public class Thread2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"----");
    }

    public static void main(String[] args) {
        Thread2 Thread2 = new Thread2();
        Thread Thread = new Thread(Thread2);
        Thread.start();
    }
}

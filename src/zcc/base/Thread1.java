package zcc.base;

public class Thread1 extends Thread{
    public void run() {
        System.out.println("MyThread.run()");
    }
    public static void main(String[] args) {
        Thread1 myThread1 = new Thread1();
        myThread1.start();
    }
}

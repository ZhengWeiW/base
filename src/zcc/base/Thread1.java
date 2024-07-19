package zcc.base;

/** 
* @Description:  
* @Param:  
* @return:  
* @Author: zcc 
* @Date: 17:50 2024/7/12 
*/ 
public class Thread1 extends Thread{
    public void run() {
        System.out.println("MyThread.run()");
    }
    public static void main(String[] args) {
        Thread1 myThread1 = new Thread1();
        myThread1.start();
    }
}

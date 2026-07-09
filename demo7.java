class MyThread extends Thread {
    public void run() {
        for(int i=1;i<=5;i++){
            System.out.println("Child : " + i);
            Thread.yield();
        }
    }
}
public class demo7 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        for(int i=1;i<=5;i++){
            System.out.println("Main : " + i);
        }
    }
}

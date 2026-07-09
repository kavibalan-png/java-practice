class MyThread extends Thread {
    public void run() {
        for(int i=1;i<=5;i++){
            System.out.println("Child : " + i);
        }
    }
}
public class demo3 {
    public static void main(String[] args) throws Exception {
        MyThread t=new MyThread();
        t.start();
        t.join();
        System.out.println("Main Finished");
    }
}
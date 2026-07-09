class MyThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Child Thread : " + i);
                Thread.sleep(1000);   // Pause for 1 second
            }

        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
    }
}
public class demo6 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}

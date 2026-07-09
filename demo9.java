class MyThread extends Thread {
    public void run() {
        System.out.println("Running");
    }
}
public class demo9 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        System.out.println(t.isAlive());
        t.start();
        System.out.println(t.isAlive());
    }
}

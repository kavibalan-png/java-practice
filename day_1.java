// Swapping without using third variable
public class day_1 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        a = a - b;
        b = b + a;
        a = b - a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
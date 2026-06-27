import java.util.Scanner;

public class WaterBottles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numBottles = sc.nextInt();
        int numExchange = sc.nextInt();

        int total = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            total += newBottles;
            empty = newBottles + (empty % numExchange);
        }

        System.out.println(total);
    }
}
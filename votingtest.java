import java.util.Scanner;

public class votingtest {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your age");
            int age = input.nextInt();

            if (age >= 18) {
                System.out.println("Eligible to voting");
            } else {
                System.out.println("Not Eligible to voting");
            }
        }
    }
}

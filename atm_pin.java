 import java.util.*;

public class atm_pin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int right_pin = 1432;
        int attempts = 0;

        do {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (pin == right_pin) {
                System.out.println("PIN is correct");
                return;
            } else {
                attempts++;
                System.out.println("Login Failed");
            }

        } while (attempts < 3);

        System.out.println("Card Blocked");
        sc.close();
    }
}
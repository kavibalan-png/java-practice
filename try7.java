import java.util.InputMismatchException;
import java.util.Scanner;
public class try7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            System.out.println("Age: " + age);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");

        }
        sc.close();
    }
}

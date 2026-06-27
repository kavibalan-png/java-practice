import java.util.Scanner;

public class NameAge {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }
}

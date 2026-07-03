import java.io.File;
import java.util.Scanner;
public class file2 {
    public static void main(String[] args) {
        try {
            File file = new File("student.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("File Not Found.");
        }
    }
}
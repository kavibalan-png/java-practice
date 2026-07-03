import java.io.File;
public class file3 {
    public static void main(String[] args) {
        File file = new File("student.txt");
        if (file.exists()) {
            System.out.println("File Exists.");
        } else {
            System.out.println("File Does Not Exist.");
        }
    }
}
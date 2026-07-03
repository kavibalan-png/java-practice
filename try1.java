import java.io.FileNotFoundException;
import java.io.FileReader;
public class try1 {
    public static void main(String[] args) 
    {
        try {
            FileReader file = new FileReader("data.txt");
            System.out.println("File Opened Successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        }
    }
}


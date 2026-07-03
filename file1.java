import java.io.FileWriter;
import java.io.IOException;
public class file1 {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("student.txt");
            writer.write("Name: KAVIBALAN R\n");
            writer.write("Age: 19\n");
            writer.write("EPPOVMAA NAMMATHAAN\n");
            writer.close();
            System.out.println("Data Written Successfully.");
        } catch (IOException e){
            System.out.println("Error Writing File.");
        }
    }
}

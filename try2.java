import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class try2 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "1234"
            );
            System.out.println("Database Connected.");
        } catch (SQLException e) {
            System.out.println("Database Connection Failed.");

        }

    }
}

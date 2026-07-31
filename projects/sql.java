// import java.sql.Connection;
// import java.sql.DriverManager;



// public class sql {

//     public static void main(String[] args) {

// String url = "jdbc:mysql://localhost:3306/empolyee";    
//     String user = "root";
//         String password = "root";

//         try {

//             Connection con = DriverManager.getConnection(url, user, password);

//             System.out.println("Connected Successfully!");

//             con.close();

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
import java.sql.*;
public class sql {
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student",
                "root",
                "Kavi@123"
            );
            System.out.println("Database Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
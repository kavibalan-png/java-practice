package projects;
import java.sql.*;
public class JdbcExample {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/fg";
        String username = "root";
        String password = "Kavi@123"; 

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println(" Connected to MySQL!");

            // Create Statement
            Statement stmt = con.createStatement();
            // Create Table
            String createTable = """
                CREATE TABLE IF NOT EXISTS student(
                    id INT PRIMARY KEY,
                    name VARCHAR(50),
                    age INT
                )
                """;

            stmt.executeUpdate(createTable);
            System.out.println(" Table Created!");

   
            String insert = "INSERT INTO student VALUES(1,'Dinesh',19)";
            stmt.executeUpdate(insert);
            System.out.println(" Data Inserted!");

     
            String select = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nStudent Details");
            System.out.println("--------------------------");

            while (rs.next()) {
                System.out.println("ID   : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Age  : " + rs.getInt("age"));
                System.out.println();
            }

            String update = "UPDATE student SET age = 20 WHERE id = 1";
            stmt.executeUpdate(update);
            System.out.println(" Data Updated!");

           
            String delete = "DELETE FROM student WHERE id = 1";
            stmt.executeUpdate(delete);
            System.out.println(" Data Deleted!");

        
            con.close();
            System.out.println(" Connection Closed!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
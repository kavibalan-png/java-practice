package mysql-connector;
import java.sql.*;
public class insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fg";
        String user = "root";
        String password = "Kavi@123";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO employee(id,name) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 5);
            ps.setString(2, "balan");
            int rows = ps.executeUpdate();
            System.out.println(rows + " Row Inserted");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
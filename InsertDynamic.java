import java.util.Scanner;
import java.sql.*;

public class InsertDynamic {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mits";
        String user = "root";
        String password = "Harini***25";
        Scanner sc = new Scanner(System.in);
        try (Connection c = DriverManager.getConnection(url, user, password);
             PreparedStatement p = c.prepareStatement("insert into stu19 values(?,?)")) {
            System.out.println("Enter Id:");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.println("Enter Name:");
            String name = sc.nextLine();
            p.setInt(1, id);
            p.setString(2, name);
            int res = p.executeUpdate();
            System.out.println("The updated row count is: " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
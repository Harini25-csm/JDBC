import java.sql.*;

public class Display {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/mits";
        String user = "root";
        String password = "Harini***25";
        String query = "select * from stu19";
        try (Connection c=DriverManager.getConnection(url,user,password);
        Statement s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=s.executeQuery(query)){
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
            System.out.println();
            while(rs.previous()){
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

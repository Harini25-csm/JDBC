import java.sql.*;
import java.util.Scanner;
public class EmployeeConn {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/Emp_db";
        String user="root";
        String password="Harini***25";
        try(Connection c = DriverManager.getConnection(url, user, password)){
            System.out.println("Database connected successfully!");
            Statement s = c.createStatement();
            s.executeUpdate("drop table if exists emp");
            s.executeUpdate("create table emp "
                +"(id int primary key, "
                +"name varchar(20), "
                +"jobrole varchar(20), "
                +"hire_date date, "
                +"salary int)"
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

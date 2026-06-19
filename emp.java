import java.sql.*;
import java.util.Scanner;

public class emp {
    public static void add(){
        Scanner sc=new Scanner(System.in);
        try(Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp_db","root","Harini***25");
        PreparedStatement p=c.prepareStatement("insert into emp values(?,?,?,?,?)"))
        {
            System.out.println("Enter emp details:");
            System.out.println("Enter emp_id:");
            p.setInt(1,sc.nextInt());
            sc.nextLine();
            System.out.println("Enter emp_name:");
            p.setString(2,sc.nextLine());
            System.out.println("Enter emp_jobrole:");
            p.setString(3,sc.nextLine());
            System.out.println("Enter emp_hire_date (YYYY-MM-DD):");
            p.setString(4,sc.next());
            sc.nextLine();
            System.out.println("Enter emp_salary:");
            p.setInt(4,sc.nextInt());
            sc.nextLine();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void display(){
        Scanner sc=new Scanner(System.in);
        try(Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp_db","root","Harini***25");
        Statement p=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=p.executeQuery("select*from emp")){
        while(rs.next()){
            System.out.println(
                rs.getInt(1)+" "
                +rs.getString(2)+" "
                +rs.getString(3)+" "
                +rs.getString(4)+" "
                +rs.getInt(5)+" "
            );
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void update(){
        Scanner sc=new Scanner(System.in);
        try(Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp_db","root","Harini***25");
        PreparedStatement p=c.prepareStatement("update emp set salary=? where id=?"))
        {
            System.out.println("Enter emp_id:");
            p.setInt(1,sc.nextInt());
            sc.nextLine();
            System.out.println("Enter emp_salary:");
            p.setInt(4,sc.nextInt());
            sc.nextLine();
            int res=p.executeUpdate();
            System.out.println(res+" Record deleted");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void delete(){
        Scanner sc=new Scanner(System.in);
        try(Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp_db","root","Harini***25");
        PreparedStatement p=c.prepareStatement("delete from emp where id=?"))
        {
            System.out.println("Enter emp_id:");
            p.setInt(1,sc.nextInt());
            int res=p.executeUpdate();
            System.out.println(res+" Record deleted");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void displayColumns(){
        Scanner sc=new Scanner(System.in);
        String colName=sc.next();
        try(Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp_db","root","Harini***25");
        Statement p=c.createStatement();
        ResultSet rs=p.executeQuery("select "+ colName +" from emp"))
        {
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Display Column Details");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    add();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    displayColumns();
                    break;
                case 6:
                    System.out.println("Thank You");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

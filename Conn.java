import java.sql.*;

public class Conn {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mits";
        String user="root";
        String password="Harini***25";
        //1. Establish the connection
        try(Connection conn=DriverManager.getConnection(url,user,password)){
            System.out.println("Database Connection successfully!");
            //2. create statement
            Statement st = conn.createStatement();
            st.executeUpdate("drop table if exists stu19");
            //3. create table if it does not exist
            int s = st.executeUpdate("create table if not exists stu19 "
                + "(id int primary key, "
                + "name varchar(20))");
            //4. insert static values and skip duplicates if run again
            int inserted = st.executeUpdate("insert into stu19 (id, name) values "
                + "(1, 'Harini'), (2, 'Iqra'), (3, 'Shazia'), (4,'Devi'), (5,'suma'), (6,'xyz') "
                );
            int updated=st.executeUpdate("update stu19 set name='ramu' where id=6");
            st.executeUpdate("alter table stu19 rename column id to stu_id ");
            System.out.println("Table ready. Rows affected: " + inserted);
            System.out.println("Updated data:"+updated);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        // create object of Main class
        String url="jdbc:postgresql://localhost:5432/postgres";
        String userName="postgres";
        String password="root";
        String sqlStatement="select * from customers";

        try{
           Connection con= DriverManager.getConnection(url,userName,password);
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(sqlStatement);
           int columnCount=rs.getMetaData().getColumnCount();
            //System.out.println("First Name : "+rs.getString(2));
            while(rs.next()){
                for(int i=1;i<=columnCount;i++) {
                    System.out.println(rs.getMetaData().getColumnName(i) + "-> " + rs.getString(i));
                }
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
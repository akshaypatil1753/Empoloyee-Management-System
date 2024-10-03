
package employee.management.system;
/*import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conn {
 
   public static void main(String[] args) {
       Connection c;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","vaibhav@14");
        System.out.println(c);
    }catch (ClassNotFoundException ex) {
        Logger.getLogger(Conn.class.getName()).log(Level.SEVERE,null,ex);
        
    }  catch (SQLException ex) {
           Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}*/
import java.sql.*;
public class Conn {
    Connection connection;
    Statement statement;
    
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","vaibhav@14");
            statement = connection.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
            
        
        }
    }

    ResultSet executeQuery(String select__from_employee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
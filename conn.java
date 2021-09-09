package Employee;

import java.sql.*;

public class conn{
    
    public Connection c;
    public Statement s;
 
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver"); //call jdbc driver 
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"rawan3?zeroDateTimeBehavior=convertToNull","root","");//call mysql db 
            s =c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
 

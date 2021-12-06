package parking.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    static Connection con;
    public static Connection createC() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //loading the JDBC drivers
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/parking";

            con = DriverManager.getConnection(url,user,password); //connecting the drivers

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

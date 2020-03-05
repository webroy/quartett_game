
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Samira
 */
public class PlayWithDb {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");  
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadlerquartett", "learning", "learning");

        Statement stmt = con.createStatement();
        
        stmt.addBatch("insert into karte(Name, Höchstgeschwindigkeit, Beschleunigung, VerkaufteProdukte) " +
                "VALUES (SMILE, 250, 18, 29)");      
        
        
        ResultSet rs = stmt.executeQuery("select * from karte");
        
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        }
        //con.close();
   
  
} 
    

}

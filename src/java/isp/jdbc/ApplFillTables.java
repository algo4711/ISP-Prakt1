/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isp.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class ApplFillTables {

   Connection dbConn;
   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      ApplFillTables myAppl = new ApplFillTables();
      myAppl.doSomething();
    }
    
    public void doSomething() throws ClassNotFoundException, SQLException {
		
		dbConn = new MySqlAccess().getConnection();
                insertUser(102, "Alexander", "Gogol", "alexander.gogol@email.de", "06205/0815", "EDV", "47110815", "besteller", "J", "J", "geheim");


	}
    
    
     public void insertUser(int personalId, String vorname, String nachname, String email, String telNr, String abteilung, 
                            String kostenstelle, String verantw, String admin, String aktiv, String passwort) throws SQLException{
        
        String sql = "INSERT INTO USER"
                + "(personalId, vorname, nachname, email, telNr, abteilung, kostenstelle, verantw, admin, aktiv, passwort)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,AES_ENCRYPT(?,'geheim'))";
        PreparedStatement prep = dbConn.prepareStatement(sql);
        
        prep.setInt(1, personalId);
        prep.setString(2, vorname);
        prep.setString(3, nachname);
        prep.setString(4, email);
        prep.setString(5, telNr);
        prep.setString(6, abteilung);
        prep.setString(7, kostenstelle);
        prep.setString(8, verantw);
        prep.setString(9, admin);
        prep.setString(10, aktiv);
       prep.setString(11, passwort);
        
        prep.executeUpdate();
		
        System.out.println("USER mit der Pers.Id. " +personalId +" " +vorname+" "+nachname+" wurden eingefügt!");
                
        
    }
}

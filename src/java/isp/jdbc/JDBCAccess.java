/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isp.jdbc;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Alex
 */
public abstract class JDBCAccess {

  Connection dbConn;
	
	String dbDriverName;
	String dbUrl;
	String dbUser;
	String dbPassword;
	String dbSchema;
	
	public JDBCAccess() throws ClassNotFoundException, SQLException{
		this.setDbParms();
		this.createConnection();
	//	this.setSchema();
	}
	
	public abstract void setDbParms();
 
//    public void setSchema() throws SQLException{
//		String sql = "SET SCHEMA ?";
//		System.out.println(sql);
//                PreparedStatement prepstat = dbConn.prepareStatement(sql);
//		prepstat.setString(1, dbSchema);
//		prepstat.executeUpdate();
//		System.out.println("Schema: "+ dbSchema + " erfolgreich gesetzt!");
//	}
	
	public void createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(dbDriverName);
		System.out.println("DB2 Treiber erfolgreich geladen!");
		
		dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		
		System.out.println("\nDatenbankverbindung erfolgreich!");
                               
             
	}
	
	public Connection getConnection() throws SQLException
	{
			return dbConn;
			
	}
    
}

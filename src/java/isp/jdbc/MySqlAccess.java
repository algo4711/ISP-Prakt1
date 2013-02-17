/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isp.jdbc;

import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class MySqlAccess extends JDBCAccess{

    public MySqlAccess() throws ClassNotFoundException, SQLException
    {
        super();
    }

    @Override
    public void setDbParms() {
       dbDriverName = "com.mysql.jdbc.Driver";
       dbUrl = "jdbc:mysql://localhost:3306/isp-test";
        dbUser = "root";
	dbPassword = "";
	dbSchema = "";
    }
    
    public static void main (String[] args) throws ClassNotFoundException, SQLException{
        new MySqlAccess();
    }
}

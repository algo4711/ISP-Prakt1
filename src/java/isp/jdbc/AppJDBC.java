/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isp.jdbc;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.*;
import sun.net.smtp.SmtpClient;
import java.util.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppJDBC {
    
    Connection dbConn;
    
     public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, ServletException {
     AppJDBC myApp = new AppJDBC();
     myApp.doSomething();

    }

    public void doSomething() throws SQLException, ClassNotFoundException, IOException, ServletException{
		dbConn = new MySqlAccess().getConnection();
		//this.showUsers();
                
      //          this.showUsersPassword();
                
                this.doPost();
                
//                boolean erg = this.sendEmail();
//                System.out.println(erg);
//		this.showUsersReverse();
//		ResultSet dbRes = this.readUserTable();
//		this.showUsersTable(dbRes);
           
		
	}
   
    
    
    public void showUsers() throws SQLException{
		
		String sql = "SELECT * FROM USER " ;
		System.out.println(sql);
		Statement stat = dbConn.createStatement();
		ResultSet dbRes = stat.executeQuery(sql);
		System.out.println("ResultSet erfolgreich gelesen");
		//System.out.println(dbRes);
	
		while(dbRes.next())
		{
			System.out.print(dbRes.getString("admin")+ "\n ");
                			
		}
	}
    
    public void showUsersPassword() throws SQLException{
		
		String sql = "SELECT AES_DECRYPT(passwort, 'geheim') FROM USER " ;
		System.out.println(sql);
		Statement stat = dbConn.createStatement();
		ResultSet dbRes = stat.executeQuery(sql);
		System.out.println("ResultSet erfolgreich gelesen");
		//System.out.println(dbRes);
	
		while(dbRes.next())
		{
                    String passwort = dbRes.getString(1);
                    if (passwort != null)
			System.out.print(dbRes.getString(1) + "\n");
                    else
                        System.out.println("Passwort unverschlüsselt oder fehlerhaft!");
		}
	}
    
    
    // TEST der Mailfunktion!!!
//    public boolean sendEmail() throws IOException{
//              
//    String m_sSMTPServer = "smtp.1blu.de";
//    String m_sSender    = "alexander@gogolweb.de";
//    String m_sReceiver  = "alex@mailordo.de";
//    String m_sSubject    = "Test";
//    String m_sMessage  = "Dies ist ein Test";
//
//
//      try
//      {
//        SmtpClient client = new SmtpClient(m_sSMTPServer);
//        client.from(m_sSender);
//        client.to(m_sReceiver);
//        PrintStream message = client.startMessage();
//        message.println("To: " + m_sReceiver);
//        message.println("Subject:  " + m_sSubject);
//        message.println(m_sMessage);
//        client.closeServer();
//        return (true);
//      }
//      catch (IOException e)
//      {
//        return (false);
//      }
//  }

   public void doPost()
throws ServletException, IOException
{
try {
String recipient = "alex@mailordo.de";
String subject = "Hotlinemeldung";
String message = "Testmail";
String from = "alexander@gogolweb.de";

Properties props = new Properties();
props.put("mail.smtp.host","smtp.1blu.de");
props.put("mail.transport.protocol","smtp");

Session session1 = Session.getDefaultInstance(props,null);

Message msg = new MimeMessage( session1 );

InternetAddress addressFrom = new InternetAddress( from );
msg.setFrom( addressFrom );

InternetAddress addressTo = new InternetAddress( recipient );
msg.setRecipient( Message.RecipientType.TO, addressTo );

msg.setSubject( subject );
msg.setContent( message, "text/plain" );

Transport.send( msg );
}

catch (Exception e)
{ System.out.println("Fehler beim Senden: " + e); }
}

   
    
}

import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
  
	Connection conn = null;
	
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			//I've added the EmployeeData.db in the img file folder. Just change the path to work ;)
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Paula\\Desktop\\proiecte java\\EmployeeData.db");
			JOptionPane.showMessageDialog(null, "Connection succesfull");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
	}
}

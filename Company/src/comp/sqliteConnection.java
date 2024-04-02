package comp;
import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
  
	Connection conn = null;
	
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			//I've added the EmployeeData.db in the img file folder. Just change the path to work ;)
			//also you need the jar sqlite-jdbc-3.8.7.jar that you can also find it in the img file folder
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Paula\\Desktop\\PizzaManagementSystem-main\\Company\\img\\EmployeeData.db");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
	}
	

	public static Connection dbConnector2() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Paula\\Desktop\\PizzaManagementSystem-main\\Company\\img\\OrdersInfo.db");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
	}
}

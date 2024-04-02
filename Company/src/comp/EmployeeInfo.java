package comp;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class EmployeeInfo extends JFrame  {

	static AdminPanel admin = new AdminPanel();
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo window = new EmployeeInfo();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	Connection connectionToDataBase = null;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldAge;
	
	private void refreshTable() {
		try {
			//String query = "select * from EmployeeInfo";
			String query = "select ID,Name,Surname,Username,Age from EmployeeInfo";
			PreparedStatement pst = connectionToDataBase.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			//for DbUtils you need rs2xml.jar found in img . Build Path --> class path
			table.setModel(DbUtils.resultSetToTableModel(rs));}
			catch (Exception t){
				t.printStackTrace();
			}
			
	}
	
	private String createPassword(){
		
			
			String p1 = textFieldName.getText();
			String p2 = textFieldSurname.getText();
			
			
			String password = p1.substring(0,1)+p2.substring(0,1)+"123" ;
			
			return password.toLowerCase();
			
							
	}
	
	
	private String createUsername() {
		String username = (textFieldName.getText())+"_"+(textFieldSurname.getText());
		return username;
	}
	/**
	 * Create the application.
	 */
	public EmployeeInfo() {
		connectionToDataBase = sqliteConnection.dbConnector();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Welcome ADMIN");
		frame.setBounds(100, 100, 1027, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Employee Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshTable();	
				
			}
		});
		btnLoadTable.setBounds(529, 35, 313, 71);
		frame.getContentPane().add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 117, 580, 385);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "insert into EmployeeInfo (ID,Name,Surname,Username,Password,Age) values (?,?,?,?,?,?)";
					PreparedStatement pst = connectionToDataBase.prepareStatement(query);
					pst.setString(1, textFieldID.getText());
					pst.setString(2, textFieldName.getText());
					pst.setString(3, textFieldSurname.getText());
					pst.setString(4, createUsername());
					pst.setString(5, createPassword());
					pst.setString(6, textFieldAge.getText());
					pst.execute();
					
					
					
					JOptionPane.showMessageDialog(null,"Data Saved");
					
					pst.close();
					}
					catch (Exception t){
						t.printStackTrace();
					}
					
				
				refreshTable();
					
			}
		});
		btnSave.setBounds(154, 421, 177, 38);
		frame.getContentPane().add(btnSave);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 184, 87, 32);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(154, 184, 177, 32);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 247, 87, 32);
		frame.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 305, 87, 32);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 354, 87, 32);
		frame.getContentPane().add(lblAge);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(154, 247, 177, 32);
		frame.getContentPane().add(textFieldName);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(154, 305, 177, 32);
		frame.getContentPane().add(textFieldSurname);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(154, 360, 177, 32);
		frame.getContentPane().add(textFieldAge);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//we dont want the admin to update its name
                  try {
					
					String query = "Update EmployeeInfo set ID='"+textFieldID.getText()+ "',Name='"+textFieldName.getText()+"' ,Surname='"+textFieldSurname.getText()+"',Username='"+createUsername()+"',Password='"+createPassword()+"',Age='"+textFieldAge.getText()+"' where ID='"+textFieldID.getText()+ "' AND EmployeeInfo.ID>1";
					PreparedStatement pst = connectionToDataBase.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Updated");
					
					pst.close();
					}
					catch (Exception t){
						t.printStackTrace();
					}
                  
                  refreshTable();
      				
			}
		});
		btnUpdate.setBounds(154, 470, 177, 32);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//we don't want the admin to be deleted ID > 1
				
                  try {
					
					String query = "delete from EmployeeInfo where ID='"+textFieldID.getText()+ "'  AND ID > 1";
					PreparedStatement pst = connectionToDataBase.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Deleted");
					
					pst.close();
					}
					catch (Exception t){
						t.printStackTrace();
					}

                refreshTable();
                
				
				
			
				
			}
		});
		btnDelete.setBounds(154, 513, 177, 32);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("Back to Admin Panel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(94, 35, 151, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit Application");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(816, 538, 162, 47);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}

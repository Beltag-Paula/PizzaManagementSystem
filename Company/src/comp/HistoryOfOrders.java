package comp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class HistoryOfOrders {

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
					HistoryOfOrders window = new HistoryOfOrders();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conx = null;
	private JTextField textFieldID;
	/**
	 * Create the application.
	 */
	public HistoryOfOrders() {
		initialize();
		conx = sqliteConnection.dbConnector2();
	}

	private void refreshTable() {
		try {
			String query = "select * from OI";
			//String query = "select FlavourPizza,SizePizza,PricePizza,addOns,ServiceMethods,Quantity,Total from OI";
			PreparedStatement pst = conx.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			//for DbUtils you need rs2xml.jar found in img . Build Path --> class path
			table.setModel(DbUtils.resultSetToTableModel(rs));}
			catch (Exception t){
				t.printStackTrace();
			}
	}
	
	//when we delete all the table we want to reset the ID also 
	private void refreshID() {
		try {
			
			String query2 =" UPDATE `sqlite_sequence` SET `seq` = 0 WHERE `name` = 'OI'";
			PreparedStatement pst = conx.prepareStatement(query2);
			pst.execute();
			
			
			
			pst.close();
			}
			catch (Exception t){
				t.printStackTrace();
			}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1186, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 92, 1125, 385);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Load History Orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshTable();
			}
		});
		btnNewButton.setBounds(508, 11, 160, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete All Orders");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
				String query = "delete FROM OI;";
				PreparedStatement pst = conx.prepareStatement(query);
				pst.execute();
				
				JOptionPane.showMessageDialog(null,"Data Deleted");
				
				pst.close();
				}
				catch (Exception t){
					t.printStackTrace();
				}
				
				refreshID();
				refreshTable();
			}
		});
		btnNewButton_1.setBounds(678, 11, 147, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Delete Order with ID");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
						
						String query = "delete from OI where ID='"+textFieldID.getText()+ "' ";
						PreparedStatement pst = conx.prepareStatement(query);
						pst.execute();
						
						JOptionPane.showMessageDialog(null,"Data Deleted");
						
						pst.close();
						}
						catch (Exception t){
							t.printStackTrace();
						}
				refreshID();
				refreshTable();
			}
		});
		btnNewButton_1_1.setBounds(835, 11, 147, 44);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("       Back to Admin Panel");
		btnNewButton_1_2.setForeground(Color.BLACK);
		btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\Paula\\Desktop\\PizzaManagementSystem-main\\Company\\img\\back.png"));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				admin.main(null);
			}
		});
		btnNewButton_1_2.setBounds(23, 27, 237, 54);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Exit Application");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1_3.setBounds(925, 496, 153, 44);
		frame.getContentPane().add(btnNewButton_1_3);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(992, 23, 86, 32);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		
	}
}

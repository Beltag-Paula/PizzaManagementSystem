import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = sqliteConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(158, 64, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(162, 113, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(272, 61, 130, 20);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		Image img3 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img3));
		btnLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from EmployeeInfo where username=? and password =?";
					PreparedStatement pst =  connection.prepareStatement(query);
					
					pst.setString(1, textFieldUN.getText() );
					pst.setString(2, passwordField.getText() );
					
					ResultSet rs = pst.executeQuery();
					int count =0;
					while(rs.next()) {
						count=count+1;
					}
					if(count ==1) {
						JOptionPane.showMessageDialog(null, "Username & Password are correct");
						frame.dispose();
						FastFoodManagementSystem ffms = new FastFoodManagementSystem();
						ffms.setVisible(true);
					}
					else if(count >1) {
						JOptionPane.showMessageDialog(null, "Duplicate Username & Passowrd");
					}
					else {
						JOptionPane.showMessageDialog(null, "Username & Password are incorrect.Try again.");
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
			}
		});
		btnLogin.setBounds(141, 180, 186, 39);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('#');
		passwordField.setBounds(272, 110, 130, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		Image img = new ImageIcon(this.getClass().getResource("/faceLogin.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(57, 17, 61, 76);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		Image img2 = new ImageIcon(this.getClass().getResource("/pasLogin.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img2));
		lblNewLabel_3.setBounds(56, 93, 96, 76);
		frame.getContentPane().add(lblNewLabel_3);
		
	}
}

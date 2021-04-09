import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class FastFoodManagementSystem extends JFrame {

	private JPanel contentPane;
	private JTextArea textFieldOrderDetails = new JTextArea();
	private String[] flavour = {"Pepperoni" , "BBQ Chicken" , "Hawaiian" ,"Vegetarian", "Bacon and Cheese"};
	private JComboBox cboFlavour = new JComboBox();
	private JLabel lblSmallPrice = new JLabel("");
	private JLabel lblMediumPrice = new JLabel("");
	private JLabel lblLargePrice = new JLabel("");
	private double addOnPrice = 0.00;
    private JCheckBox chkExtraCheese = new JCheckBox("Extra Cheese");
    private JCheckBox chkExtraMeat = new JCheckBox("Extra Meat");
    private JCheckBox chkMushroom = new JCheckBox("Extra Mushroom");
    private JCheckBox chkBlackOlives = new JCheckBox("Black Olives");
    private JCheckBox chkOnions = new JCheckBox("Onions");
    private JCheckBox chkSausage = new JCheckBox("Sausage");
    private JRadioButton rdoSmall = new JRadioButton("Small");
    private JRadioButton rdoMedium = new JRadioButton("Medium");
    private JRadioButton rdoLarge = new JRadioButton("Large");
    private JRadioButton rdoDineIn = new JRadioButton("Dine In");
    private JRadioButton rdoTakeOut = new JRadioButton("Take Out");
    private JRadioButton rdoDelivery = new JRadioButton("For Delivery");
    private JLabel lblQuantity = new JLabel("Quantity");
    private JLabel lblQuantity2 = new JLabel("1");
    private int qty = 1;
    private JButton btnNewButton_4 = new JButton("Order Again");
    
    private JButton btnNewButton_1 = new JButton("+");
    private JButton btnNewButton_2 = new JButton("-");
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FastFoodManagementSystem frame = new FastFoodManagementSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	/**
	 * Create the frame.
	 */
	public FastFoodManagementSystem() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				loadFlavours();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 876);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Exit to Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 contentPane.setVisible(false);
				 dispose();
				 Login login = new Login();
				 login.main(null); 
				 
			}
		});
		btnNewButton.setBounds(790, 790, 162, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Pizza Flavour :");
		lblNewLabel.setBounds(10, 21, 202, 14);
		contentPane.add(lblNewLabel);
		cboFlavour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPrices();
			}
		});
		
		//JComboBox cboFlavour = new JComboBox(); method loadFlavour !!!
		cboFlavour.setBounds(20, 46, 192, 22);
		contentPane.add(cboFlavour);
		
		JLabel sad = new JLabel("Size and Price :");
		sad.setBounds(10, 105, 202, 14);
		contentPane.add(sad);
		buttonGroup.add(rdoSmall);
		
		//JRadioButton rdoSmall = new JRadioButton("Small");
		rdoSmall.setBounds(20, 134, 109, 23);
		contentPane.add(rdoSmall);
		buttonGroup.add(rdoMedium);
		
		//JRadioButton rdoMedium = new JRadioButton("Medium");
		rdoMedium.setBounds(20, 177, 109, 23);
		contentPane.add(rdoMedium);
		buttonGroup.add(rdoLarge);
		
		//JRadioButton rdoLarge = new JRadioButton("Large");
		rdoLarge.setBounds(20, 223, 109, 23);
		contentPane.add(rdoLarge);
		
		JLabel lblNewLabel_2 = new JLabel("Extra add ons :");
		lblNewLabel_2.setBounds(10, 291, 176, 14);
		contentPane.add(lblNewLabel_2);
		
		//JCheckBox chkExtraCheese = new JCheckBox("Extra Cheese");
		chkExtraCheese.setBounds(20, 312, 136, 23);
		contentPane.add(chkExtraCheese);
		
		//JCheckBox chkExtraMeat = new JCheckBox("Extra Meat");
		chkExtraMeat.setBounds(20, 338, 130, 23);
		contentPane.add(chkExtraMeat);
		
		//JCheckBox chkMushroom = new JCheckBox("Extra Mushroom");
		chkMushroom.setBounds(20, 364, 130, 23);
		contentPane.add(chkMushroom);
		
		//JCheckBox chkBlackOlives = new JCheckBox("Black Olives");
		chkBlackOlives.setBounds(191, 312, 97, 23);
		contentPane.add(chkBlackOlives);
		
		//JCheckBox chkOnions = new JCheckBox("Onions");
		chkOnions.setBounds(191, 338, 97, 23);
		contentPane.add(chkOnions);
		
		//JCheckBox chkSausage = new JCheckBox("Sausage");
		chkSausage.setBounds(191, 364, 97, 23);
		contentPane.add(chkSausage);
		
		JLabel lblNewLabel_3 = new JLabel("Choose :");
		lblNewLabel_3.setBounds(10, 416, 46, 14);
		contentPane.add(lblNewLabel_3);
		buttonGroup_1.add(rdoDineIn);
		
		//JRadioButton rdoDineIn = new JRadioButton("Dine In");
		rdoDineIn.setBounds(20, 443, 109, 23);
		contentPane.add(rdoDineIn);
		buttonGroup_1.add(rdoTakeOut);
		
		//JRadioButton rdoTakeOut = new JRadioButton("Take Out");
		rdoTakeOut.setBounds(20, 474, 109, 23);
		contentPane.add(rdoTakeOut);
		buttonGroup_1.add(rdoDelivery);
		
		//JRadioButton rdoDelivery = new JRadioButton("For Delivery");
		rdoDelivery.setBounds(20, 506, 109, 23);
		contentPane.add(rdoDelivery);
		
		
		lblQuantity.setBounds(10, 568, 257, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblQuantity2 = new JLabel("1");
		lblQuantity2.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity2.setVerticalAlignment(SwingConstants.TOP);
		lblQuantity2.setBounds(104, 615, 46, 14);
		contentPane.add(lblQuantity2);
		
		JButton btnNewButton_3 = new JButton("Bill Out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOrderDetails();
			}
		});
		btnNewButton_3.setBounds(67, 721, 89, 23);
		contentPane.add(btnNewButton_3);
		
		//JButton btnNewButton_4 = new JButton("Order Again");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderAgain();
			}
		});
		btnNewButton_4.setBounds(67, 769, 119, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img6 = new ImageIcon(this.getClass().getResource("/g2.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img6));
		lblNewLabel_6.setBounds(313, 21, 271, 225);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/g3.jpg")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon(img7));
		lblNewLabel_8.setBounds(629, 57, 213, 159);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Order Details :");
		lblNewLabel_9.setBounds(360, 278, 125, 14);
		contentPane.add(lblNewLabel_9);
		
		//textFieldOrderDetails = new JTextField();
		textFieldOrderDetails.setBounds(344, 303, 553, 441);
		contentPane.add(textFieldOrderDetails);
		textFieldOrderDetails.setColumns(10);
		
		//JLabel lblSmallPrice = new JLabel("");
		lblSmallPrice.setBounds(182, 138, 46, 14);
		contentPane.add(lblSmallPrice);
		
		//JLabel lblMediumPrice = new JLabel("");
		lblMediumPrice.setBounds(182, 181, 46, 14);
		contentPane.add(lblMediumPrice);
		
		//JLabel lblLargeSize = new JLabel("");
		lblLargePrice.setBounds(182, 227, 46, 14);
		contentPane.add(lblLargePrice);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qty++;
				lblQuantity2.setText(String.valueOf(qty));
			}
		});
		
		//JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBounds(166, 611, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qty--;
				lblQuantity2.setText(String.valueOf(qty));
			}
		});
		
		//JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBounds(5, 611, 89, 23);
		contentPane.add(btnNewButton_2);
	}
	
	
	private void loadFlavours() {
		for(String flavours : flavour) {
			cboFlavour.addItem(flavours);
		}
	}
	
	
	private void showPrices() {
		if(cboFlavour.getSelectedIndex() == 0 ) {
			lblSmallPrice.setText("100.00");
			lblMediumPrice.setText("120.00");
			lblLargePrice.setText("140.00");
		}
		else if(cboFlavour.getSelectedIndex() == 1 ) {
			lblSmallPrice.setText("130.00");
			lblMediumPrice.setText("150.00");
			lblLargePrice.setText("170.00");
		}
		else if(cboFlavour.getSelectedIndex() == 2 ) {
			lblSmallPrice.setText("90.00");
			lblMediumPrice.setText("110.00");
			lblLargePrice.setText("140.00");
		}
		else if(cboFlavour.getSelectedIndex() == 3 ) {
			lblSmallPrice.setText("100.00");
			lblMediumPrice.setText("120.00");
			lblLargePrice.setText("140.00");
		}
		else if(cboFlavour.getSelectedIndex() == 4 ) {
			lblSmallPrice.setText("120.00");
			lblMediumPrice.setText("140.00");
			lblLargePrice.setText("160.00");
		}
	}
	
	private String addOnPrice() {
		String addOns = "";
		
		if(chkExtraCheese.isSelected()) {
			//addOnPrice += 10.00;
			addOns = addOns +"\n\t" + chkExtraCheese.getText() + " " + "10.00";
		}
		if(chkExtraMeat.isSelected()) {
			//addOnPrice += 15.00;
			addOns = addOns +"\n\t" + chkExtraMeat.getText() + " " + "15.00";
		}
		if(chkMushroom.isSelected()) {
			//addOnPrice += 7.00;
			addOns = addOns +"\n\t" + chkMushroom.getText() + " " + "7.00";
		}
		if(chkBlackOlives.isSelected()) {
			//addOnPrice += 8.00;
			addOns = addOns +"\n\t" + chkBlackOlives.getText() + " " + "8.00";
		}
		if(chkOnions.isSelected()) {
			//addOnPrice += 5.00;
			addOns = addOns +"\n\t" + chkOnions.getText() + " " + "5.00";
		}
		if(chkSausage.isSelected()) {
			//addOnPrice += 10.00;
			addOns = addOns +"\n\t" + chkSausage.getText() + " " + "10.00";
		}
		
		return addOns;
	}
	
	private double addOnPrice2() {
		double addOnPrice=0;
		
		if(chkExtraCheese.isSelected()) {
			addOnPrice += 10.00;}
		if(chkExtraMeat.isSelected()) {
			addOnPrice += 15.00;
		}
		if(chkMushroom.isSelected()) {
			addOnPrice += 7.00;
		}
		if(chkBlackOlives.isSelected()) {
			addOnPrice += 8.00;
		}
		if(chkOnions.isSelected()) {
			addOnPrice += 5.00;
		}
		if(chkSausage.isSelected()) {
			addOnPrice += 10.00;
		}
		
		return addOnPrice;
	}
	
	private String sizeOfPizza() {
		String size="";
		if(rdoSmall.isSelected()) {
			size = rdoSmall.getText();
		}
		if(rdoMedium.isSelected()) {
			size = rdoMedium.getText();
		}
		if(rdoLarge.isSelected()) {
			size = rdoLarge.getText();
		}
		return size;
	}
	
	private double priceOfPizza() {
		double price = 0;
		
		if(rdoSmall.isSelected()) {
			price = Double.parseDouble(lblSmallPrice.getText());
		}
		if(rdoMedium.isSelected()) {
			price = Double.parseDouble(lblMediumPrice.getText());
		}
		if(rdoLarge.isSelected()) {
			price = Double.parseDouble(lblLargePrice.getText());
		}
		
		return price;
	}
	
	private String serviceMethod() {
		String service = "";
		
		if(rdoDineIn.isSelected()) {
			service = "DINE IN";
		}
		if(rdoTakeOut.isSelected()) {
			service = "TAKE OUT";
		}
		if(rdoDelivery.isSelected()) {
			service = "FOR DELIVERY  : extra cost 50";
		}
		
		return service;
	}
	
	private double serviceFee() {
		double serviceFee=0;
		
		if(rdoDelivery.isSelected()) {serviceFee = 50;}
		
		return serviceFee;
	}
	
	private void orderAgain() {
		textFieldOrderDetails.setText(null);
	}
	
	private double subTotal() {
		double subTotal = addOnPrice2() + priceOfPizza();
		return subTotal;
	}
	
	private void showOrderDetails() {
		//int quantity = Integer.parseInt(lblQuantity2.getText());
		double total = (subTotal() * qty) + serviceFee() ;
		
		String flavour = "FLAVOUR : "+ "\t " +cboFlavour.getSelectedItem();
		String size = "SIZE : " + "\t " +sizeOfPizza();
		String price = "PRICE : "+ "\t " +priceOfPizza();
		String addOns = "ADD ONS  : " + "\t " +addOnPrice();
		String delivery ="SERVICE : "+ "\t"  +serviceMethod();
		String quantity2 = "\n\nQUANTITY : " +"\t\t\tx"+ qty;
		String row = "\n\n************************************************************************";
		textFieldOrderDetails.setText("\n"+flavour+ "\n\n" + size + "\n\n" + price + "\n\n" + addOns +"\n\n"+delivery +quantity2+row+"\n\nTOTAL : " +"\t"+ total);
	}
}

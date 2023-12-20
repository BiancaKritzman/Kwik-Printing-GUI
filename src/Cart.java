import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;


public class Cart extends JFrame {

	private JPanel contentPane;
	private JTable table; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
					frame.setVisible(true);
					frame.setSize(900,630);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//ListSelectionEvent evt;
	 
	public Cart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientHomePage frame = new ClientHomePage();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(0, 0, 94, 35);
		contentPane.add(btnBack);
		
		JLabel lblCart = new JLabel("Cart Page");
		lblCart.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCart.setBounds(365, 11, 228, 47);
		contentPane.add(lblCart);
		
		JScrollPane Jtable = new JScrollPane(table);
		Jtable.setEnabled(false);
		Jtable.setBounds(24, 91, 778, 433);
		contentPane.add(Jtable);
		
		table = new JTable();
		Jtable.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 21));
		table.editingCanceled(null);
		CartManager cm = new CartManager();
		
		String column[] = {"Type", "Quantity", "Number of Orders", "Price"};
		String[][] data = cm.salesDataforTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setDataVector(data, column);
		model.setColumnCount(4);
		model.setNumRows(cm.getNoCart());
		
		table.setDefaultEditor(Object.class, null);
		getContentPane().add(Jtable, BorderLayout.CENTER);
		
		table.setRowHeight(23);
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		table.getColumnModel().getColumn(0).setMinWidth(18);
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(113);
		table.getColumnModel().getColumn(2).setMinWidth(36);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(3).setMaxWidth(200);
		
		
		JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(672, -35, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
		  
		  
		  JButton btnPurchase = new JButton("Purchase");
		  btnPurchase.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	      
		  		//if(!evt.getValueIsAdjusting() && table.getSelectedRow() != -1) {
		        	
		  			//btnPurchase.setEnabled(true);
		  			JOptionPane.showMessageDialog(null, "Your order will be ready in 70 minutes");
		  			
		  			int trackOrder = JOptionPane.showConfirmDialog(null, "Do you want to track your order?", "Order Tracking", JOptionPane.YES_NO_OPTION);
			        if (trackOrder == JOptionPane.YES_OPTION) {
			        	
			        	CartManager cm = new CartManager();
			        	cm.ClearArray();
			        	
			        	
			        	Map frame;
						try {
							frame = new Map();
							frame.setVisible(true);
				        	
				        	dispose();
				        	
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        	
			        }
			        
			        else {
			        	
			        	CartManager c = new CartManager();
			        	c.ClearArray();
			        	
			        	ClientHomePage frame1 = new ClientHomePage();
			        	frame1.setVisible(true);
			        	
			        	
			        	dispose();
			        }
		  		//}
		  		
		  		/*else {
		  			
		        	btnPurchase.setEnabled(false);

		  		}*/
		        
		  	}
		  });
		  btnPurchase.setFont(new Font("Tahoma", Font.PLAIN, 22));
		  btnPurchase.setBounds(675, 566, 127, 23);
		  contentPane.add(btnPurchase);
		  
		  JLabel lblTotalPrice = new JLabel("Total Price:");
		  lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 22));
		  lblTotalPrice.setBounds(577, 535, 150, 29);
		  contentPane.add(lblTotalPrice);
		  
		  double totalPrice = cm.calcTotalPrice();
		  JLabel lblAutomatedPrice = new JLabel("R" + totalPrice);
		  lblAutomatedPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		  lblAutomatedPrice.setBounds(737, 533, 142, 35);
		  contentPane.add(lblAutomatedPrice);
	     
		 
		  }
}

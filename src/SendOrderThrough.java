import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class SendOrderThrough extends JFrame {

	private JPanel contentPane;
	private JLabel lblProformaInvoiceNum;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendOrderThrough frame = new SendOrderThrough();
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
	public SendOrderThrough() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblKwik = new JLabel("Kwik Printing Kwik Service");
		lblKwik.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblKwik.setBounds(328, 69, 348, 50);
		contentPane.add(lblKwik);
		
		JLabel lblWantJobToGo = new JLabel("Would you like to go though with your print job?");
		lblWantJobToGo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWantJobToGo.setBounds(93, 204, 469, 50);
		contentPane.add(lblWantJobToGo);
		
		CartClass c = QuoteInfo.C;
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CartManager cm = new CartManager();

				c.saveOrder();
				
				Cart frame = new Cart();
				frame.setVisible(true);
				
				dispose();
			          
			      }
		});
	
		btnYes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnYes.setBounds(225, 265, 89, 35);
		contentPane.add(btnYes);
		
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientHomePage frame = new ClientHomePage();
				frame.setVisible(true);
				
				dispose();
		 
			}
		});
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNo.setBounds(339, 265, 89, 35);
		contentPane.add(btnNo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QuoteInfo frame = new QuoteInfo();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(0, 0, 94, 35);
		contentPane.add(btnBack);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrice.setBounds(85, 135, 58, 35);
		contentPane.add(lblPrice);
		
		JLabel lblInk = new JLabel("");
		  lblInk.setBounds(415, 261, 365, 335);
		  Image img2 = new ImageIcon(this.getClass().
		    getResource("/splash of paint for kwik app.png")).
		    getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		  lblInk.setIcon(new ImageIcon(img2));
		  contentPane.add(lblInk);
		  
		  JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(686, -32, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
		  
		  double price = c.getPrice();
		  
		  JLabel lblAutomatedPrice = new JLabel("R" + price);
		  lblAutomatedPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		  lblAutomatedPrice.setBounds(153, 135, 142, 35);
		  contentPane.add(lblAutomatedPrice);
		  
		  
	}
	}



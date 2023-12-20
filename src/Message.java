import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Message extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Message frame = new Message();
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
	public Message() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerService = new JLabel("Customer Service");
		lblCustomerService.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCustomerService.setBounds(336, 91, 179, 62);
		contentPane.add(lblCustomerService);
		
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
		
		JLabel lblNumber = new JLabel("Email Address: darren@kwikprinting.co.za");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNumber.setBounds(45, 277, 420, 41);
		contentPane.add(lblNumber);
		
		JLabel lbl = new JLabel("Tel: 011 610 2240");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl.setBounds(45, 193, 305, 41);
		contentPane.add(lbl);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Help frame = new Help();
				frame.setVisible(true);
				frame.prevPage = 3;
				
				dispose();
			}
		});
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnHelp.setBounds(795, 0, 94, 35);
		contentPane.add(btnHelp);
		
		JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(326, -24, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
		  
		  JLabel lblInk = new JLabel("");
		  lblInk.setBounds(475, 261, 365, 335);
		  Image img2 = new ImageIcon(this.getClass().
		    getResource("/splash of paint for kwik app.png")).
		    getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		  lblInk.setIcon(new ImageIcon(img2));
		  contentPane.add(lblInk);
		  
		  JLabel lblQR = new JLabel("");
		  lblQR.setBounds(215, 328, 200, 182);
		  Image img3 = new ImageIcon(this.getClass().
		    getResource("/QR code for Kwik Printing app.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblQR.setIcon(new ImageIcon(img3));
		  contentPane.add(lblQR);
	}
}

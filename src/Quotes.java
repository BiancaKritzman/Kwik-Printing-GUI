import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class Quotes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quotes frame = new Quotes();
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
	public Quotes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFlyer = new JLabel("");
		lblFlyer.setBounds(105, 57, 138, 150);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Flyers Image For IT phase 2.png")).
		    getImage().getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		  lblFlyer.setIcon(new ImageIcon(img));
		  contentPane.add(lblFlyer);
		
		JLabel lblBC = new JLabel("");
		lblBC.setBounds(366, 60, 254, 147);
		Image img2 = new ImageIcon(this.getClass().
			    getResource("/Business Cards Images For IT phase 2.png")).
			    getImage().getScaledInstance(230, 140, Image.SCALE_SMOOTH);
			  lblBC.setIcon(new ImageIcon(img2));
		      contentPane.add(lblBC);
		
		JLabel lblPoster = new JLabel("");
		lblPoster.setBounds(695, 26, 158, 181);
		Image img3 = new ImageIcon(this.getClass().
			    getResource("/Poster Image For IT phase 2.png")).
			    getImage().getScaledInstance(160, 180, Image.SCALE_SMOOTH);
			  lblPoster.setIcon(new ImageIcon(img3));
			  contentPane.add(lblPoster);
		
		JButton btnBC = new JButton("Business Cards ");
		btnBC.setBounds(383, 222, 185, 37);
		btnBC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuoteInfo frame = new QuoteInfo();
				frame.type = "Business Cards";
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnBC.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnBC);
		
		JButton btnFlyers = new JButton("Flyers");
		btnFlyers.setBounds(121, 222, 91, 37);
		btnFlyers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//whatever type ie flyers they choose saves in the text file and will be displaced on the cart page
				QuoteInfo frame = new QuoteInfo();
				frame.type = "Flyers";
				frame.setVisible(true);
				
				dispose();
				
				
			}
		});
		btnFlyers.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnFlyers);
		
		JButton btnPosters = new JButton("Posters");
		btnPosters.setBounds(726, 222, 105, 37);
		btnPosters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuoteInfo frame = new QuoteInfo();
				frame.type = "Posters";
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnPosters.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnPosters);
		
		JLabel lblCalenders = new JLabel("");
		lblCalenders.setBounds(33, 319, 173, 169);
		Image img4 = new ImageIcon(this.getClass().
			    getResource("/Calander Image For IT phase 2.jpg")).
			    getImage().getScaledInstance(190, 170, Image.SCALE_SMOOTH);
			  lblCalenders.setIcon(new ImageIcon(img4));
		      contentPane.add(lblCalenders);
		
		JLabel lblFolder = new JLabel("");
		lblFolder.setBounds(267, 319, 202, 169);
		Image img5 = new ImageIcon(this.getClass().
			    getResource("/Folders Image For IT phase 2.png")).
			    getImage().getScaledInstance(190, 170, Image.SCALE_SMOOTH);
			  lblFolder.setIcon(new ImageIcon(img5));
		      contentPane.add(lblFolder);
		
		JLabel lblInvoiceBooks = new JLabel("");
		lblInvoiceBooks.setBounds(514, 319, 202, 169);
		Image img6 = new ImageIcon(this.getClass().
			    getResource("/Invoice Books Image For IT phase 2.jfif")).
			    getImage().getScaledInstance(170, 180, Image.SCALE_SMOOTH);
			  lblInvoiceBooks.setIcon(new ImageIcon(img6));
		      contentPane.add(lblInvoiceBooks);
		
		JLabel lblPads = new JLabel("");
		lblPads.setBounds(728, 319, 161, 169);
		Image img7 = new ImageIcon(this.getClass().
			    getResource("/Pads Images For IT phase 2.jfif")).
			    getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH);
			  lblPads.setIcon(new ImageIcon(img7));
		      contentPane.add(lblPads);
		
		JButton btnFolders = new JButton("Folders");
		btnFolders.setBounds(303, 509, 116, 37);
		btnFolders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuoteInfo frame = new QuoteInfo();
				frame.type = "Folders";
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnFolders.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnFolders);
		
		JButton btnPads = new JButton("Pads");
		btnPads.setBounds(774, 509, 79, 37);
		btnPads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuoteInfo frame = new QuoteInfo();
				frame.type = "Pads";
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnPads.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnPads);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 12, 79, 37);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientHomePage frame = new ClientHomePage();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnBack.setBackground(new Color(173, 216, 230));
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnBack);
		
		JButton btnCalenders = new JButton("Calenders");
		btnCalenders.setBounds(59, 509, 129, 37);
		btnCalenders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuoteInfo frame = new QuoteInfo();
				frame.type = "Calenders";
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnCalenders.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnCalenders);
		
		JButton btnInvoiceBooks = new JButton("Invoice Books");
		btnInvoiceBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuoteInfo frame = new QuoteInfo();
				frame.type = "Invoice Books";
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnInvoiceBooks.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnInvoiceBooks.setBounds(505, 509, 190, 37);
		contentPane.add(btnInvoiceBooks);
		
		//all into about the order saved to the order txt file
	}
}

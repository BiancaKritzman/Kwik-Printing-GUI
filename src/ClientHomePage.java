import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class ClientHomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientHomePage frame = new ClientHomePage();
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
	public ClientHomePage() {
		setBackground(new Color(255, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQuote = new JButton("Quote");
		btnQuote.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnQuote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Quotes frame = new Quotes();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnQuote.setBounds(109, 549, 114, 36);
		contentPane.add(btnQuote);
		
		JButton btnMessage = new JButton("Message");
		btnMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Message frame = new Message();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnMessage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnMessage.setBounds(366, 549, 145, 36);
		contentPane.add(btnMessage);
		
		/*JButton btnMap = new JButton("Map");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//The user can only access the Map Page once they have purchased their order
				
				JOptionPane.showMessageDialog(null, "You can only access this page once you have purchased an order" + "\n" + "as this is where you track your order");
				
			}
		});
		btnMap.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnMap.setBounds(474, 549, 114, 36);
		contentPane.add(btnMap);*/
		
		JButton btnSpecials = new JButton("Specials");
		btnSpecials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Specials frame = new Specials();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnSpecials.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSpecials.setBounds(652, 549, 114, 36);
		contentPane.add(btnSpecials);
		
		JButton btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart frame = new Cart();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnCart.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCart.setBounds(766, 21, 97, 36);
		contentPane.add(btnCart);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if come from Sign Up Page return to that page but info will be removed already but saved in the txt file
				//if from Login Page return to Sign Up Page as already logged in and info saved
				
				SignUpPage frame = new SignUpPage();
				frame.setVisible(true);
				
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(0, 0, 97, 36);
		contentPane.add(btnBack);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Help frame = new Help();
				frame.setVisible(true);
				frame.prevPage = 1;
				
				dispose();
			}
		});
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnHelp.setBounds(667, 21, 89, 36);
		contentPane.add(btnHelp);
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHomePage.setBounds(354, 93, 176, 73);
		contentPane.add(lblHomePage);
		
		 JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(688, 34, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
		  
		  JLabel lblInk = new JLabel("");
		  lblInk.setBounds(264, 177, 365, 335);
		  Image img2 = new ImageIcon(this.getClass().
		    getResource("/Easy DIY Alcohol Ink Art Tutorial - Dans le Lakehouse.jpg")).
		    getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		  lblInk.setIcon(new ImageIcon(img2));
		  contentPane.add(lblInk);
	}
}

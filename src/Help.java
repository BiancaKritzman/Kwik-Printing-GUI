import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
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
	
	int prevPage;
	
	public Help() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelp = new JLabel("Help Page");
		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHelp.setBounds(379, 11, 162, 71);
		contentPane.add(lblHelp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(prevPage == 1) {
					ClientHomePage frame = new ClientHomePage();
					frame.setVisible(true);
					
					dispose();
				}
				
				else if(prevPage == 2) {
					
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					
					dispose();

				}
				
				else if(prevPage == 3) {
					
					Message frame = new Message();
					frame.setVisible(true);
					
					dispose();

				}
				
				else if(prevPage == 4) {
					
					SignUpPage frame = new SignUpPage();
					frame.setVisible(true);

					dispose();

				}
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(0, 0, 94, 35);
		contentPane.add(btnBack);
		
		JButton btnSignUp = new JButton("How to Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "How to Sign Up: \r" + "\n"
						+ "\r"
						+ "					First fill in your name on the Sign Up Page" + "\n"
						+ "					Then your email" + "\n"
						+ "					Then your password" + "\n"
						+ "					And then press the Sign Up Button");
				
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSignUp.setBounds(28, 196, 212, 48);
		contentPane.add(btnSignUp);
		
		//only button that will work if coming from Sign Up Page and Welcome Page
		
		
		JButton btnContact = new JButton("Who to contact");
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Who to contact: \r" + "\n"
						+ "You can contact the owners of the company through their telephone number on the Message Page\r" + "\n"
						+ "Or by going to their website by scaning the QR on the Message Page\r" + "\n"
						+ "Get to the Message Page by going to the Home Page and pressing the message button");
				
			}
		});
		btnContact.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnContact.setBounds(368, 196, 212, 48);
		contentPane.add(btnContact);
		
		JButton btnQuote = new JButton("How to make a quote");
		btnQuote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "How to make a quote: \r " + "\n"
						+ "Press the Quote button on the Home Page\r" + "\n"
						+ "Fill in the custom order questionaire\r" + "\n"
						+ "Press Submit and confirm the order\r" + "\n"
						+ "Then your order will be added to the Cart");
			}
		});
		btnQuote.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnQuote.setBounds(28, 363, 259, 48);
		contentPane.add(btnQuote);
		
		JButton btnTrack = new JButton("How to track order");
		btnTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "How to track your order: \r"  + "\n"
						+ "Track your order by purchasing a order and saying yes on the pop up message to track your order\r" + "\n"
						+ "Here you will see the process your order has to go through and that it will take 70 mins\r" + "\n"
						+ "You can only track your order if you have placed an order");
				
			}
		});
		btnTrack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnTrack.setBounds(379, 363, 240, 48);
		contentPane.add(btnTrack);
		
		JButton btnSpecials = new JButton("Where to see specials");
		btnSpecials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Where to see the specials the company offers: \r"  + "\n"
						+ "Go to the Home Page and press the Specials button\r"  + "\n"
						+ "This will take you to a page full of specials which you can add to your Cart");
			}
		});
		btnSpecials.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSpecials.setBounds(28, 513, 259, 48);
		contentPane.add(btnSpecials);
		
		JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(688, -27, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
		  
		  //some buttons mustn't work if coming from login, welcome or sign up page
	}
}

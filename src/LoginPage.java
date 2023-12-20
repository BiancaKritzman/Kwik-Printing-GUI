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

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSlogan = new JLabel("Do It Once, Do It Right");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSlogan.setBounds(315, 95, 263, 74);
		contentPane.add(lblSlogan);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblName.setBounds(200, 266, 108, 33);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(315, 266, 201, 33);
		contentPane.add(tfName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEmail.setBounds(200, 333, 108, 33);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(315, 333, 201, 33);
		contentPane.add(tfEmail);
		
		JLabel lblUserNotFound = new JLabel("User not found");
		lblUserNotFound.setForeground(Color.RED);
		lblUserNotFound.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserNotFound.setBounds(434, 449, 121, 29);
		contentPane.add(lblUserNotFound);
		lblUserNotFound.setVisible(false);
		
		JLabel lblUserError = new JLabel("Enter Name");
		  lblUserError.setForeground(Color.RED);
		  lblUserError.setBackground(Color.WHITE);
		  lblUserError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblUserError.setBounds(537, 271, 206, 28);
		  contentPane.add(lblUserError);
		  lblUserError.setVisible(false);
		  
		  JLabel lblPasswordError = new JLabel("Enter Password");
		  lblPasswordError.setForeground(Color.RED);
		  lblPasswordError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblPasswordError.setBounds(740, 392, 139, 24);
		  contentPane.add(lblPasswordError);
		  lblPasswordError.setVisible(false);
			
		   JLabel lblEmailError = new JLabel("Enter Email Address");
		   lblEmailError.setForeground(Color.RED);
		   lblEmailError.setBackground(Color.RED);
		   lblEmailError.setFont(new Font("Tahoma", Font.PLAIN, 15));
	       lblEmailError.setBounds(537, 345, 170, 14);
		   contentPane.add(lblEmailError);
	   	   lblEmailError.setVisible(false);
	   	   
	   	JLabel lblValidEmailError = new JLabel("Please enter valid email address with a '@'");
		lblValidEmailError.setForeground(Color.RED);
		lblValidEmailError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValidEmailError.setBounds(530, 295, 294, 24);
		contentPane.add(lblValidEmailError);
		lblValidEmailError.setVisible(false);
			  
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("Click this button to login to the application");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = tfName.getText();
				String email = tfEmail.getText();
				String password = passwordField.getText();
				
				
				if(name.equals("")) {
					
					lblUserError.setVisible(true);
					
				}
				
				 else if (!name.equals("")) {
	             	
					 lblUserError.setVisible(false);
	             }
				
				if(email.equals("")) {
					
					lblEmailError.setVisible(true);
				}
				
				else if (!email.equals("")) {
	             	
					 lblEmailError.setVisible(false);
	            }
				
				if(!email.contains("@")) {
					
					lblValidEmailError.setVisible(true);
					
				}
				else if(email.contains("@")) {
					
					lblValidEmailError.setVisible(false);
				}
				
				if(email.equals("") && !email.contains("@")) {
					
					lblUserError.setVisible(true);
					lblValidEmailError.setVisible(false);
				}
				
				if(password.equals("")) {
					
					lblPasswordError.setVisible(true);
				}
				
				else if (!password.equals("")) {
	             	
					 lblPasswordError.setVisible(false);
	            }
				
				boolean enterName = lblUserError.isVisible();
	            boolean enterEmail = lblEmailError.isVisible();
	            boolean enterPassword = lblPasswordError.isVisible();
	            boolean validEmail = lblValidEmailError.isVisible();
	            
				if(enterName == false && enterEmail == false && enterPassword == false && validEmail == false) {
					
					
					EndUserManager em = new EndUserManager();
					
					if(em.userExists(name, email, password)) {
						
						ClientHomePage frame = new ClientHomePage();
						frame.setVisible(true);
						
						dispose();
					}
					
					else {
						lblUserNotFound.setVisible(true);
					}
				}
				
			}
				
			});
		
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLogin.setBounds(427, 473, 128, 43);
		contentPane.add(btnLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(189, 388, 108, 27);
		contentPane.add(lblPassword);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Help frame = new Help();
				frame.setVisible(true);
				frame.prevPage = 2;
				dispose();
			}
		
		});
		
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnHelp.setBounds(800, 0, 89, 36);
		contentPane.add(btnHelp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome frame = new Welcome();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(0, 0, 97, 36);
		contentPane.add(btnBack);
		
		 JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(327, -12, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
		  
		  passwordField = new JPasswordField();
		  passwordField.setBounds(315, 390, 201, 33);
		  contentPane.add(passwordField);
		  
		  JToggleButton tglbtnCheckPassword = new JToggleButton("Show Password");
		  tglbtnCheckPassword.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent e) {
		  		
		  		if (tglbtnCheckPassword.isSelected()) {
		            passwordField.setEchoChar((char)0);
		            tglbtnCheckPassword.setText("Hide Password");
		        } else {
		            passwordField.setEchoChar('*');
		            tglbtnCheckPassword.setText("Show Password");
		  		
		  	}
		  	}
		  });
		  tglbtnCheckPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		  tglbtnCheckPassword.setBounds(528, 390, 190, 33);
		  contentPane.add(tglbtnCheckPassword);
	}
			
}

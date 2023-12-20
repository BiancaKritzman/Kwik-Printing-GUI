import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
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
	public SignUpPage() {
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
		lblSlogan.setBounds(342, 148, 263, 74);
		contentPane.add(lblSlogan);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblName.setBounds(212, 244, 108, 33);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(330, 244, 190, 33);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEmail.setBounds(212, 288, 108, 33);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(330, 288, 190, 33);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblUserError = new JLabel("Enter Name");
		  lblUserError.setForeground(Color.RED);
		  lblUserError.setBackground(Color.WHITE);
		  lblUserError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblUserError.setBounds(530, 249, 206, 28);
		  contentPane.add(lblUserError);
		  lblUserError.setVisible(false);
		  
		  JLabel lblPasswordError = new JLabel("Enter Password");
		  lblPasswordError.setForeground(Color.RED);
		  lblPasswordError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblPasswordError.setBounds(730, 341, 139, 24);
		  contentPane.add(lblPasswordError);
		  lblPasswordError.setVisible(false);
			
			JLabel lblEmailError = new JLabel("Enter Email Address");
			  lblEmailError.setForeground(Color.RED);
			  lblEmailError.setBackground(Color.RED);
			  lblEmailError.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  lblEmailError.setBounds(533, 300, 170, 14);
			  contentPane.add(lblEmailError);
			  lblEmailError.setVisible(false);
			  
			    JLabel lblNoRadioButtonSelected = new JLabel("Please select a checkbox button");
				lblNoRadioButtonSelected.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNoRadioButtonSelected.setForeground(Color.RED);
				lblNoRadioButtonSelected.setBounds(640, 432, 229, 19);
				contentPane.add(lblNoRadioButtonSelected);
				lblNoRadioButtonSelected.setVisible(false);
				
				JLabel lblRadioButtonTooManySelected = new JLabel("Please only select 1 checkbox button");
				lblRadioButtonTooManySelected.setForeground(Color.RED);
				lblRadioButtonTooManySelected.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblRadioButtonTooManySelected.setBounds(617, 432, 252, 19);
				contentPane.add(lblRadioButtonTooManySelected);
				lblRadioButtonTooManySelected.setVisible(false);
				
				JLabel lblValidEmailError = new JLabel("Please enter valid email address with a '@'");
				lblValidEmailError.setForeground(Color.RED);
				lblValidEmailError.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblValidEmailError.setBounds(530, 295, 294, 24);
				contentPane.add(lblValidEmailError);
				lblValidEmailError.setVisible(false);
				  
				  JCheckBox chckbxEndUser = new JCheckBox("End User");
					chckbxEndUser.setFont(new Font("Tahoma", Font.PLAIN, 22));
					chckbxEndUser.setBounds(313, 422, 119, 33);
					contentPane.add(chckbxEndUser);
					
					JCheckBox chckbxReseller = new JCheckBox("Reseller");
					chckbxReseller.setFont(new Font("Tahoma", Font.PLAIN, 22));
					chckbxReseller.setBounds(486, 422, 119, 33);
					contentPane.add(chckbxReseller);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setToolTipText("Click to Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//getting user input 
			String name = tfName.getText();
			String email = tfEmail.getText();
			String password = passwordField.getText();
			char type = 'a';
			
			if(chckbxEndUser.isSelected()) {
				type = EndUser.ENDUSER;
			}
			
			if(chckbxReseller.isSelected()) {
				
				type = EndUser.RESELLER;
			}
			
			//Presence check
			if(name.equals("")) {
				
				lblUserError.setVisible(true);
				
			}
			
			 else if (!name.equals("")) {
             	
				 lblUserError.setVisible(false);
             }
			
			if(email.equals("")) {
				lblEmailError.setVisible(true);
				
			}
			
			else if(!email.equals("")) {
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
			
			 int count = 0;
	        	
	        	if (chckbxReseller.isSelected()) {
		            count++;
		        }
	        	
	        	if (chckbxEndUser.isSelected()) {
			            count++;
			        
	        	}
	        	
	        if (count > 1) {
			        	
			    lblRadioButtonTooManySelected.setVisible(true);
			    
			     }
	        
	        else if (count == 1){
	        	
	        	lblRadioButtonTooManySelected.setVisible(false);
	        }
	        
	        else if(chckbxEndUser.isSelected() || chckbxReseller.isSelected()) {
	        	lblNoRadioButtonSelected.setVisible(false);
	        }
	        
	        if(chckbxEndUser.isSelected() && chckbxReseller.isSelected()) {
	        	
	        	lblNoRadioButtonSelected.setVisible(false);
	    		lblRadioButtonTooManySelected.setVisible(true);

	        }
	       
	       else if(!chckbxEndUser.isSelected() && !chckbxReseller.isSelected()){
	        	
	        	lblNoRadioButtonSelected.setVisible(true);
	        }
	       
	       else if(chckbxEndUser.isSelected() && !chckbxReseller.isSelected()){
	        	
	        	lblNoRadioButtonSelected.setVisible(false);
	        }
	       
	       else if(!chckbxEndUser.isSelected() && chckbxReseller.isSelected()){
	        	
	        	lblNoRadioButtonSelected.setVisible(false);
	        }
			
	        boolean enterName = lblUserError.isVisible();
            boolean manyRadioButtons = lblRadioButtonTooManySelected.isVisible();
            boolean noRadioButtons = lblNoRadioButtonSelected.isVisible();
            boolean enterEmail = lblEmailError.isVisible();
            boolean enterPassword = lblPasswordError.isVisible();
            boolean validEmail = lblValidEmailError.isVisible();
            
			if(enterName == false && manyRadioButtons == false && noRadioButtons == false && enterEmail == false && enterPassword == false && validEmail == false) {
				
				EndUser eu = new EndUser(name, email, password, type);
				eu.saveEndUser();
				
				JOptionPane.showMessageDialog(null, "Your data has been saved");
				
				ClientHomePage frame = new ClientHomePage();
				frame.setVisible(true);
				
				dispose();
			}
	        
			}			
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSignUp.setBounds(428, 499, 128, 43);
		contentPane.add(btnSignUp);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(199, 332, 108, 27);
		contentPane.add(lblPassword);
		
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
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Help frame = new Help();
				frame.setVisible(true);
				frame.prevPage = 4;
				
				dispose();
			}
		});
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnHelp.setBounds(800, 0, 89, 36);
		contentPane.add(btnHelp);
		
		 JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(352, 0, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
		  
		  passwordField = new JPasswordField();
		  passwordField.setBounds(330, 334, 190, 33);
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
		  tglbtnCheckPassword.setBounds(530, 334, 190, 33);
		  contentPane.add(tglbtnCheckPassword);
		  
		 
	}
}

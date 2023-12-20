import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setSize(400,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEndUser = new JButton("End User");
		btnEndUser.setToolTipText("Click if you have already logged in");
		btnEndUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginPage frame = new LoginPage();
				frame.setVisible(true);
				
				dispose();
				
				//EndUser user = new EndUser();
				//user.setType('e');
				
			}
		});
		btnEndUser.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnEndUser.setBounds(273, 311, 139, 49);
		contentPane.add(btnEndUser);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setToolTipText("Click to Sign Up as a new customer");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignUpPage frame = new SignUpPage();
				frame.setVisible(true);
				
				dispose();
			}
		});
		
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSignUp.setBounds(361, 430, 139, 49);
		contentPane.add(btnSignUp);
		
		JLabel lblSlogan = new JLabel("Do It Once Do It Right");
		lblSlogan.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSlogan.setBounds(273, 147, 408, 69);
		contentPane.add(lblSlogan);
		
		JButton btnReseller = new JButton("Reseller");
		btnReseller.setToolTipText("Click if you have already logged in");
		btnReseller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage frame = new LoginPage();
				frame.setVisible(true);
				dispose();
				
				//EndUser.setType('r');
				
			}
		});
		btnReseller.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnReseller.setBounds(452, 311, 139, 49);
		contentPane.add(btnReseller);
		
		JLabel lblPaint = new JLabel("");
		  lblPaint.setBounds(0, 296, 415, 300);
		  Image img2 = new ImageIcon(this.getClass().
		    getResource("/splash of paint for kwik app.png")).
		    getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
		  lblPaint.setIcon(new ImageIcon(img2));
		  contentPane.add(lblPaint);
		  
		  JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(663, -25, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
	}
}

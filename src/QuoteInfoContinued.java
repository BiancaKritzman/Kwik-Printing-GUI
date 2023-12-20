import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuoteInfoContinued extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuoteInfoContinued frame = new QuoteInfoContinued();
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
	public CartClass c; 
	
	public QuoteInfoContinued() {
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
				
				QuoteInfo frame = new QuoteInfo();
				frame.type = c.getType(); 
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(0, 0, 94, 35);
		contentPane.add(btnBack);
		
		JLabel lblGrammage = new JLabel("Grammage:");
		lblGrammage.setToolTipText("Thickness of the paper");
		lblGrammage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGrammage.setBounds(113, 74, 125, 27);
		contentPane.add(lblGrammage);
		
		JComboBox GrammageDropDown = new JComboBox();
		GrammageDropDown.setModel(new DefaultComboBoxModel(new String[] {"", "115", "130", "135", "150", "170", "200", "250", "300", "350"}));
		GrammageDropDown.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GrammageDropDown.setBounds(113, 112, 199, 31);
		contentPane.add(GrammageDropDown);
		
		JLabel lblFinishing = new JLabel("Finishing:");
		lblFinishing.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFinishing.setBounds(113, 204, 125, 27);
		contentPane.add(lblFinishing);
		
		JComboBox CBFinishing = new JComboBox();
		CBFinishing.setModel(new DefaultComboBoxModel(new String[] {"", "Gloss", "Matt", "Virco", "Folding"}));
		CBFinishing.setFont(new Font("Tahoma", Font.PLAIN, 22));
		CBFinishing.setBounds(114, 243, 198, 31);
		contentPane.add(CBFinishing);
		
		JCheckBox chckbxRoundedCorners = new JCheckBox("Rounded Corners");
		chckbxRoundedCorners.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxRoundedCorners.setBounds(541, 112, 198, 31);
		contentPane.add(chckbxRoundedCorners);
		
		JTextPane Description = new JTextPane();
		Description.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Description.setBounds(69, 389, 760, 134);
		contentPane.add(Description);
		
		JLabel lblDescription = new JLabel("Description of quote:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDescription.setBounds(113, 336, 250, 27);
		contentPane.add(lblDescription);
		
		JLabel lblGrammageError = new JLabel("Please enter the grammage");
		lblGrammageError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrammageError.setForeground(Color.RED);
		lblGrammageError.setBounds(327, 117, 210, 26);
		contentPane.add(lblGrammageError);
		lblGrammageError.setVisible(false);
		
		JLabel lblFinishError = new JLabel("Please enter the finishing");
		lblFinishError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFinishError.setForeground(Color.RED);
		lblFinishError.setBounds(327, 248, 210, 26);
		contentPane.add(lblFinishError);
		lblFinishError.setVisible(false);
		
		JLabel lblDescripError = new JLabel("Please enter the description");
		lblDescripError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescripError.setForeground(Color.RED);
		lblDescripError.setBounds(327, 339, 210, 26);
		contentPane.add(lblDescripError);
		lblDescripError.setVisible(false);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String grammage = GrammageDropDown.getSelectedItem().toString();
				String finish = CBFinishing.getSelectedItem().toString();
				String descrip = Description.getText();
				
				if(grammage.equals("")) {
					
					lblGrammageError.setVisible(true);
					
				}
				
				if(finish.equals("")) {
					
					lblFinishError.setVisible(true);
				}
				
				if(descrip.equals("")) {
					
					lblDescripError.setVisible(true);
				}
				
				else if(!grammage.equals("") && !finish.equals("") && !descrip.equals("")) {
					
					lblDescripError.setVisible(false);
					lblFinishError.setVisible(false); 
					lblGrammageError.setVisible(false);
					
					SendOrderThrough frame = new SendOrderThrough();
					frame.setVisible(true);
					
					dispose();
					
					
				}
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSubmit.setBounds(427, 550, 110, 35);
		contentPane.add(btnSubmit);
		
		JLabel lblInk = new JLabel("");
		  lblInk.setBounds(521, 52, 365, 335);
		  Image img2 = new ImageIcon(this.getClass().
		    getResource("/splash of paint for kwik app.png")).
		    getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		  lblInk.setIcon(new ImageIcon(img2));
		  contentPane.add(lblInk);
	}
}

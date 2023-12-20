import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Specials extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Specials frame = new Specials();
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
	public Specials() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSpecials = new JLabel("Specials");
		lblSpecials.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSpecials.setBounds(397, 22, 175, 56);
		contentPane.add(lblSpecials);
		
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
		
		JCheckBox chckbxBusniessCards = new JCheckBox("Business Cards: 500 - R300");
		chckbxBusniessCards.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxBusniessCards.setBounds(33, 85, 303, 47);
		contentPane.add(chckbxBusniessCards);
		
		JCheckBox chckbxFlyers = new JCheckBox("Flyers: 1000 A5 - R820 \r\n");
		chckbxFlyers.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxFlyers.setBounds(33, 173, 255, 56);
		contentPane.add(chckbxFlyers);
		
		JCheckBox chckbxPosters = new JCheckBox("Posters: 50 A2 - R2260  ");
		chckbxPosters.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxPosters.setBounds(33, 277, 263, 47);
		contentPane.add(chckbxPosters);
		
		JCheckBox chckbxFolders = new JCheckBox("Folders: 500 - R5040");
		chckbxFolders.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxFolders.setBounds(33, 459, 238, 47);
		contentPane.add(chckbxFolders);
		
		JCheckBox chckbxExtraRC = new JCheckBox("+ rounded corners - R400");
		chckbxExtraRC.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxExtraRC.setBounds(444, 85, 291, 48);
		contentPane.add(chckbxExtraRC);
		
		JCheckBox chckbxPoster3 = new JCheckBox("100 A3 - R1860");
		chckbxPoster3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxPoster3.setBounds(33, 341, 195, 47);
		contentPane.add(chckbxPoster3);
		
		JSpinner spinnerFlyer1 = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		spinnerFlyer1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerFlyer1.setBounds(294, 173, 42, 57);
		contentPane.add(spinnerFlyer1);
		
		JSpinner spinnerBusinessCards = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		spinnerBusinessCards.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerBusinessCards.setBounds(342, 85, 42, 47);
		contentPane.add(spinnerBusinessCards);
		
		JSpinner spinnerPoster3 = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		spinnerPoster3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerPoster3.setBounds(234, 341, 42, 47);
		contentPane.add(spinnerPoster3);
		
		JSpinner spinnerPoster1 = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		spinnerPoster1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerPoster1.setBounds(302, 277, 42, 47);
		contentPane.add(spinnerPoster1);
		
		JSpinner spinnerFolder = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		spinnerFolder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerFolder.setBounds(277, 459, 42, 47);
		contentPane.add(spinnerFolder);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxBusniessCards.isSelected()) {
					
					CartClass cart = new CartClass(1, (Integer)spinnerBusinessCards.getValue());
					if(chckbxExtraRC.isSelected()) {
						
						cart.addRoundedCorners();
					}
					cart.saveOrder();
				}
				
				if(chckbxFlyers.isSelected()) {
					
					CartClass cart = new CartClass(2, (Integer)spinnerFlyer1.getValue());
					cart.saveOrder();
				}
				
				if(chckbxPosters.isSelected()) {
					
					CartClass cart = new CartClass(3, (Integer)spinnerPoster1.getValue());
					cart.saveOrder();
				
				}
				
				if(chckbxPoster3.isSelected()) {
					
					CartClass cart = new CartClass(4, (Integer)spinnerPoster3.getValue());
					cart.saveOrder();
				}
				
				if (chckbxFolders.isSelected()) {
					
					CartClass cart = new CartClass(5, (Integer)spinnerFolder.getValue());
					cart.saveOrder();
				}
				
				Cart frame = new Cart();
				frame.setVisible(true);
				
				dispose();
				
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnDone.setBounds(444, 533, 94, 35);
		contentPane.add(btnDone);
	
		JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(679, 465, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class QuoteInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuoteInfo frame = new QuoteInfo();
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
	public String type; 
	private int numOfOrders = 1;
	
	public static CartClass C;
	
	public QuoteInfo() {

		setBackground(new Color(138, 43, 226));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox Quantity = new JComboBox();
		Quantity.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Quantity.setModel(new DefaultComboBoxModel(new String[] {"", "250", "500", "1000", "5000", "10000"}));
		Quantity.setBounds(63, 107, 198, 31);
		contentPane.add(Quantity);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quotes frame = new Quotes();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(0, 0, 94, 31);
		contentPane.add(btnBack);
		
		JComboBox Size = new JComboBox();
		Size.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Size.setModel(new DefaultComboBoxModel(new String[] {"", "A2", "A3", "A4 ", "A5 ", "A6", "A7", "DL"}));
		Size.setBounds(63, 219, 198, 31);
		contentPane.add(Size);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSize.setBounds(63, 177, 65, 31);
		contentPane.add(lblSize);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblQuantity.setBounds(63, 65, 89, 31);
		contentPane.add(lblQuantity);
		
		JComboBox InkColours = new JComboBox();
		InkColours.setFont(new Font("Tahoma", Font.PLAIN, 22));
		InkColours.setModel(new DefaultComboBoxModel(new String[] {"", "1 Spot Colour", "2 Spot Colours", "3 Spot Colours", "Full Colour"}));
		InkColours.setBounds(63, 334, 198, 31);
		contentPane.add(InkColours);
		
		JLabel lblNumberOfOrders = new JLabel("Ink Colours:");
		lblNumberOfOrders.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNumberOfOrders.setBounds(63, 303, 118, 20);
		contentPane.add(lblNumberOfOrders);
		
		JLabel lbl1Side2Sides = new JLabel("Printing area:");
		lbl1Side2Sides.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl1Side2Sides.setBounds(63, 428, 131, 31);
		contentPane.add(lbl1Side2Sides);
		
		JCheckBox chckbx1Sided = new JCheckBox("1 Sided");
		chckbx1Sided.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbx1Sided.setBounds(212, 432, 99, 23);
		contentPane.add(chckbx1Sided);
		
		JCheckBox chckbxDoubleSided = new JCheckBox("Double Sided");
		chckbxDoubleSided.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxDoubleSided.setBounds(345, 432, 153, 23);
		contentPane.add(chckbxDoubleSided);
		
		JLabel lblEnterQuantity = new JLabel("Please enter the quantity");
		lblEnterQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterQuantity.setForeground(Color.RED);
		lblEnterQuantity.setBounds(288, 112, 210, 26);
		contentPane.add(lblEnterQuantity);
		lblEnterQuantity.setVisible(false);
		
		JLabel lblEnterSize = new JLabel("Please enter the size");
		lblEnterSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterSize.setForeground(Color.RED);
		lblEnterSize.setBounds(288, 224, 210, 26);
		contentPane.add(lblEnterSize);
		lblEnterSize.setVisible(false);
		
		JLabel lblEnterInkColour = new JLabel("Please enter the ink colour");
		lblEnterInkColour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterInkColour.setForeground(Color.RED);
		lblEnterInkColour.setBounds(288, 339, 210, 26);
		contentPane.add(lblEnterInkColour);
		lblEnterInkColour.setVisible(false);
		
		JLabel lblRadioButtonTooManySelected = new JLabel("Please select one button only");
		lblRadioButtonTooManySelected.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRadioButtonTooManySelected.setForeground(Color.RED);
		lblRadioButtonTooManySelected.setBounds(252, 472, 210, 26);
		contentPane.add(lblRadioButtonTooManySelected);
		lblRadioButtonTooManySelected.setVisible(false);
		
		JLabel lblNoRadioButtonSelected = new JLabel("Please select a button");
		lblNoRadioButtonSelected.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoRadioButtonSelected.setForeground(Color.RED);
		lblNoRadioButtonSelected.setBounds(252, 472, 210, 26);
		contentPane.add(lblNoRadioButtonSelected);
		lblNoRadioButtonSelected.setVisible(false);
		
		 JLabel lblImageError = new JLabel("Select a picture from your file explorer");
		  lblImageError.setForeground(Color.RED);
		  lblImageError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblImageError.setBounds(548, 196, 290, 43);
		  contentPane.add(lblImageError);
		  lblImageError.setVisible(false);
		  Image img2 = new ImageIcon(this.getClass().
		  getResource("/splash of paint for kwik app.png")).
		  getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		  
		  JLabel lblPicture = new JLabel("");
		  lblPicture.setBounds(467, 11, 396, 143);
		  contentPane.add(lblPicture);
		  
		  JButton btnPng = new JButton("Upload artwork here");
		  btnPng.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		JFileChooser fc = new JFileChooser();
		  		fc.showOpenDialog(null);
		  		
		  		File file = new File(fc.getSelectedFile().getAbsolutePath());
		  		
		  		String temp = file.toString().toLowerCase();
		  		String extension = temp.substring(temp.lastIndexOf("."));
		  		
		  		if(!extension.equals(".jpeg") || !extension.equals(".jpg") || !extension.equals(".png") || !extension.equals(".gif") || !extension.equals(".tiff") || !extension.equals(".jif") ||  !extension.equals(".jfif") ||  !extension.equals(".psd")) {
		  			
		  			lblImageError.setVisible(true);

		  		}
		  		
		  		if(extension.equals(".jpeg") || extension.equals(".jpg") || extension.equals(".png") || extension.equals(".gif") || extension.equals(".tiff") || extension.equals(".jif") ||  extension.equals(".jfif") ||  extension.equals(".psd")) {
		  			 lblImageError.setVisible(false);
		  		}
		  		
		  		
		  		 ImageIcon img = (new ImageIcon(file.toString()));
		  		 Image image = img.getImage();
		  		 image = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		  		 img = new ImageIcon(image);
		  		 lblPicture.setIcon(img);
		  		
		  	}
		  });
		  btnPng.setFont(new Font("Tahoma", Font.PLAIN, 22));
		  btnPng.setBounds(548, 155, 238, 43);
		  contentPane.add(btnPng);
		  
		  JButton btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			  		
					String quantity = Quantity.getSelectedItem().toString();
					String size = Size.getSelectedItem().toString();
					String inkColour = InkColours.getSelectedItem().toString();
			
					 boolean isButtonPressed = true;

		                if (isButtonPressed) {
		                    // Button is pressed, continue with the action
		                   isButtonPressed = true;
		                } else {
		                    // Button is not pressed, display error message
		                	isButtonPressed = false;
		                    JOptionPane.showMessageDialog(null, "Error: Please press the Upload artwork button.");
		                      
		                }
					
					boolean checkQuantity = true;
					boolean checkSize = true;
					boolean checkInkColour = true;
					boolean checkRadioButton = true;
					
					if(quantity.equals("")) {
						
						checkQuantity = false;
						lblEnterQuantity.setVisible(true);

					}
					
					if(size.equals("")) {
						
						checkSize = false;
						lblEnterSize.setVisible(true);
					}
					
					if(inkColour.equals("")) {
						
						checkInkColour = false;
						lblEnterInkColour.setVisible(true);
					}
					
					int count = 0;
		        	
		        	if (chckbx1Sided.isSelected()) {
			            count++;
			        }
		        	
		        	if (chckbxDoubleSided.isSelected()) {
				            count++;
				        
		        	}
		        	
		        if (count > 1) {
				      
		        	checkRadioButton = false;
				    lblRadioButtonTooManySelected.setVisible(true);
				    
				     }
		        
		        if (count == 1){
		        	
		        	checkRadioButton = true;
		        	lblRadioButtonTooManySelected.setVisible(false);
		        }
		        
		        if(chckbxDoubleSided.isSelected() && chckbx1Sided.isSelected()) {
		        	
		        	checkRadioButton = false;
		        	lblNoRadioButtonSelected.setVisible(false);
		    		lblRadioButtonTooManySelected.setVisible(true);

		        }
		       
		        if(!chckbxDoubleSided.isSelected() && !chckbx1Sided.isSelected()){
		        	
		        	checkRadioButton = false;
		        	lblNoRadioButtonSelected.setVisible(true);
		        }
		       
		        if(chckbxDoubleSided.isSelected() && !chckbx1Sided.isSelected()){
		        	
		        	checkRadioButton = true;
		        	lblNoRadioButtonSelected.setVisible(false);
		        }
		       
		        if(!chckbxDoubleSided.isSelected() && chckbx1Sided.isSelected()){
		        	
		        	checkRadioButton = true;
		        	lblNoRadioButtonSelected.setVisible(false);
		        }
					
					if(checkQuantity == true && checkSize == true && checkInkColour == true && checkRadioButton == true && isButtonPressed == true) {
						
						CartClass c = new CartClass(type, quantity, numOfOrders);
						C = c;
						
						QuoteInfoContinued frame = new QuoteInfoContinued();
						frame.c = C;
						frame.setVisible(true);
						
						dispose();
						
					}
					
				}
			});
			btnNext.setFont(new Font("Verdana", Font.PLAIN, 22));
			btnNext.setBounds(457, 554, 94, 31);
			contentPane.add(btnNext);	
			
			  JLabel lblInk = new JLabel("");
			  lblInk.setBounds(514, 272, 365, 335);
			  lblInk.setIcon(new ImageIcon(img2));
			  contentPane.add(lblInk);
		
	}
}

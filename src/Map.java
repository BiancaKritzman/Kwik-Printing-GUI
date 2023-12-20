
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;


public class Map extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Map frame = new Map();
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
	 * @throws InterruptedException 
	 */ 
	
	public class ProgressThread extends Thread{

		int duration;
		JProgressBar pb;
		static Semaphore s=new Semaphore(1);
		boolean run;
		
		public ProgressThread(int duration, JPanel contentPane, boolean run) {
			this.duration=duration;
			this.pb=new JProgressBar(0,70);
			this.run=run;
			
		}
		
		public void run() {
			double index=0.0;
			try {
				s.acquire();
				contentPane.add(pb);
				pb.setStringPainted(true);
				pb.setBounds(0,50,200,70);
				pb.setString("Order in progress...");
				Map.pb=this.pb;
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(index<=duration) {//keep running until progressbar complete
				Map.pb.setValue((int)index);
				Map.pb.setVisible(true);
				index+=0.1;
				try {
					sleep(100);
					if(pb.getValue() == 70) {//when the progresbar is complete then show message
						
			            JOptionPane.showMessageDialog(null, "Your order is ready for collection");
			            break;
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			s.release();	
		}
	}
	
	static JProgressBar pb=new JProgressBar(0,100);
	public Map() throws InterruptedException {
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
				
				 int cannotReturn = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave this page." + "\n" + "If you do you will not be able to come back and see the progress of your order");
			        if (cannotReturn == JOptionPane.YES_OPTION) {
				
				ClientHomePage frame = new ClientHomePage();
				frame.setVisible(true);
				
				dispose();
			        
			}
			        
			        else if(cannotReturn == JOptionPane.NO_OPTION) {
			        	
			        	 JOptionPane.getRootFrame().dispose();
	
			        }
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBack.setBounds(0, 0, 94, 35);
		contentPane.add(btnBack);
		
		
		JLabel lblLogo = new JLabel("");
		  lblLogo.setBounds(10, 467, 227, 161);
		  Image img = new ImageIcon(this.getClass().
		    getResource("/Kwik Printing actual logo.png")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblLogo.setIcon(new ImageIcon(img));
		  contentPane.add(lblLogo);
		  
		  JLabel lblProcessed = new JLabel("");
		  lblProcessed.setBounds(485, 336, 227, 161);
		  Image img2 = new ImageIcon(this.getClass().
		    getResource("/Process.jpg")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblProcessed.setIcon(new ImageIcon(img2));
		  contentPane.add(lblProcessed);
		  
		  JLabel lblPrinted = new JLabel("");
		  lblPrinted.setBounds(206, 217, 227, 161);
		  Image img3 = new ImageIcon(this.getClass().
		    getResource("/Printed.jpg")).
		    getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		  lblPrinted.setIcon(new ImageIcon(img3));
		  contentPane.add(lblPrinted);
		  
		  JLabel lblEnroute = new JLabel("");
		  lblEnroute.setBounds(434, 27, 227, 161);
		  Image img4 = new ImageIcon(this.getClass().
		    getResource("/Enroute.jpg")).
		    getImage().getScaledInstance(190, 350, Image.SCALE_SMOOTH);
		  lblEnroute.setIcon(new ImageIcon(img4));
		  contentPane.add(lblEnroute);
		  
		  JLabel lblProcessOrder = new JLabel("Processing Order");
		  lblProcessOrder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		  lblProcessOrder.setBounds(500, 496, 169, 35);
		  contentPane.add(lblProcessOrder);
		  
		  JLabel lblPrintedOrder = new JLabel("Printed");
		  lblPrintedOrder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		  lblPrintedOrder.setBounds(272, 376, 80, 35);
		  contentPane.add(lblPrintedOrder);
		  
		  JLabel lblReady = new JLabel("Ready For Collection");
		  lblReady.setFont(new Font("Tahoma", Font.PLAIN, 22));
		  lblReady.setBounds(434, 191, 204, 35);
		  contentPane.add(lblReady);
		 
		  Map.ProgressThread thread=new Map.ProgressThread(100,contentPane,true); 
			thread.start();
			contentPane.add(pb);   
	        
		 
	}
}

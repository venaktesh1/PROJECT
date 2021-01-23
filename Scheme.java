package Mini_project;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Scheme extends Login{

	public JFrame frmGovernmentSchemePortal,frame;
	private JTable table;
	private JTextField textField;
	
	 

	public void run(){
	try {
		Scheme s = new Scheme();
		s.frmGovernmentSchemePortal.setVisible(true);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
	
	
	public Scheme(){
		
		
		frmGovernmentSchemePortal = new JFrame();
		frmGovernmentSchemePortal.setTitle(" Scheme Portal");
		frmGovernmentSchemePortal.setBounds(100, 100, 630, 580);
		frmGovernmentSchemePortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGovernmentSchemePortal.getContentPane().setLayout(null);
		
		JLabel lblSchemesAvailable = new JLabel("Schemes Available");
		lblSchemesAvailable.setBackground(Color.WHITE);
		lblSchemesAvailable.setBounds(42, 64, 277, 20);
		lblSchemesAvailable.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frmGovernmentSchemePortal.getContentPane().add(lblSchemesAvailable);
		
		JButton btnProfile = new JButton("Profile");
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    Profile pr=new Profile();
			    pr.run();
			    frmGovernmentSchemePortal.setVisible(false);
				
			}
		});
		
		btnProfile.setBounds(345, 16, 115, 29);
		frmGovernmentSchemePortal.getContentPane().add(btnProfile);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login l=new Login();
		        l.main(null);
		        JOptionPane.showMessageDialog(null, " LOGGED OUT SUCCESSFULLY !!","Message",JOptionPane.INFORMATION_MESSAGE); 
		        frmGovernmentSchemePortal.setVisible(false);
			}
		});
		btnLogOut.setBounds(478, 16, 115, 29);
		frmGovernmentSchemePortal.getContentPane().add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 119, 414, 252);
		frmGovernmentSchemePortal.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(null);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		Database db=new Database();
		db.display(table);
		
		JLabel lblEnterTheScheme = new JLabel("Enter the scheme name :");
		lblEnterTheScheme.setBounds(66, 419, 184, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblEnterTheScheme);
		
		textField = new JTextField();
		textField.setBounds(265, 416, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String s=textField.getText();
			db.register(s);
			
			}
		});
		btnRegister.setBounds(454, 415, 115, 29);
		frmGovernmentSchemePortal.getContentPane().add(btnRegister);
		
		JButton btnSchemesRegistered = new JButton("Schemes Registered");
		btnSchemesRegistered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame();
				frame.setBounds(100, 100, 669, 485);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				
				JLabel lblSchemesRegisteredBy = new JLabel("SCHEMES REGISTERED BY YOU");
				lblSchemesRegisteredBy.setHorizontalAlignment(SwingConstants.CENTER);
				lblSchemesRegisteredBy.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));
				lblSchemesRegisteredBy.setBounds(129, 52, 377, 20);
				frame.getContentPane().add(lblSchemesRegisteredBy);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(78, 119, 414, 252);
				frame.getContentPane().add(scrollPane);
				
				table = new JTable();
				table.setBorder(null);
				scrollPane.setViewportView(table);
				table.setFont(new Font("Times New Roman", Font.BOLD, 20));
				db.regdisplay(table);
			}
		});
		btnSchemesRegistered.setBounds(210, 479, 173, 29);
		frmGovernmentSchemePortal.getContentPane().add(btnSchemesRegistered);
		
		
		
	}
}

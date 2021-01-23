package Mini_project;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Profile {

	private JFrame frmGovernmentSchemePortal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
   
	public void run() {
		try {
			Profile p= new Profile();
			p.frmGovernmentSchemePortal.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
 public Profile()
 {
	    Database db=new Database();
		frmGovernmentSchemePortal = new JFrame();
		frmGovernmentSchemePortal.setTitle("Scheme Portal");
		frmGovernmentSchemePortal.setBounds(100, 100, 600, 580);
		frmGovernmentSchemePortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGovernmentSchemePortal.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(225, 155, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(87, 219, 83, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 216, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAge = new JLabel("Age ");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(119, 285, 45, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 282, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOccupation.setBounds(82, 350, 98, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblOccupation);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(225, 347, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblState.setBounds(114, 405, 55, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblState);
		
		textField_4 = new JTextField();
		textField_4.setBounds(225, 402, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnEdit.setBounds(142, 461, 115, 29);
		frmGovernmentSchemePortal.getContentPane().add(btnEdit);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmGovernmentSchemePortal.setVisible(false);
				Scheme s=new Scheme();
				s.run();
			}
			
		});
		btnHome.setBounds(448, 16, 115, 29);
		frmGovernmentSchemePortal.getContentPane().add(btnHome);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSave)
				{
				 String username=textField.getText();
				 String password= textField_1.getText();
				 int age=Integer.parseInt(textField_2.getText());
				 String occ=textField_3.getText();
				 String state=textField_4.getText();
				 if(textField.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null, "Username field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
				 }
				 else if(textField_1.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null, "Password field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
				 }
				 else if(textField_2.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null, "Age field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
				 }
				 else if(textField_3.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null, "Occupation field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
				 }
				 else if(textField_4.getText().isEmpty())
				 {
					 JOptionPane.showMessageDialog(null, "State field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
				 }
				 else
				 {
					 db.updateinfo(username, password,age,occ,state);
				 }
				 
				}			 
		   }
				
		});
		btnSave.setBounds(370, 461, 115, 29);
		frmGovernmentSchemePortal.getContentPane().add(btnSave);
		
		JLabel lblName = new JLabel(" Name ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(98, 158, 72, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblName);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		lblProfile.setBounds(245, 89, 146, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblProfile);
		
		
		 db.profcheck(textField,textField_1,textField_2,textField_3,textField_4);
		 
		 JLabel label = new JLabel(":");
		 label.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		 label.setBounds(182, 158, 26, 20);
		 frmGovernmentSchemePortal.getContentPane().add(label);
		 
		 JLabel label_1 = new JLabel(":");
		 label_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		 label_1.setBounds(185, 219, 26, 20);
		 frmGovernmentSchemePortal.getContentPane().add(label_1);
		 
		 JLabel label_2 = new JLabel(":");
		 label_2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		 label_2.setBounds(184, 285, 26, 20);
		 frmGovernmentSchemePortal.getContentPane().add(label_2);
		 
		 JLabel label_3 = new JLabel(":");
		 label_3.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		 label_3.setBounds(182, 350, 26, 20);
		 frmGovernmentSchemePortal.getContentPane().add(label_3);
		 
		 JLabel label_4 = new JLabel(":");
		 label_4.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		 label_4.setBounds(184, 405, 26, 20);
		 frmGovernmentSchemePortal.getContentPane().add(label_4);
		 
	}
}

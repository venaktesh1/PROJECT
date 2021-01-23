package Mini_project;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Signup{

	private JFrame frmGovernmentSchemePortal;
	private JTextField textField;
	private JTextField textField_2;
	//private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
		
			public void run() {
				try {
					Signup sp = new Signup();
					sp.frmGovernmentSchemePortal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public Signup() 
	{
		
		frmGovernmentSchemePortal = new JFrame();
		frmGovernmentSchemePortal.setTitle(" Scheme Portal");
		frmGovernmentSchemePortal.setBounds(100, 100, 630, 600);
		frmGovernmentSchemePortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGovernmentSchemePortal.getContentPane().setLayout(null);
		
		JLabel lblRegistration = new JLabel("REGISTRATION");
		lblRegistration.setFont(new Font("ROG Fonts", Font.BOLD, 25));
		lblRegistration.setBounds(191, 29, 274, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblRegistration);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblName.setBounds(53, 99, 69, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(158, 97, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblPassword.setBounds(31, 160, 91, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblPassword);
		
		JLabel lblAge = new JLabel("  Age :");
		lblAge.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblAge.setBounds(53, 267, 69, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 265, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOccupation = new JLabel(" Occupation :");
		lblOccupation.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblOccupation.setBounds(15, 327, 96, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblOccupation);
		
		String occupation[]= {"Student","Agriculture","Business","Other"};
		JComboBox textField_3 = new JComboBox(occupation);
		textField_3.setBounds(158, 325, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField_3);
		
		
		JLabel lblState = new JLabel("    State :");
		lblState.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblState.setBounds(31, 216, 80, 20);
		frmGovernmentSchemePortal.getContentPane().add(lblState);
		
		textField_4 = new JTextField();
		textField_4.setBounds(158, 214, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 158, 146, 26);
		frmGovernmentSchemePortal.getContentPane().add(passwordField);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				if(e.getSource()==btnSubmit)
				{
					String username=textField.getText();
					String password= passwordField.getText();
					int age=Integer.parseInt(textField_2.getText());
					String occ=textField_3.getSelectedItem().toString();
					String state=textField_4.getText();
					 if(textField.getText().isEmpty())
					 {
						 JOptionPane.showMessageDialog(null, "Username field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
					 }
					 else if(passwordField.getText().isEmpty())
					 {
						 JOptionPane.showMessageDialog(null, "Password field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
					 }
					 else if(textField_2.getText().isEmpty())
					 {
						 JOptionPane.showMessageDialog(null, "Age field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
					 }
					/* else if(textField_3.getText().isEmpty())
					 {
						 JOptionPane.showMessageDialog(null, "Occupation field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
					 }*/
					 else if(textField_4.getText().isEmpty())
					 {
						 JOptionPane.showMessageDialog(null, "State field is empty!!","Warning",JOptionPane.WARNING_MESSAGE);
					 }
					 else
					 {
					 db.insert(username, password,age,occ,state);
					 JOptionPane.showMessageDialog(null, " REGISTERED SUCCESSFULLY !!","Message",JOptionPane.INFORMATION_MESSAGE); 
					 frmGovernmentSchemePortal.setVisible(false);
					 new Login();
					 Login.main(null);
					//System.out.println("INSERTED!!!!");	
				
					 }
				}
				}
		});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		btnSubmit.setBounds(257, 422, 146, 29);
		frmGovernmentSchemePortal.getContentPane().add(btnSubmit);
	}
}


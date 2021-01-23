package Mini_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmScholarshipPortal;
	private JTextField textField;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmScholarshipPortal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScholarshipPortal = new JFrame();
		frmScholarshipPortal.setTitle("Scheme Portal");
		frmScholarshipPortal.setBounds(100, 100, 620, 430);
		frmScholarshipPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScholarshipPortal.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setBounds(153, 124, 94, 20);
		frmScholarshipPortal.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel(" Password :");
		lblNewLabel.setBounds(153, 175, 94, 20);
		frmScholarshipPortal.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(262, 121, 146, 26);
		frmScholarshipPortal.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(262, 172, 146, 26);
		frmScholarshipPortal.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Database db=new Database();
				if(e.getSource()==btnLogin)
				{
					String username=textField.getText();
					String password= passwordField.getText();
					if(db.checkLogin(username, password))
					{
						JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULL !!","Message",JOptionPane.INFORMATION_MESSAGE); 
						
						
						frmScholarshipPortal.setVisible(false);
						Scheme s=new Scheme();
						s.run();
						
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null, "Invalid Username or Password !!","ERROR",
			                JOptionPane.ERROR_MESSAGE); 
			        }
			
			}
			
		}	});
		
		btnLogin.setBounds(281, 236, 115, 29);
		frmScholarshipPortal.getContentPane().add(btnLogin);
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSignup)
				{
					frmScholarshipPortal.setVisible(false);
					Signup sp=new Signup();
					sp.run();
					
				}
			}
		});
		btnSignup.setBounds(281, 296, 115, 29);
		frmScholarshipPortal.getContentPane().add(btnSignup);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(15, 43, 568, 59);
		frmScholarshipPortal.getContentPane().add(panel);
		
		JLabel lblWelcomeToScholarship = new JLabel("WELCOME TO SCHEME PORTAL");
		lblWelcomeToScholarship.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblWelcomeToScholarship);
		
		
	}
}


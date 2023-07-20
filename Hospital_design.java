import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hospital_design {

	private JFrame frame;
	private JTextField textField_user;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospital_design window = new Hospital_design();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hospital_design() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 685, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hospital Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(98, 86, 472, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN WINDOW");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(209, 145, 203, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(115, 230, 97, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_user = new JTextField();
		textField_user.setBounds(222, 236, 175, 20);
		frame.getContentPane().add(textField_user);
		textField_user.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(115, 283, 97, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 290, 175, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnlogin = new JButton("LOGIN");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user= textField_user.getText();
				String pass = new String(passwordField.getPassword());
				
				if(user.equals("Admin") && pass.equals("admin@123")) {
					JOptionPane.showMessageDialog(btnlogin, "Login Successfull !!");
					frame.dispose();
					Home home= new Home();
					home.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(btnlogin, "Invalid Credentials !!");
					textField_user.setText("");
					passwordField.setText("");
				}
			}
		});
		btnlogin.setBackground(Color.GRAY);
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnlogin.setBounds(255, 378, 123, 33);
		frame.getContentPane().add(btnlogin);
	}
}

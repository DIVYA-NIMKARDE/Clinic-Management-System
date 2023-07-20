import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Doctor_insert extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField sp;
	private JTextField address;
	private JTextField shift;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_insert frame = new Doctor_insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	Connection conn = null;
    PreparedStatement pst = null;
	public Doctor_insert() {
		conn= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(221, 73, 225, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(60, 210, 69, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Speciality");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(44, 280, 85, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Shift");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(84, 343, 45, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone no.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(350, 210, 109, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(368, 274, 85, 32);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "insert into Doctor(Name,Address,Phone_no,Shift,Speciality) values(?,?,?,?,?);";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, name.getText());
		            pst.setString(2, address.getText());
		            pst.setString(3, phone.getText());
		            pst.setString(4, shift.getText());
		            pst.setString(5, sp.getText());
		            pst.execute();
		            JOptionPane.showMessageDialog(null, "Added successfully!");
		            dispose();
		            
		            conn.close();
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(284, 414, 85, 32);
		contentPane.add(btnNewButton);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		name.setBounds(158, 210, 117, 29);
		contentPane.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phone.setBounds(492, 213, 117, 29);
		contentPane.add(phone);
		phone.setColumns(10);
		
		sp = new JTextField();
		sp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sp.setBounds(158, 284, 117, 29);
		contentPane.add(sp);
		sp.setColumns(10);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 18));
		address.setBounds(492, 284, 117, 29);
		contentPane.add(address);
		address.setColumns(10);
		
		shift = new JTextField();
		shift.setFont(new Font("Tahoma", Font.PLAIN, 18));
		shift.setBounds(158, 347, 117, 29);
		contentPane.add(shift);
		shift.setColumns(10);
		
		
		
	}

}

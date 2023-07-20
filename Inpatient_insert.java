import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inpatient_insert extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField sex;
	private JTextField phone;
	private JTextField dept;
	private JTextField age;
	private JTextField address;
	private JTextField wt;
	private JTextField room;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inpatient_insert frame = new Inpatient_insert();
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

	public Inpatient_insert() {
		conn= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inpatient Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(182, 84, 278, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(60, 210, 69, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sex");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(60, 282, 69, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone no.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(33, 347, 96, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(391, 210, 69, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(377, 271, 69, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Weight");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(377, 340, 69, 32);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Department");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(20, 405, 109, 32);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Room no.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(360, 405, 86, 32);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "insert into Inpatient(Name,Address,Age,Sex,Phone_no,Weight,Dept,Room_no) values(?,?,?,?,?,?,?,?);";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, name.getText());
		            pst.setString(2, address.getText());
		            pst.setString(3, age.getText());
		            pst.setString(4, sex.getText());
		            pst.setString(5, phone.getText());
		            pst.setString(6, wt.getText());
		            pst.setString(7, dept.getText());
		            pst.setString(8, room.getText());
		            pst.execute();
		            JOptionPane.showMessageDialog(null, "Added successfully!");
		            name.setText("");
		            age.setText("");
		            sex.setText("");
		            address.setText("");
		            wt.setText("");
		            dept.setText("");
		            phone.setText("");
		            room.setText("");
		            conn.close();
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(288, 470, 86, 44);
		contentPane.add(btnNewButton);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name.setBounds(139, 211, 126, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		sex = new JTextField();
		sex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sex.setBounds(139, 274, 126, 32);
		contentPane.add(sex);
		sex.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setBounds(140, 343,126, 32);
		contentPane.add(phone);
		phone.setColumns(10);
		
		dept = new JTextField();
		dept.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dept.setBounds(140, 401, 126, 32);
		contentPane.add(dept);
		dept.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age.setBounds(460, 213, 126, 32);
		contentPane.add(age);
		age.setColumns(10);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		address.setBounds(460, 274, 126, 32);
		contentPane.add(address);
		address.setColumns(10);
		
		wt = new JTextField();
		wt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		wt.setBounds(460, 344, 126, 32);
		contentPane.add(wt);
		wt.setColumns(10);
		
		room = new JTextField();
		room.setFont(new Font("Tahoma", Font.PLAIN, 16));
		room.setBounds(460, 408, 126, 32);
		contentPane.add(room);
		room.setColumns(10);
	}
}
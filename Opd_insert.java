import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Opd_insert extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField weight;
	private JTextField dept;
	private JTextField age;
	private JTextField sex;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Opd_insert frame = new Opd_insert();
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

	public Opd_insert() {
		
		conn= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(362, 60, 175, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(113, 167, 56, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(103, 238, 66, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Weight");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(120, 318, 49, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(91, 423, 119, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Age");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(519, 167, 49, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sex");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(519, 238, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Phone no.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(509, 312, 96, 45);
		contentPane.add(lblNewLabel_7);
		
		name = new JTextField();
		name.setBounds(220, 164, 96, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setBounds(220, 235, 96, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(220, 326, 96, 20);
		contentPane.add(weight);
		weight.setColumns(10);
		
		dept = new JTextField();
		dept.setBounds(220, 431, 96, 20);
		contentPane.add(dept);
		dept.setColumns(10);
		
		age = new JTextField();
		age.setBounds(656, 164, 96, 20);
		contentPane.add(age);
		age.setColumns(10);
		
		sex = new JTextField();
		sex.setBounds(656, 235, 96, 20);
		contentPane.add(sex);
		sex.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(656, 326, 96, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JButton btn_opd_add = new JButton("Add");
		btn_opd_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "insert into OPD(Name,Address,Age,Sex,Phone_no,Weight,Dept) values(?,?,?,?,?,?,?);";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, name.getText());
		            pst.setString(2, address.getText());
		            pst.setString(3, age.getText());
		            pst.setString(4, sex.getText());
		            pst.setString(5, phone.getText());
		            pst.setString(6, weight.getText());
		            pst.setString(7, dept.getText());
		            pst.execute();
		            JOptionPane.showMessageDialog(null, "Added successfully!");
		            conn.close();
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
				
		    }
			});
		
		btn_opd_add.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_opd_add.setBounds(393, 487, 89, 45);
		contentPane.add(btn_opd_add);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;


public class Inpatient_search extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inpatient_search frame = new Inpatient_search();
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
	Connection conn1 = null;
    PreparedStatement pst = null;
    private JTable table;
   
	public Inpatient_search() {
		conn1= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(260, 56, 137, 37);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		name.setBounds(195, 153, 148, 31);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(54, 151, 119, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Phone no.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(32, 204, 141, 33);
		contentPane.add(lblNewLabel_2);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phone.setBounds(195, 211, 148, 31);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "select * from Inpatient where Name=? and Phone_no=?;";
		            pst = conn1.prepareStatement(query);
		            pst.setString(1, name.getText());
		            pst.setString(2, phone.getText());
		            ResultSet rs =pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            conn1.close();
		            
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(260, 275, 124, 43);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 381, 686, 98);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
}

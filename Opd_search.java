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
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JScrollPane;

public class Opd_search extends JFrame {

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
					Opd_search frame = new Opd_search();
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
    private JButton btnNewButton;
    private JTable table;
	public Opd_search() {
		conn= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(185, 24, 180, 39);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(185, 96, 96, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(71, 96, 104, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Phone no.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(51, 145, 124, 20);
		contentPane.add(lblNewLabel_2);
		
		phone = new JTextField();
		phone.setBounds(185, 147, 96, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "select * from OPD where Name=? and Phone_no=?;";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, name.getText());
		            pst.setString(2, phone.getText());
		            ResultSet rs =pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            conn.close();
		            
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(203, 207, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 280, 518, 63);
		contentPane.add(scrollPane);
		
		table= new JTable();
		scrollPane.setViewportView(table);
	}
}

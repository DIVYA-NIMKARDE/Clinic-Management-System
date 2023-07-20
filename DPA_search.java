import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DPA_search extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DPA_search frame = new DPA_search();
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
    	
	public DPA_search() {
		conn= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(293, 11, 84, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search Patients by Doctors");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = " select * from Inpatient where Patient_id in (select Patient_id from Operation where Doc_id =(select Doc_id from Doctor where name=?)) AND DOD is null;";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, name.getText());
		            ResultSet rs =pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		           /* if(rs.wasNull()) {
		            	JOptionPane.showMessageDialog(null, "Doctor not found!!");
		            	}
		            else
		            	table.setModel(DbUtils.resultSetToTableModel(rs));*/
		            	
		            conn.close();
		            
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(218, 140, 275, 36);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 252, 709, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Patients under Treatement");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(232, 208, 248, 44);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		name.setBounds(376, 71, 156, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Doctor name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(188, 74, 178, 28);
		contentPane.add(lblNewLabel_2);
	}
}
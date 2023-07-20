import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Bill_Insert extends JFrame {

	private JPanel contentPane;
	private JTextField P_id;
	private JTextField insurance;
	private JTextField medical;
	private JTextField lab;
	private JTextField name;
	private JTextField room;
	private JTextField nursing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill_Insert frame = new Bill_Insert();
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
	Connection conn2 = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    private JTextField tot;
	public Bill_Insert() {
		conn= JDBC.dbconnector();
		conn2= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Billing");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 35));
		lblNewLabel.setBounds(264, 42, 141, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(70, 139, 81, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Insurance amt");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(39, 203, 107, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Medical bill");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(53, 273, 81, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(390, 149, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Room bill");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(372, 206, 72, 18);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nursing bill");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(354, 269, 90, 24);
		contentPane.add(lblNewLabel_6);
		
		P_id = new JTextField();
		P_id.setBounds(171, 145, 96, 24);
		contentPane.add(P_id);
		P_id.setColumns(10);
		
		insurance = new JTextField();
		insurance.setBounds(171, 199, 96, 24);
		contentPane.add(insurance);
		insurance.setColumns(10);
		
		medical = new JTextField();
		medical.setBounds(171, 270, 96, 24);
		contentPane.add(medical);
		medical.setColumns(10);
		
		lab = new JTextField();
		lab.setBounds(171, 340, 96, 24);
		contentPane.add(lab);
		lab.setColumns(10);
		
		name = new JTextField();
		name.setBounds(475, 145, 96, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		room = new JTextField();
		room.setBounds(475, 205, 96, 24);
		contentPane.add(room);
		room.setColumns(10);
		
		nursing = new JTextField();
		nursing.setBounds(487, 271, 96, 24);
		contentPane.add(nursing);
		nursing.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Lab bill");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(70, 342, 64, 16);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Calculate Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "insert into Billing(P_id,Name,Insurance,Room_bill,Medical_bill,Nursing_care,Lab_bill) values(?,?,?,?,?,?,?);";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, P_id.getText());
		            pst.setString(2, name.getText());
		            pst.setString(3, insurance.getText());
		            pst.setString(4, room.getText());
		            pst.setString(5, medical.getText());
		            pst.setString(6, nursing.getText());
		            pst.setString(7, lab.getText());
		            pst.execute();
		            JOptionPane.showMessageDialog(null, "Added successfully!");
		            conn.close();
		            
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
				try{
		            String query1 = "select * from Billing where P_id=?;";
		            pst2 = conn2.prepareStatement(query1);
		            pst2.setString(1, P_id.getText());
		            ResultSet rs2 =pst2.executeQuery();
		            if(rs2.next()) {
		            	String total= rs2.getString(9);
		            	tot.setText(total);
		            }else {
		            	JOptionPane.showMessageDialog(null, "");
		            }
		       
		            conn2.close();
		            
		        }catch(Exception e2){
		            JOptionPane.showMessageDialog(null,e2);
		        }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(249, 393, 141, 41);
		contentPane.add(btnNewButton);
		
		tot = new JTextField();
		tot.setBounds(354, 459, 122, 33);
		contentPane.add(tot);
		tot.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Total amt to be paid");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(124, 461, 185, 24);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Rs.");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(319, 461, 29, 24);
		contentPane.add(lblNewLabel_9);
	}
}
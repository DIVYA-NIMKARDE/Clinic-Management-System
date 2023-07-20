import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Print_bill extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField p_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Print_bill frame = new Print_bill();
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
    //PreparedStatement pst1 = null;
    private JScrollPane scrollPane;
	public Print_bill() {
		conn= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 581, 105);
		contentPane.add(scrollPane);
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Print Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "select * from Billing where P_id=?;";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, p_id.getText());
		       
		            ResultSet rs =pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            conn.close();
		            
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(192, 105, 158, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enetr P_id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(154, 43, 84, 27);
		contentPane.add(lblNewLabel);
		
		p_id = new JTextField();
		p_id.setBounds(261, 45, 131, 27);
		contentPane.add(p_id);
		p_id.setColumns(10);
	}
}

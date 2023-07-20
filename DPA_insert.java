import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DPA_insert extends JFrame {

	private JPanel contentPane;
	private JTextField doc;
	private JTextField pat;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DPA_insert frame = new DPA_insert();
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

	public DPA_insert() {
		conn= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointments");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(146, 30, 176, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Doctor ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(56, 113, 144, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Patient ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(56, 173, 144, 23);
		contentPane.add(lblNewLabel_2);
		
		doc = new JTextField();
		doc.setBounds(226, 113, 96, 24);
		contentPane.add(doc);
		doc.setColumns(10);
		
		pat = new JTextField();
		pat.setBounds(226, 173, 96, 24);
		contentPane.add(pat);
		pat.setColumns(10);
		
		btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "insert into Operation(Doc_id,Patient_id) values(?,?);";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, doc.getText());
		            pst.setString(2, pat.getText());
		       
		            pst.execute();
		            JOptionPane.showMessageDialog(null, "Added successfully!");
		            conn.close();
		            
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(175, 226, 89, 34);
		contentPane.add(btnNewButton);
	}

}
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Doctor_update extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField shift;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_update frame = new Doctor_update();
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
	public Doctor_update() {
		conn= JDBC.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Shift");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(223, 57, 151, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(54, 151, 119, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            String query = "update Doctor set Shift=? where Name=?;";
		            pst = conn.prepareStatement(query);
		            pst.setString(1, shift.getText());
		            pst.setString(2, name.getText());
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Shift Updated successfully!!");
		            conn.close();
		            dispose();
		            
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(262, 301, 124, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Enter updated shift");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(21, 211, 193, 31);
		contentPane.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name.setBounds(262, 151, 141, 33);
		contentPane.add(name);
		name.setColumns(10);
		
		shift = new JTextField();
		shift.setFont(new Font("Tahoma", Font.PLAIN, 16));
		shift.setBounds(262, 220, 141, 31);
		contentPane.add(shift);
		shift.setColumns(10);
		
	}

}

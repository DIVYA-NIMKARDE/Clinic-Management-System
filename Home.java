import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setBackground(new Color(135, 206, 250));
		lblNewLabel.setBounds(273, 79, 135, 43);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		
		JButton btnOPD = new JButton("OPD");
		btnOPD.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//dispose();
				OPD opd=new OPD();
				opd.setVisible(true);
			}
		});
		btnOPD.setBackground(UIManager.getColor("MenuBar.shadow"));
		btnOPD.setBounds(144, 228, 135, 43);
		btnOPD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(btnOPD);
		
		JButton btnNewButton = new JButton("InPatient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inpatient inpatient = new Inpatient();
				inpatient.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(376, 228, 135, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Doctor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor doctor = new Doctor();
				doctor.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(144, 319, 135, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DPA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DPA dpa = new DPA();
				dpa.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(376, 319, 135, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Bill");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Billing bill = new Billing();
				bill.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(257, 409, 135, 43);
		contentPane.add(btnNewButton_3);
	}

}

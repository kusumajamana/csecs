package retrive_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class register {

	private JFrame frame;
	private JTextField n;
	private JTextField mar;
	private JTextField s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(54, 152, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		n = new JTextField();
		n.setBounds(141, 151, 159, 20);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(54, 111, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marks");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(54, 202, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		mar = new JTextField();
		mar.setBounds(141, 201, 159, 20);
		frame.getContentPane().add(mar);
		mar.setColumns(10);
		
		s = new JTextField();
		s.setBounds(141, 110, 159, 20);
		frame.getContentPane().add(s);
		s.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("REGISTER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_3.setBounds(153, 30, 147, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno= s.getText();
				int sn=Integer.parseInt(sno);
				String name=n.getText();
				String mark=mar.getText();
				float marks=Float.parseFloat(mark);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retrive","root","mrec");
					String q="Insert into data values('"+sn+"','"+name+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton,"Done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(195, 248, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}

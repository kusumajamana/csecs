package retrive_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class get_data {

	private JFrame frame;
	private JTextField s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					get_data window = new get_data();
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
	public get_data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 544, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sno");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(68, 96, 92, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel n = new JLabel("Name");
		n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		n.setBounds(68, 199, 92, 56);
		frame.getContentPane().add(n);
		
		JLabel m = new JLabel("Marks");
		m.setFont(new Font("Tahoma", Font.PLAIN, 16));
		m.setBounds(68, 253, 92, 34);
		frame.getContentPane().add(m);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno= s.getText();
				int sn=Integer.parseInt(sno);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retrive","root","mrec");
					String q="select name,marks from data where sno=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, sn);
					ResultSet rs=ps.executeQuery();
					rs.next();
					n.setText("Name:"+rs.getString(1));
					m.setText("Marks:"+rs.getFloat(2));
					con.close();
					//JOptionPane.showMessageDialog(btnNewButton,"Done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(150, 141, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		s = new JTextField();
		s.setBounds(138, 105, 118, 20);
		frame.getContentPane().add(s);
		s.setColumns(10);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public JComboBox comboBox;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		super("Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 469);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterDetails = new JLabel("Enter Details");
		
		JLabel lblFirstName = new JLabel("First Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		passwordField = new JPasswordField();
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		
		passwordField_1 = new JPasswordField();
		
		JLabel lblUsertype = new JLabel("Usertype");
		
		String value[]={" SELECT", "Admin","User"};
		comboBox = new JComboBox(value);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String fname=textField.getText();
				String lname=textField_1.getText();
				String username=textField_2.getText();
				char ch[]=passwordField.getPassword();
				char[] ch1=passwordField_1.getPassword();
				String pass=String.copyValueOf(ch);
				String retypepass=String.copyValueOf(ch1);
				String usertype=(String)comboBox.getSelectedItem();
				String email=textField_3.getText();
				
				if(fname.length()==0 || lname.length()==0 || username.length()==0 ||
						pass.length()==0 || retypepass.length()==0 || usertype.length()==0 ||
						email.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Enter all the fields");
				}
				else
				{
				if(!pass.equals(retypepass))
				{
					JOptionPane.showMessageDialog(getParent(), "Passwords do not match");
					passwordField.setText(null);
					passwordField_1.setText(null);
				}
				else
				{
				Connection con=DBInfo.con;
				String query="insert into registration values(?,?,?,?,?,?,?)";
				String query1="insert into login values(?,?,?) ";
				String query2="select username from registration";
				int flag=0;
				a:
				try
				{
						PreparedStatement ps=con.prepareStatement(query2);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							String s1=res.getString(1);
							if(s1.equalsIgnoreCase(username))
							{
								JOptionPane.showMessageDialog(getParent(), "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
								textField_2.setText(null);
								break a;
							}
						}
						PreparedStatement ps1=con.prepareStatement(query);
						ps1.setString(1, fname);
						ps1.setString(2, lname);
						ps1.setString(3, username);
						ps1.setString(4, pass);
						ps1.setString(5, retypepass);
						ps1.setString(6, usertype);
						ps1.setString(7, email);
						flag=ps1.executeUpdate();
						if(flag!=0)
						{
							JOptionPane.showMessageDialog(getParent(), "Registration Successful");
							reset();
						}
						PreparedStatement ps2=con.prepareStatement(query1);
						ps2.setString(1, username);
						ps2.setString(2, pass);
						ps2.setString(3, usertype);
						ps2.executeUpdate();
					}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			}
			}
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
			}
		});
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Login l=new Login();
				l.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblEmail = new JLabel("Email ");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(194)
							.addComponent(lblEnterDetails))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFirstName)
								.addComponent(lblLastName)
								.addComponent(lblUsername)
								.addComponent(lblPassword)
								.addComponent(lblRetypePassword)
								.addComponent(lblUsertype)
								.addComponent(lblEmail))
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_3)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(passwordField_1)
								.addComponent(passwordField, Alignment.TRAILING)
								.addComponent(textField_2, Alignment.TRAILING)
								.addComponent(textField_1, Alignment.TRAILING)
								.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterDetails)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRetypePassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsertype)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset)
						.addComponent(btnLogin))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
  
	public void reset()
	{
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		passwordField.setText(null);
		passwordField_1.setText(null);
		comboBox.setSelectedIndex(0);
		textField_3.setText(null);
	}
}

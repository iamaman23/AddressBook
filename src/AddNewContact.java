import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.mail.handlers.text_xml;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddNewContact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewContact frame = new AddNewContact();
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
	public AddNewContact() {
		super("Add New Contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 399, 383);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterContactDetails = new JLabel("Enter Contact Details");
		
		JLabel lblFirstName = new JLabel("First Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String fname=textField.getText();
				String lname=textField_1.getText();
				String email=textField_2.getText();
				String mobile=textField_3.getText();
				String phone=textField_4.getText();
				String address=textField_5.getText();
				
				if(fname.length()==0 || lname.length()==0 || email.length()==0
						|| mobile.length()==0 || phone.length()==0 || address.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Enter all the fields", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(mobile.length()!=10)
				{
					JOptionPane.showMessageDialog(getParent(), "Mobile Number should be of 10 digits", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				String query="insert into contact values(?,?,?,?,?,?,?)";
				Connection con=DBInfo.con;
				int flag=0;
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, 0);
					ps.setString(2, fname);
					ps.setString(3, lname);
					ps.setString(4, email);
					ps.setString(5, mobile);
					ps.setString(6, phone);
					ps.setString(7, address);
					flag=ps.executeUpdate();
					if(flag!=0)
					{
						JOptionPane.showMessageDialog(getParent(), "Contact added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						reset();
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			}
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				reset();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(128)
							.addComponent(lblEnterContactDetails))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLastName)
								.addComponent(lblEmail)
								.addComponent(lblFirstName)
								.addComponent(lblMobile)
								.addComponent(lblPhone)
								.addComponent(lblAddress))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(11)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblEnterContactDetails)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobile)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void reset()
	{
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
	}

}

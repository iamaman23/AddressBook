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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public String getOTP()
	{
		String value = "";
		int i;
		for(i=1;i<=6;i++)
		{
			value+=(int)(Math.random()*9)+1;
		}
		return value;
		
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 239);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
	
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String username=textField.getText();
				String usertype="";
				char[] ch=passwordField.getPassword();
				String password=String.copyValueOf(ch);
				
				Connection con=DBInfo.con;
				String query="select * from login where username=? and password=?";
				
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, username);
					ps.setString(2, password);
					ResultSet res=ps.executeQuery();
					int flag=0;
					while(res.next())
					{
						String uname=res.getString(1);
						String pass=res.getString(2);
						if(uname.equalsIgnoreCase(username) && pass.equals(password))
						{
							flag=1;
							usertype=res.getString("usertype");
							break;
						}
					}
					if(flag==1 && usertype.equalsIgnoreCase("admin") )
					{
						Admin a=new Admin();
						a.setVisible(true);
						dispose();
					}
					if(flag==1 && usertype.equalsIgnoreCase("user"))
					{
						User u=new User();
						u.setVisible(true);
						dispose();
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Incorrect username or password", "ERROR", JOptionPane.ERROR_MESSAGE	);
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
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
		
		JButton btnNewUser = new JButton("NEW USER");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Registration r=new Registration();
				r.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("Get OTP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String username=textField.getText();
				if(username.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter a username");	
				}
				else
				{
					String email=JOptionPane.showInputDialog("Enter your email id");
					String query= "select * from registration where username=? ";
					Connection con=DBInfo.con;
					int flag=0;
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, username);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							String uname=res.getString(3);
							String em=res.getString(7);
							String usertype=res.getString(6);
							
							if(!em.equalsIgnoreCase(email))
							{
								JOptionPane.showMessageDialog(getParent(), "Email not registered");
							}
							else if(em.equals(email))
							{
								String s1=getOTP();
								Email a=new Email(email, s1);
								String s2=JOptionPane.showInputDialog("Enter the one time password");
								if(s1.equals(s2) && usertype.equalsIgnoreCase("admin"))
								{
									Admin ad=new Admin();
									ad.setVisible(true);
								}
								else if(s1.equals(s2) && usertype.equalsIgnoreCase("user"))
								{
									User u=new User();
									u.setVisible(true);
								}
								if(!s1.equals(s2))
								{
									JOptionPane.showMessageDialog(getParent(), "Wrong OTP");

								}
							}
								
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterPassword)
							.addGap(27)
							.addComponent(passwordField, 255, 255, 255))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterUsername)
							.addGap(25)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
					.addGap(57))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewUser)
					.addContainerGap(71, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(144)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(131))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewUser)
						.addComponent(btnReset)
						.addComponent(btnLogin))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void reset()
	{
		textField.setText(null);
		passwordField.setText(null);
	}
	
}

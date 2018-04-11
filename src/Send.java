import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Send extends JFrame {

	private JPanel contentPane;
	public String fname,lname,email,mobile,phone,address;

	

	/**
	 * Create the frame.
	 */
	public Send() {
		super("Send contact information via email");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		
		String first=JOptionPane.showInputDialog("Enter the first name of the person whose contact information is to be send");
		String last=JOptionPane.showInputDialog("Enter the last name of the person whose contact information is to be send");
		String query="select * from contact";
		Connection con=DBInfo.con;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				fname=res.getString(2);
				lname=res.getString(3);
				email=res.getString(4);
				mobile=res.getString(5);
				phone=res.getString(6);
				address=res.getString(7);
				if(first.equalsIgnoreCase(fname) && last.equalsIgnoreCase(lname))
				{
					String em=JOptionPane.showInputDialog("Enter the email id to which the information is to be send");
					Email e=new Email(em, fname, lname, email, mobile, phone, address);
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void messageSent()
	{
		JOptionPane.showMessageDialog(getParent(), "Email Sent");
	}

}

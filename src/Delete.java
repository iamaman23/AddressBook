import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Delete extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public Delete() {
		super("Delete Contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		String fname=JOptionPane.showInputDialog("Enter First Name");
		String lname=JOptionPane.showInputDialog("Enter last name");

		String query="delete from contact where firstname=? and lastname=?";
		Connection con=DBInfo.con;
		int flag=0;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, lname);
			
			flag=ps.executeUpdate();
			if(flag!=0)
			{
				JOptionPane.showMessageDialog(getParent(), "Contact Deleted Successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(getParent(), "Contact Not Found ", "ERROR", JOptionPane.ERROR_MESSAGE);

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

}

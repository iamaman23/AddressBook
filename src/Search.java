import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Search extends JFrame {

	private JPanel contentPane;
	String fname,lname;

	
	/**
	 * Create the frame.
	 */
	public Search() {
		super("Search Contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		fname=JOptionPane.showInputDialog("Enter First Name");
		if(fname.length()==0)
		{
			JOptionPane.showMessageDialog(getParent(), "Don't leave the field blank");
		}
		else
		{
		lname=JOptionPane.showInputDialog("Enter Last Name");
		if(lname.length()==0)
		{
			JOptionPane.showMessageDialog(getParent(), "Don't leave the field blank");
		}
		else
		{
		DBInfo.getContact(fname, lname);
		JFrame frm=new JFrame();
		
		frm.setSize(1400, 600);
		frm.setLocationRelativeTo(frm);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		JTable t=new JTable(DBInfo.inner, DBInfo.outer);
		JScrollPane pane=new JScrollPane(t);
		frm.add(pane);
		frm.setVisible(true);
	    dispose();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
		}
	}
}

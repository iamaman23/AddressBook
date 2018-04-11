import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Admin extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public Admin() {
		super("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 432);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddNewContact = new JButton(new ImageIcon("image1.png"));
		btnAddNewContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AddNewContact a=new AddNewContact();
				a.setVisible(true);
			}
		});
		
		JButton button = new JButton(new ImageIcon("image2.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Search s=new Search();
				//s.setVisible(true);
			}
		});
		
		JButton button_1 = new JButton(new ImageIcon("image3.jpg"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Update u=new Update();
				u.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton(new ImageIcon("image4.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Delete d=new Delete();
				//d.setVisible(true);
			}
		});
		
		JButton button_3 = new JButton(new ImageIcon("image5.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Send s=new Send();
				//s.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAddNewContact, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddNewContact, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

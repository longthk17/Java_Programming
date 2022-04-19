package exercise;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener {
	
	User user;
	
	JLabel homeLb;
	
	JButton btnLogout;
	
	
	public Home() {
		initGUI(user);
	}
	
	public Home(User user) {
		initGUI(user);
		setTitle("HOME");
	}
	
	private void initGUI(User user) {
		setTitle("NGU");
		setLayout(null);
		
		initComponents(user);

		setSize(500,500);

		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initComponents(User user) {
		String text = "Hello " + user.getUsername();
		homeLb = new JLabel(text);
		homeLb.setFont(new Font("Verdana", Font.BOLD, 20));
		homeLb.setBounds(210,50,200,60);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(150, 200, 100, 60);
		btnLogout.addActionListener(this);
		
		add(homeLb);
		add(btnLogout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnLogout) {
			this.user = null;
			this.dispose();
			Login login = new Login("Login");
			login.setVisible(true);
		}
	}

}
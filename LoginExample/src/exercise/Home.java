package exercise;

import java.awt.Font;

import javax.swing.*;

public class Home extends JFrame {
	
	User user;
	
	JLabel homeLb;
	
	
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
	}
	
	private void initComponents(User user) {
		String text = "Hello " + user.getUsername();
		homeLb = new JLabel(text);
		homeLb.setFont(new Font("Verdana", Font.BOLD, 20));
		homeLb.setBounds(210,50,200,60);
		
		add(homeLb);
	}

}
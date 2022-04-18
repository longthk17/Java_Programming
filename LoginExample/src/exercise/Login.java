package exercise;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JLabel lb_title, lb_username, lb_password;
	JTextField tf_username;
	JPasswordField tf_password;
	JButton btnLogin, btnExit, btnReg;
	
	JPanel btnPanel;
	
	public Login(String title) {
		initGUI(title);
	}
	
	private void initGUI(String title) {
		setTitle(title);
		setLayout(null);
		
		initComponents();
		
		setBounds(500, 80, 500, 400);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initComponents() {		
		lb_title = new JLabel("Login");
		lb_title.setFont(new Font("Verdana", Font.BOLD, 30));
		lb_title.setBounds(210,50,100,60);
		
		lb_username = new JLabel("Username");
		lb_username.setFont(new Font("Verdana", Font.BOLD, 15));
		lb_username.setBounds(100, 150, 100, 20);
		lb_password = new JLabel("Password");
		lb_password.setFont(new Font("Verdana", Font.BOLD, 15));
		lb_password.setBounds(100, 200, 100, 20);
		
		tf_username = new JTextField();
		tf_username.setBounds(200, 145, 150, 25);
		
		tf_password = new JPasswordField();
		tf_password.setBounds(200, 195, 150, 25);
		
		btnPanel = new JPanel(new FlowLayout());
		btnPanel.setBounds(130, 250, 250, 100);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnReg = new JButton("Register");
		btnExit = new JButton("Exit");
		
		btnPanel.add(btnLogin);
		btnPanel.add(btnReg);
		btnPanel.add(btnExit);
		
		add(lb_title);
		add(lb_username);
		add(lb_password);
		add(tf_username);
		add(tf_password);
		add(btnPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnLogin) {
			String username = tf_username.getText();
			String hashPass = Hashing.getMd5(tf_password.getText());
			User user = new User();
			user.getByUsername(username);
			if(validateLogin(user)) {
				System.out.println("sai");
			} else {
				Home home = new Home(user);
				home.setVisible(true);
				this.dispose();
			}
		}
	}
	
	public static boolean validateLogin(String a, String b) {
		if(a == b) {
			return true;
		}
		else return false;
	}
	
	boolean validateLogin(User user) {
		if(user == null) {
			return false;
		} else if (tf_password.getText() != user.getPassword()) {
			return false;
		}
		return true;
	}
}

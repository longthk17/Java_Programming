package exercise;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Register extends JFrame implements ActionListener {
	
	JLabel lbTitle, lbUsername, lbPass, lbConfirmPass;
	JTextField tfUsername;
	JPasswordField tfPass, tfCofirmPass;
	JButton btnSave, btnLogin;
	
	JPanel pn1;
	
	
	public Register(String title) {
		initGUI(title);
	}
	
	private void initGUI(String title) {
		setTitle(title);
		setLayout(null);
		
		initComponents();
		
		setBounds(450, 80, 500, 400);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(false);
	}
	
	private void initComponents() {
		lbTitle = new JLabel("Register");
		lbTitle.setFont(new Font("Verdana", Font.BOLD, 30));
		lbTitle.setBounds(180,50,200,60);
		
		lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Verdana", Font.BOLD, 10));
		lbUsername.setBounds(120,150,100,20);
		lbPass = new JLabel("Password");
		lbPass.setFont(new Font("Verdana", Font.BOLD, 10));
		lbPass.setBounds(120,200,100,20);
		lbConfirmPass = new JLabel("Cofirm Password");
		lbConfirmPass.setFont(new Font("Verdana", Font.BOLD, 10));
		lbConfirmPass.setBounds(120,250,100,20);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(230,145,150,25);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(230,195,150,25);
		tfCofirmPass = new JPasswordField();
		tfCofirmPass.setBounds(230,245,150,25);
		
		pn1 = new JPanel(new FlowLayout());
		pn1.setBounds(130,285,250,100);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		
		pn1.add(btnSave);
		pn1.add(btnLogin);
		
		add(lbTitle);
		add(lbUsername);
		add(lbPass);
		add(lbConfirmPass);
		add(tfUsername);
		add(tfPass);
		add(tfCofirmPass);
		add(pn1);
	}
	
	public static boolean validateReg(User user) {
		if(user.getUsername() == null || user.getUsername().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "username khong duoc co khoang trang");
			return false;
		} else if (user.getPassword().length() < 6) {
			JOptionPane.showMessageDialog(null, "password phai co do dai lon hon 6");
			return false;
		} else if (checkUser(user.getUsername()) != true) {
			JOptionPane.showMessageDialog(null, "username ton tai");
			return false;
		} else return true;
}

	public static boolean checkUser(String username) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT Username FROM users WHERE Username = ? ";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1,username);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				return false;
			} else return true;
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
			return false;
		}
	}
	
	// method create User into DB
	public boolean saveUser(User user) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "INSERT INTO users(Username,Password) VALUES(?,?)";
			String hashPassword = Hashing.getMd5(user.getPassword());
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, user.getUsername());
			prest.setString(2, hashPassword);
			prest.executeUpdate();
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnSave) {
			//Khoi tao doi tuong user
			User user = new User();
			//set User
			user.setUsername(tfUsername.getText());
			user.setPassword(tfPass.getText());
			// Encode pass
			String hashPass = Hashing.getMd5(tfPass.getText());
			//check register
			if(validateReg(user) == true) {
				//check password ==
				if(user.getPassword().equals(tfCofirmPass.getText())) {
					if(saveUser(user)) {
						int ques;
						ques = JOptionPane.showConfirmDialog(this, "Them thanh cong",null,JOptionPane.OK_CANCEL_OPTION );
						if(ques == JOptionPane.OK_OPTION) {
							Login login = new Login("Login");
							this.dispose();
							login.setVisible(true);
						}
					}
				}
			}
		}
		if(e.getSource() == btnLogin) {
			Login login = new Login("Login");
			this.dispose();
			login.setVisible(true);
		}
		
	}
}

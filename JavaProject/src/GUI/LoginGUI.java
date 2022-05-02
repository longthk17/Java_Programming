package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DTO.Employee;
import DAL.EmployeeDAL;

public class LoginGUI extends JFrame implements ActionListener {
	JLabel lbUsername, lbPass, lbTitle;
	JTextField tfUsername;
	JPasswordField tfPass;
	
	JButton btnLogin;
	
	Employee curEmp;
	
	
	public LoginGUI() {
		initGUI();
	}
	
	private void initGUI() {
		setTitle("NGU");
		setLayout(null);
		
		initComponents();
		
		getContentPane().setBackground(Color.decode("#EEEEEE"));
		setBounds(450,80,500,500);
		setResizable(false);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initComponents() {
		lbTitle = new JLabel("Welcome");
		lbTitle.setFont(new Font("Keyes", Font.BOLD, 40));
		lbTitle.setBounds(150,-30,200,200);
		
		ImageIcon originalIcon = new ImageIcon(this.getClass().getResource("/images/user.png"));
 
        int width = originalIcon.getIconWidth() / 4;
        int height = originalIcon.getIconHeight() / 4;
        
        Image scaled = scaleImage(originalIcon.getImage(), width, height);
 
        ImageIcon scaledIcon = new ImageIcon(scaled);

        JLabel icon = new JLabel();
        icon.setIcon(scaledIcon);
        
        icon.setBounds(180,110,width,height);
        
        lbUsername = new JLabel("Username");
        lbUsername.setFont(new Font("Adams", Font.ITALIC,15));
        lbUsername.setBounds(80, 230, 150, 100);
        lbPass = new JLabel("Password");
        lbPass.setFont(new Font("Adams", Font.ITALIC,15));
        lbPass.setBounds(80, 280, 150, 100);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(205,268,150,25);
        
        tfPass = new JPasswordField();
        tfPass.setBounds(205,318,150,25);
        
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Adams", Font.PLAIN, 15));
        btnLogin.setBounds(190,380,100,25);
        btnLogin.setBorder(BorderFactory.createLineBorder(Color.black));
        btnLogin.addActionListener(this);
        
        add(lbTitle);
        add(icon);
        add(lbUsername);
        add(lbPass);
        add(tfUsername);
        add(tfPass);
        add(btnLogin);
	}

    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnLogin) {
			String username = tfUsername.getText();
			String password = tfPass.getText();
			Employee emp = EmployeeDAL.getByUsername(username);
			if(emp != null) {
				curEmp = emp;
				if(curEmp.getPassword().equals(password)) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
					HomeGUI home = new HomeGUI(curEmp);
					home.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Sai mật khẩu");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại");
			}
		}
		
	}
}
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import DTO.Employee;

public class HomeGUI extends JFrame implements ActionListener{
	
	JPanel mainHome, mainHeader;
	JButton btnCustomer,btnEmployee,btnMerchandise,btnReceipt, btnLogout, btnChangePass;
	
	JPanel pn1, pn2;
	
	Employee curEmp;
	
	EmployeeGUI emp = new EmployeeGUI();
	MerchandiseGUI mer = new MerchandiseGUI();
	
	public HomeGUI(Employee emp) {
		this.curEmp = emp;
		initGUI();
	}
	
	private void initGUI() {
		setTitle("NGU");
		setLayout(null);

		initHeader();
		initComponents();

		getContentPane().setBackground(Color.decode("#DFEEEA"));
		setBounds(100,0,1200,750);
		setResizable(false);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(false);
	}
	
	private void initHeader() {
		mainHeader = new JPanel();
		mainHeader.setLayout(null);
		mainHeader.setBackground(Color.decode("#2F5D62"));
		mainHeader.setBounds(0,0,1200,120);
		
		ImageIcon originalIcon = new ImageIcon(this.getClass().getResource("/images/logo.png"));
 
        int width = originalIcon.getIconWidth() / 4;
        int height = originalIcon.getIconHeight() / 4;
        
        //Dòng này là để scale lại ảnh
        Image scaled = scaleImage(originalIcon.getImage(), width, height);
 
        ImageIcon scaledIcon = new ImageIcon(scaled);

        JLabel icon = new JLabel();
        icon.setIcon(scaledIcon);
        
        icon.setBounds(-10,-10,width,height);
        
        JLabel title = new JLabel("LaptopS");
        title.setFont(new Font("AddElectricCity", Font.BOLD, 50));
        title.setForeground(Color.decode("#FFFFFF"));
        title.setBounds(120, 10, 300, 100);
        
        JLabel hello = new JLabel();
        hello.setText("Hello, " + curEmp.getFullName());
        hello.setFont(new Font("Keyes", Font.ITALIC, 25));
        hello.setForeground(Color.decode("#DFEEEA"));
        hello.setBounds(900, 40, 250, 80);
        
        btnChangePass = new JButton("Change Password");
        btnChangePass.setFont(new Font("Verdana", Font.BOLD, 15));
        btnChangePass.setForeground(Color.decode("#DFEEEA"));
        btnChangePass.setFocusable(false);
        btnChangePass.setBackground(Color.decode("#2F5D62"));
        btnChangePass.setBorder(null);
        btnChangePass.addActionListener(this);
        

		btnLogout = new JButton();
		ImageIcon iconLogout = new ImageIcon(this.getClass().getResource("/images/power-off.png"));
		btnLogout.setIcon(iconLogout);
		btnLogout.setFocusable(false);
		btnLogout.setBackground(Color.decode("#2F5D62"));
		btnLogout.setBorder(null);
		btnLogout.addActionListener(this);
		
		
		
		pn1 = new JPanel();
		pn1.setLayout(new FlowLayout());
		pn1.setBounds(850,10,400, 80);
		pn1.setBackground(Color.decode("#2F5D62"));
		
		pn1.add(btnChangePass);
		pn1.add(btnLogout);

        mainHeader.add(title);
        mainHeader.add(icon);
        mainHeader.add(hello);
//        mainHeader.add(lbLogout);
        mainHeader.add(pn1);
		
		add(mainHeader);

	}
	
    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
	
	private void initComponents() {
		mainHome = new JPanel();
		mainHome.setLayout(new GridLayout(4,0));
		mainHome.setBackground(Color.decode("#5E8B7E"));
		mainHome.setBounds(0,120,150,595);
		
		btnEmployee = new JButton("Employee");
		ImageIcon iconEmployee = new ImageIcon(this.getClass().getResource("/images/employee.png"));
		btnEmployee.setIcon(iconEmployee);
//		btnEmployee.setFocusable(false);
		btnEmployee.setHorizontalTextPosition(JButton.CENTER);
		btnEmployee.setVerticalTextPosition(JButton.BOTTOM);
		btnEmployee.setFont(new Font("Keyes", Font.BOLD, 15));
		btnEmployee.setBackground(Color.decode("#5E8B7E"));
		btnEmployee.setForeground(Color.decode("#F6E7D8"));
//		btnEmployee.setEnabled(false);
		btnEmployee.addActionListener(this);
		
		btnCustomer = new JButton("Customer");
		ImageIcon iconCustomer = new ImageIcon(this.getClass().getResource("/images/customer.png"));
		btnCustomer.setIcon(iconCustomer);
		btnCustomer.setFocusable(false);
		btnCustomer.setHorizontalTextPosition(JButton.CENTER);
		btnCustomer.setVerticalTextPosition(JButton.BOTTOM);
		btnCustomer.setFont(new Font("Keyes", Font.BOLD, 15));
		btnCustomer.setBackground(Color.decode("#5E8B7E"));
		btnCustomer.setForeground(Color.decode("#F6E7D8"));
//		btnCustomer.setEnabled(false);
		btnCustomer.addActionListener(this);

		btnMerchandise = new JButton("Merchandise");
		ImageIcon iconMerchandise = new ImageIcon(this.getClass().getResource("/images/laptop.png"));
		btnMerchandise.setIcon(iconMerchandise);
		btnMerchandise.setFocusable(false);
		btnMerchandise.setHorizontalTextPosition(JButton.CENTER);
		btnMerchandise.setVerticalTextPosition(JButton.BOTTOM);
		btnMerchandise.setFont(new Font("Keyes", Font.BOLD, 15));
		btnMerchandise.setBackground(Color.decode("#5E8B7E"));
		btnMerchandise.setForeground(Color.decode("#F6E7D8"));
//		btnMerchandise.setEnabled(false);
		btnMerchandise.addActionListener(this);

		btnReceipt = new JButton("Receipt");
		ImageIcon iconReceipt = new ImageIcon(this.getClass().getResource("/images/bill.png"));
		btnReceipt.setIcon(iconReceipt);
		btnReceipt.setFocusable(false);
		btnReceipt.setHorizontalTextPosition(JButton.CENTER);
		btnReceipt.setVerticalTextPosition(JButton.BOTTOM);
		btnReceipt.setFont(new Font("Keyes", Font.BOLD, 15));
		btnReceipt.setBackground(Color.decode("#5E8B7E"));
		btnReceipt.setForeground(Color.decode("#F6E7D8"));
//		btnReceipt.setEnabled(false);
		btnReceipt.addActionListener(this);		

		mainHome.add(btnEmployee);
		mainHome.add(btnCustomer);
		mainHome.add(btnMerchandise);
		mainHome.add(btnReceipt);
		
		add(mainHome);
	}
	
	public void clear() {
		emp.setVisible(false);
		mer.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnLogout) {
			LoginGUI login = new LoginGUI();
			this.dispose();
		}
		if(e.getSource() == btnChangePass) {
			
		}
		if(e.getSource() == btnEmployee) {
			clear();
			emp.setVisible(true);
			add(emp);
			emp.setBounds(150,120,emp.getWidth(),emp.getHeight());
		}
		if(e.getSource() == btnMerchandise) {
			clear();
			mer.setVisible(true);
			add(mer);
			mer.setBounds(150,120,mer.getWidth(),mer.getHeight());
		}
	}

}

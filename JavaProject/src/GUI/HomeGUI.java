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

public class HomeGUI extends JFrame implements ActionListener{
	
	JPanel mainHome, mainHeader;
	JButton btnCustomer,btnEmployee,btnMerchandise,btnReceipt;
	
	JPanel contentPanel, pn1, pn2;
	
	public HomeGUI() {
		initGUI();
	}
	
	private void initGUI() {
		setTitle("NGU");
		setLayout(null);

		initHeader();
		initComponents();

		getContentPane().setBackground(Color.decode("#DFEEEA"));
		setBounds(100,0,1200,750);
		setVisible(true);
		
	}
	
	private void initHeader() {
		mainHeader = new JPanel();
		mainHeader.setLayout(null);
		mainHeader.setBackground(Color.decode("#2F5D62"));
		mainHeader.setBounds(0,0,1200,120);
		
		ImageIcon originalIcon = new ImageIcon("D:\\Github\\Java_Programming\\JavaProject\\src\\images\\logo.png");
 
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
        hello.setText("Hello,");
        hello.setFont(new Font("Alba Matter", Font.ITALIC, 30));
        hello.setForeground(Color.decode("#DFEEEA"));
        hello.setBounds(800,30,100,100);
        

        JLabel lbLogout = new JLabel();
		ImageIcon iconLogout = new ImageIcon("D:\\Github\\Java_Programming\\JavaProject\\src\\images\\power-off.png");
		lbLogout.setIcon(iconLogout);
		lbLogout.setForeground(Color.decode("#DFEEEA"));
		lbLogout.setBounds(1050, 40, iconLogout.getIconWidth(), iconLogout.getIconHeight());
		
		JLabel test = new JLabel("test");
		
		pn1 = new JPanel();
		pn1.setLayout(new FlowLayout());
		pn1.setBounds(500,0,200, 120);
		pn1.setBackground(Color.black);
		
		pn1.add(test);

        mainHeader.add(title);
        mainHeader.add(icon);
        mainHeader.add(hello);
        mainHeader.add(lbLogout);
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
		ImageIcon iconEmployee = new ImageIcon("D:\\Github\\Java_Programming\\JavaProject\\src\\images\\employee.png");
		btnEmployee.setIcon(iconEmployee);
		btnEmployee.setFocusable(false);
		btnEmployee.setHorizontalTextPosition(JButton.CENTER);
		btnEmployee.setVerticalTextPosition(JButton.BOTTOM);
		btnEmployee.setFont(new Font("Keyes", Font.BOLD, 20));
		btnEmployee.setBackground(Color.decode("#5E8B7E"));
		btnEmployee.setForeground(Color.decode("#F6E7D8"));
		btnEmployee.addActionListener(this);
		
		btnCustomer = new JButton("Customer");
		ImageIcon iconCustomer = new ImageIcon("D:\\Github\\Java_Programming\\JavaProject\\src\\images\\customer.png");
		btnCustomer.setIcon(iconCustomer);
		btnCustomer.setFocusable(false);
		btnCustomer.setHorizontalTextPosition(JButton.CENTER);
		btnCustomer.setVerticalTextPosition(JButton.BOTTOM);
		btnCustomer.setFont(new Font("Keyes", Font.BOLD, 20));
		btnCustomer.setBackground(Color.decode("#5E8B7E"));
		btnCustomer.setForeground(Color.decode("#F6E7D8"));

		btnMerchandise = new JButton("Merchandise");
		ImageIcon iconMerchandise = new ImageIcon("D:\\Github\\Java_Programming\\JavaProject\\src\\images\\laptop.png");
		btnMerchandise.setIcon(iconMerchandise);
		btnMerchandise.setFocusable(false);
		btnMerchandise.setHorizontalTextPosition(JButton.CENTER);
		btnMerchandise.setVerticalTextPosition(JButton.BOTTOM);
		btnMerchandise.setFont(new Font("Keyes", Font.BOLD, 20));
		btnMerchandise.setBackground(Color.decode("#5E8B7E"));
		btnMerchandise.setForeground(Color.decode("#F6E7D8"));

		btnReceipt = new JButton("Receipt");
		ImageIcon iconReceipt = new ImageIcon("D:\\Github\\Java_Programming\\JavaProject\\src\\images\\bill.png");
		btnReceipt.setIcon(iconReceipt);
		btnReceipt.setFocusable(false);
		btnReceipt.setHorizontalTextPosition(JButton.CENTER);
		btnReceipt.setVerticalTextPosition(JButton.BOTTOM);
		btnReceipt.setFont(new Font("Keyes", Font.BOLD, 20));
		btnReceipt.setBackground(Color.decode("#5E8B7E"));
		btnReceipt.setForeground(Color.decode("#F6E7D8"));
		

		mainHome.add(btnEmployee);
		mainHome.add(btnCustomer);
		mainHome.add(btnMerchandise);
		mainHome.add(btnReceipt);
		
		add(mainHome);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnEmployee) {
			EmployeeGUI emp = new EmployeeGUI();
			add(emp);
			emp.setBounds(150,120,emp.getWidth(),emp.getHeight());
		}
	}

}

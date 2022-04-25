package GUI;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeGUI extends JPanel {
	JLabel lbId, lbName, lbUsername, lbPassword, lbPhone, lbType;
	JTextField tfId, tfName, tfUsername, tfPassword, tfPhone;
	JComboBox cbType;
	JPanel pn1;
	
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	public EmployeeGUI() {
		initGUI();
	}
	
	private void initGUI() {
		setSize(1050,630);
		setLayout(null);
		initComponents();
		setBackground(Color.decode("#DFEEEA"));
	}
	
	private void initComponents() {
		lbId = new JLabel("Id");
		lbId.setFont(new Font("Verdana", Font.BOLD, 20));
		lbId.setBounds(70, 50, 100, 25);
		
		tfId = new JTextField();
		tfId.setBounds(150, 50, 150, 25);
		
		lbName = new JLabel("Name");
		lbName.setFont(new Font("Verdana", Font.BOLD, 20));
		lbName.setBounds(70, 100, 100, 25);
		
		tfName = new JTextField();
		tfName.setBounds(150, 100, 150, 25);
		
		lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Verdana", Font.BOLD, 20));
		lbUsername.setBounds(320, 50, 120, 25);

		tfUsername = new JTextField();
		tfUsername.setBounds(450, 50, 150, 25);
		
		lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Verdana", Font.BOLD, 20));
		lbPassword.setBounds(320, 100, 120, 25);

		tfPassword = new JTextField();
		tfPassword.setBounds(450, 100, 150, 25);
		
		lbPhone = new JLabel("Phone");
		lbPhone.setFont(new Font("Verdana", Font.BOLD, 20));
		lbPhone.setBounds(670, 50, 100, 25);

		tfPhone = new JTextField();
		tfPhone.setBounds(750, 50, 150, 25);
		
		lbType = new JLabel("Type");
		lbType.setFont(new Font("Verdana", Font.BOLD, 20));
		lbType.setBounds(670, 100, 100, 25);
		
		cbType = new JComboBox();
		cbType.setBounds(750, 100, 150, 25);
		

//		tb.setPreferredScrollableViewportSize(new Dimension(500,200));
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Phone");
		model.addColumn("Type");
		
		JScrollPane sp = new JScrollPane(tb);
		sp.setBounds(70, 150, 700, 400);
		
		add(lbId);
		add(tfId);
		add(lbName);
		add(tfName);
		add(lbUsername);
		add(tfUsername);
		add(lbPassword);
		add(tfPassword);
		add(lbPhone);
		add(tfPhone);
		add(lbType);
		add(cbType);
		add(sp);
		
	}
}

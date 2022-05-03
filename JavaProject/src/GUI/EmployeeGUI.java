package GUI;

import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DTO.Employee;
import BUS.EmployeeBUS;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;

public class EmployeeGUI extends JPanel implements ActionListener {
	JLabel lbId, lbName, lbUsername, lbPassword, lbPhone, lbType, lbGender, lbAddress, lbBirth;
	JTextField tfId, tfName, tfUsername, tfPassword, tfPhone, tfAddress;
	JComboBox cbType, cbGender;
	JPanel pn1, pnBtn;
	JDateChooser calBirth;
	JButton btnAdd, btnUpd, btnDel;
	String gender[] = {"Male", "Female"};
	String type[] = {"Admin","Sale"};
			
	
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	EmployeeBUS empBUS = new EmployeeBUS();
	
	public EmployeeGUI() {
		initGUI();
	}
	
	private void initGUI() {
		setSize(1050,630);
		setLayout(null);
		
		initComponents();
		loadEmployeeList();
		
		setBackground(Color.decode("#DFEEEA"));
	}
	
	private void initComponents() {
		lbId = new JLabel("Id");
		lbId.setFont(new Font("Verdana", Font.BOLD, 15));
		lbId.setBounds(70, 60, 100, 25);
		
		tfId = new JTextField();
		tfId.setBounds(150, 60, 150, 25);
		
		lbName = new JLabel("Name");
		lbName.setFont(new Font("Verdana", Font.BOLD, 15));
		lbName.setBounds(70, 110, 100, 25);
		
		tfName = new JTextField();
		tfName.setBounds(150, 110, 150, 25);
		
		lbBirth = new JLabel("Birth");
		lbBirth.setFont(new Font("Verdana", Font.BOLD, 15));
		lbBirth.setBounds(70, 160, 100, 25);;
		
		calBirth = new JDateChooser();
		calBirth.setBounds(150, 160, 150, 25);
		calBirth.setDateFormatString("d/MM/yyyy");
		calBirth.setBounds(150, 160, 150, 25);
	    
		lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Verdana", Font.BOLD, 15));
		lbUsername.setBounds(320, 60, 120, 25);

		tfUsername = new JTextField();
		tfUsername.setBounds(450, 60, 150, 25);
		
		lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Verdana", Font.BOLD, 15));
		lbPassword.setBounds(320, 110, 120, 25);

		tfPassword = new JTextField();
		tfPassword.setBounds(450, 110, 150, 25);
		
		lbAddress = new JLabel("Address");
		lbAddress.setFont(new Font("Verdana", Font.BOLD, 15));
		lbAddress.setBounds(320, 160, 120, 25);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(450, 160, 150, 25);
		
		lbPhone = new JLabel("Phone");
		lbPhone.setFont(new Font("Verdana", Font.BOLD, 15));
		lbPhone.setBounds(670, 60, 100, 25);

		tfPhone = new JTextField();
		tfPhone.setBounds(755, 60, 150, 25);
		
		lbType = new JLabel("Type");
		lbType.setFont(new Font("Verdana", Font.BOLD, 15));
		lbType.setBounds(670, 110, 100, 25);
		
		cbType = new JComboBox(type);
		cbType.setBounds(755, 110, 150, 25);
		
		lbGender = new JLabel("Gender");
		lbGender.setFont(new Font("Verdana", Font.BOLD, 15));
		lbGender.setBounds(670, 160, 100, 25);

		cbGender = new JComboBox(gender);
		cbGender.setBounds(755, 160, 100, 25);
		
		

		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Gender");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Address");
		model.addColumn("Phone");
		model.addColumn("Type");
		
		
		JScrollPane sp = new JScrollPane(tb);
		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int i = tb.getSelectedRow();
				if(i>=0) {
					tfId.setText(model.getValueAt(i, 0).toString());
					tfName.setText(model.getValueAt(i, 1).toString());
//					cbGender.setPrototypeDisplayValue(model.getValueAt(i, 2));
					tfUsername.setText(model.getValueAt(i, 3).toString());
					tfPassword.setText(model.getValueAt(i, 4).toString());
					tfAddress.setText(model.getValueAt(i, 5).toString());
					tfPhone.setText(model.getValueAt(i, 6).toString());
//					cbType.setPrototypeDisplayValue(model.getValueAt(i, 7));
				}
			}
			
		});
		sp.setBounds(70, 250, 700, 300);
		
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Keyes", Font.BOLD, 20));
		btnAdd.setBounds(820, 280, 150, 50);
		btnAdd.addActionListener(this);
		btnUpd = new JButton("Update");
		btnUpd.setFont(new Font("Keyes", Font.BOLD, 20));
		btnUpd.setBounds(820, 380, 150, 50);
		btnUpd.addActionListener(this);
		btnDel = new JButton("Delete");
		btnDel.setFont(new Font("Keyes", Font.BOLD, 20));
		btnDel.setBounds(820, 480, 150, 50);
		btnDel.addActionListener(this);
		
		add(lbId);
		add(tfId);
		add(lbName);
		add(tfName);
//		add(lbBirth);
//		add(calBirth);
		add(lbUsername);
		add(tfUsername);
		add(lbPassword);
		add(tfPassword);
		add(lbAddress);
		add(tfAddress);
		add(lbPhone);
		add(tfPhone);
		add(lbType);
		add(cbType);
		add(lbGender);
		add(cbGender);
		add(sp);
		add(btnAdd);
		add(btnUpd);
		add(btnDel);	
	}
	
	public void loadEmployeeList() {
		model.setRowCount(0);
		ArrayList<Employee> arr = new ArrayList<Employee>();
		arr = empBUS.getAllEmployee();
		for(int i=0; i < arr.size(); i++) {
			Employee emp = arr.get(i);
			String id = emp.getId();
			String fullName = emp.getFullName();
			String username = emp.getUsername();
			String password = emp.getPassword();
			String phone = emp.getPhone();
			String type = emp.getType();
			String gender = emp.getGender();
			String address = emp.getAddress();
			Object[] row = {id,fullName,gender,username,password,address,phone,type};
			model.addRow(row);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAdd) {
			
		}
	}
}

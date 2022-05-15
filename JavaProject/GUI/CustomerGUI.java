package GUI;

import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DTO.Customer;
import DTO.Employee;
import BUS.CustomerBUS;
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

public class CustomerGUI extends JPanel implements ActionListener {
	JLabel lbId, lbName, lbPhone, lbEmail, lbGender, lbAddress, lbSearch, lbTitle;
	JTextField tfId, tfName, tfEmail, tfPhone, tfAddress, toolSearch;
	JComboBox cbGender;
	JPanel pn1, pnBtn;
	JButton btnAdd, btnUpd, btnDel, btnClear;
	String gender[] = {"Male", "Female"};
			
	
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	CustomerBUS cusBUS = new CustomerBUS();
	
	public CustomerGUI() {
		initGUI();
	}
	
	private void initGUI() {
		setSize(1050,630);
		setLayout(null);
		
		initComponents();
		loadCustomerList();
		
		setBackground(Color.decode("#DFEEEA"));
	}
	
	private void initComponents() {
		lbTitle = new JLabel("Customer:");
		lbTitle.setFont(new Font("AddElectricCity", Font.BOLD,30));
		lbTitle.setBounds(20, 15, 250, 30);
		
		toolSearch = new JTextField();
		toolSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nameSearch = toolSearch.getText();
				if(nameSearch.equals("")) {
					loadCustomerList();
				} else {
					loadCustomerSearch(nameSearch);
				}
			}
		});
		toolSearch.setBounds(300, 15, 400, 25);
		
		lbSearch = new JLabel();
		lbSearch.setIcon(new ImageIcon(this.getClass().getResource("/images/magnifier.png")));
		lbSearch.setBounds(710, -20, 100, 100);
		
		
		lbId = new JLabel("Id");
		lbId.setFont(new Font("Verdana", Font.BOLD, 15));
		lbId.setBounds(70, 100, 100, 25);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(150, 100, 150, 25);
		
		lbName = new JLabel("Name");
		lbName.setFont(new Font("Verdana", Font.BOLD, 15));
		lbName.setBounds(70, 150, 100, 25);
		
		tfName = new JTextField();
		tfName.setBounds(150, 150, 150, 25);
	    
		lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Verdana", Font.BOLD, 15));
		lbEmail.setBounds(320, 100, 120, 25);

		tfEmail = new JTextField();
		tfEmail.setBounds(450, 100, 150, 25);
		
		lbAddress = new JLabel("Address");
		lbAddress.setFont(new Font("Verdana", Font.BOLD, 15));
		lbAddress.setBounds(320, 150, 100, 25);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(450, 150, 150, 25);
		
		lbPhone = new JLabel("Phone");
		lbPhone.setFont(new Font("Verdana", Font.BOLD, 15));
		lbPhone.setBounds(670, 100, 100, 25);

		tfPhone = new JTextField();
		tfPhone.setBounds(755, 100, 150, 25);
		
		lbGender = new JLabel("Gender");
		lbGender.setFont(new Font("Verdana", Font.BOLD, 15));
		lbGender.setBounds(670, 150, 120, 25);

		cbGender = new JComboBox(gender);
		cbGender.setBounds(755, 150, 150, 25);

		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Gender");
		model.addColumn("Address");
		model.addColumn("Phone");
		model.addColumn("Email");
		
		
		JScrollPane sp = new JScrollPane(tb);
		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tfId.setEditable(false);
				int i = tb.getSelectedRow();
				if(i>=0) {
					tfId.setText(model.getValueAt(i, 0).toString());
					tfName.setText(model.getValueAt(i, 1).toString());
					tfAddress.setText(model.getValueAt(i, 3).toString());
					tfPhone.setText(model.getValueAt(i, 4).toString());
					tfEmail.setText(model.getValueAt(i, 5).toString());
				}
			}
			
		});
		sp.setBounds(70, 250, 700, 300);
		
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Keyes", Font.BOLD, 20));
		btnAdd.setFocusable(false);
		btnAdd.setBackground(Color.decode("#A7C4BC"));
		btnAdd.setBounds(820, 280, 150, 50);
		btnAdd.addActionListener(this);
		
		btnUpd = new JButton("Update");
		btnUpd.setFont(new Font("Keyes", Font.BOLD, 20));
		btnUpd.setFocusable(false);
		btnUpd.setBackground(Color.decode("#A7C4BC"));
		btnUpd.setBounds(820, 380, 150, 50);
		btnUpd.addActionListener(this);
		
		btnDel = new JButton("Delete");
		btnDel.setFont(new Font("Keyes", Font.BOLD, 20));
		btnDel.setFocusable(false);
		btnDel.setBackground(Color.decode("#A7C4BC"));
		btnDel.setBounds(820, 480, 150, 50);
		btnDel.addActionListener(this);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Keyes", Font.BOLD, 15));
		btnClear.setFocusable(false);
		btnClear.setBackground(Color.decode("#A7C4BC"));
		btnClear.setBounds(755, 200, 100, 30);
		btnClear.addActionListener(this);
		
		
		add(lbTitle);
		add(toolSearch);
		add(lbSearch);
		add(lbId);
		add(tfId);
		add(lbName);
		add(tfName);
		add(lbEmail);
		add(tfEmail);
//		add(lbBirth);
//		add(calBirth);
		add(lbAddress);
		add(tfAddress);
		add(lbPhone);
		add(tfPhone);
		add(lbGender);
		add(cbGender);
		add(sp);
		add(btnAdd);
		add(btnUpd);
		add(btnDel);	
		add(btnClear);
	}
	
	public void loadCustomerList() {
		model.setRowCount(0);
		ArrayList<Customer> arr = new ArrayList<Customer>();
		arr = cusBUS.getAllCustomer();
		for(int i=0; i < arr.size(); i++) {
			Customer cus = arr.get(i);
			String id = cus.getId();
			String fullName = cus.getFullName();
			String phone = cus.getPhone();
			String email = cus.getEmail();
			String address = cus.getAddress();
			String gender = cus.getGender();
			Object[] row = {id,fullName,gender,address,phone,email};
			model.addRow(row);
		}
	}
	
	public void loadCustomerSearch(String nameSearch) {
		model.setRowCount(0);
		ArrayList<Customer> arr = new ArrayList<Customer>();
		if(!cusBUS.getByFullNameSearch(nameSearch).isEmpty()) {
			arr = cusBUS.getByFullNameSearch(nameSearch);
		} else if(!cusBUS.getByIdSearch(nameSearch).isEmpty()) {
			arr = cusBUS.getByIdSearch(nameSearch);
		} else if(!cusBUS.getByPhoneSearch(nameSearch).isEmpty()) {
			arr = cusBUS.getByPhoneSearch(nameSearch);
		}
		
		for(int i=0; i < arr.size(); i++) {
			Customer cus = arr.get(i);
			String id = cus.getId();
			String fullName = cus.getFullName();
			String phone = cus.getPhone();
			String email = cus.getEmail();
			String address = cus.getAddress();
			String gender = cus.getGender();
			Object[] row = {id,fullName,gender,address,phone,email};
			model.addRow(row);
		}
	}
	
	public boolean checkNull(String string) {
		if(string != null && !string.trim().equals("")) {
			return true;
		} else return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAdd) {
			try {
				tfId.setEditable(true);
				if(checkNull(tfId.getText()) && checkNull(tfName.getText())  && checkNull(tfEmail.getText()) && checkNull(tfPhone.getText()) && checkNull(tfAddress.getText())) {
					Customer cus = new Customer();
					cus.setId(tfId.getText());
					cus.setFullName(tfName.getText());
					cus.setPhone(tfPhone.getText());
					
					String gender = (String)cbGender.getSelectedItem();
					cus.setGender(gender);
					
					cus.setAddress(tfAddress.getText());
					cus.setEmail(tfEmail.getText());
					JOptionPane.showMessageDialog(this, cusBUS.addCustomer(cus));
					tfId.setText("");
					tfName.setText("");
					tfPhone.setText("");
					tfAddress.setText("");
					tfEmail.setText("");
					loadCustomerList();
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
				}
			} catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
			}
		}
		
		if(e.getSource() == btnUpd) {
			try {
				if(checkNull(tfName.getText()) && checkNull(tfEmail.getText()) && checkNull(tfPhone.getText()) && checkNull(tfAddress.getText())) {
					Customer cus = new Customer();
					cus.setId(tfId.getText());
					cus.setFullName(tfName.getText());
					cus.setPhone(tfPhone.getText());
					
					String gender = (String)cbGender.getSelectedItem();
					cus.setGender(gender);
					
					cus.setAddress(tfAddress.getText());
					cus.setEmail(tfEmail.getText());
					JOptionPane.showMessageDialog(this, cusBUS.updateCustomer(cus));
					tfId.setText("");
					tfName.setText("");
					tfPhone.setText("");
					tfAddress.setText("");
					tfEmail.setText("");
					loadCustomerList();
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
				}
			} catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
			}
		}
		if(e.getSource() == btnDel) {
			int i = tb.getSelectedRow();
			String id = (String) model.getValueAt(i, 0);
			if(i>=0) {
				JOptionPane.showMessageDialog(this, cusBUS.deleterCustomer(id));
				loadCustomerList();
				tfId.setText("");
				tfName.setText("");
				tfPhone.setText("");
				tfAddress.setText("");
				tfEmail.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Xóa thất bại");
			}
		}
		
		if(e.getSource() == btnClear) {
			tfId.setText("");
			tfName.setText("");
			tfPhone.setText("");
			tfAddress.setText("");
			tfEmail.setText("");
		}
		
	}
}

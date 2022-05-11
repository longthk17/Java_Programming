package GUI;

import DTO.Customer;
import DTO.Employee;
import DTO.Merchandise;
import DTO.Receipt;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.ReceiptDetailBUS;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ReceiptDetailGUI extends JFrame implements ActionListener {

	private JPanel pn;
	private JLabel lbTitle, lbSubTitle, lbIdReceipt, lbCurDate, lbCusName, txtCusName, lbCusId, lbCusContact, 
	lbMerId, lbMerName, lbMerProc, lbQuant, lbTotal, lb_tkt, lb_td, txtIdReceipt, txtCurDate, txtCusId, txtCusContact, txtMerId, txtMerName, txtMerProc;
	private JTextField textField_1, txtTmKimSn;
	private JButton btaddkh, btfind, bt_addhd, bt_check, bt_can;
	private JSpinner spinner;
	private JComboBox cbCus, cbMer;
	
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	Employee curEmp;
	Merchandise chooseMer;
	Customer chooseCus;
	
	ReceiptDetailBUS recDetailBUS = new ReceiptDetailBUS();
	
	String curMhd;
	
	public void date() {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y");
		txtCurDate.setText(dateForm.format(thisDate));
	}
	
	public ReceiptDetailGUI(String mhd, Employee emp, Customer cus) {
		this.curMhd = mhd;
		this.curEmp = emp;
		this.chooseCus = cus;
		initGUI();
		date();
	}
	
	private void initGUI() {
		setTitle("RECEIPT");
		
		initComponents();
		
		setBounds(0,0,1050,630);
		getContentPane().setLayout(null);
		setResizable(false);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(false);
	}	

	
	private void initComponents() {	
		pn = new JPanel();
		pn.setBounds(0, 0, 1050, 630);
		pn.setBackground(Color.decode("#DFEEEA"));
		pn.setLayout(null);
		
		lbTitle = new JLabel("RECEIPT");
		lbTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbTitle.setBounds(459, 10, 114, 29);
		
		lbSubTitle = new JLabel("Th\u00F4ng tin h\u00F3a \u0111\u01A1n");
		lbSubTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbSubTitle.setBounds(52, 45, 154, 20);
		
		lbIdReceipt = new JLabel("ID Receit: ");
		lbIdReceipt.setBounds(102, 89, 83, 20);
		lbIdReceipt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtIdReceipt = new JLabel("");
		txtIdReceipt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdReceipt.setText(curMhd);
		txtIdReceipt.setBounds(223, 84, 85, 29);
		
		
		lbCurDate = new JLabel("Date founded:");
		lbCurDate.setBounds(102, 119, 98, 20);
		lbCurDate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtCurDate = new JLabel("");
		txtCurDate.setBounds(244, 115, 134, 29);
		txtCurDate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lbCusName = new JLabel("Customer:");
		lbCusName.setBounds(102, 149, 119, 20);
		lbCusName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtCusName = new JLabel();
		txtCusName.setBounds(238, 149, 174, 19);
		txtCusName.setText(chooseCus.getFullName());

//		cbCus = new JComboBox();
//		ArrayList<Customer> cusData = recDetailBUS.getAllCustomer();
//		for(int i = 0; i < cusData.size(); i++) {
//			cbCus.addItem(cusData.get(i).getFullName());
//		}
//		cbCus.setBounds(238, 149, 174, 19);
//		cbCus.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// TODO Auto-generated method stub
//				chooseCus = recDetailBUS.getByFullName(cbCus.getSelectedItem().toString());
//				txtCusId.setText(chooseCus.getId());
//				txtCusContact.setText(chooseCus.getAddress() + " - " + chooseCus.getPhone());
//			}
//		});
		
		lbCusId = new JLabel("Choose Customer:");
		lbCusId.setBounds(102, 179, 134, 20);
		lbCusId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtCusId = new JLabel();
		txtCusId.setBounds(238, 179, 174, 19);
		txtCusId.setText(chooseCus.getId());
		
		lbCusContact = new JLabel("Contact Address:");
		lbCusContact.setBounds(102, 209, 119, 20);
		lbCusContact.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtCusContact = new JLabel();
		txtCusContact.setBounds(238, 209, 119, 20);
		txtCusContact.setText(chooseCus.getAddress() + " - " + chooseCus.getPhone());
		
//		textField_1 = new JTextField();
//		textField_1.setBounds(238, 149, 174, 19);
//		textField_1.setColumns(10);
		
		/*Choice choice_1 = new Choice();
		choice_1.setBounds(238, 181, 174, 18);
		add(choice_1);*/
		
//		btaddkh = new JButton("Add");
//		btaddkh.setBounds(422, 149, 68, 21);
//		btaddkh.setBackground(Color.decode("#A7C4BC"));
//		btaddkh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
//		txtTmKimSn = new JTextField();
//		txtTmKimSn.setBounds(628, 89, 195, 19);
//		txtTmKimSn.setText("T\u00ECm ki\u1EBFm s\u1EA3n ph\u1EA9m");
//		txtTmKimSn.setColumns(10);

		cbMer = new JComboBox();
		ArrayList<Merchandise> merData = recDetailBUS.getAllMerchandise();
		for(int i = 0; i < merData.size(); i++) {
			cbMer.addItem(merData.get(i).getMerchandiseName());
		}
		cbMer.setBounds(628, 89, 195, 19);
		cbMer.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				chooseMer = recDetailBUS.getByMerchandiseName(cbMer.getSelectedItem().toString());
				txtMerId.setText(chooseMer.getId());
				txtMerName.setText(chooseMer.getMerchandiseName());
				txtMerProc.setText(chooseMer.getProducer());
			}
		});
		
//		btfind = new JButton("Search");
//		btfind.setBounds(850, 88, 77, 21);
//		btfind.setBackground(Color.decode("#A7C4BC"));
//		btfind.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lbMerId = new JLabel("ID: ");
		lbMerId.setBounds(573, 119, 98, 20);
		lbMerId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtMerId = new JLabel();
		txtMerId.setBounds(729, 119, 98, 20);
		
		lbMerName = new JLabel("Merchandise Name:");
		lbMerName.setBounds(573, 149, 154, 20);
		lbMerName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtMerName = new JLabel();
		txtMerName.setBounds(729, 149, 98, 20);
		
		lbMerProc = new JLabel("Producer:");
		lbMerProc.setBounds(573, 179, 85, 20);
		lbMerProc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtMerProc = new JLabel();
		txtMerProc.setBounds(729, 179, 98, 20);
		
		lbQuant = new JLabel("Quantity:");
		lbQuant.setBounds(573, 209, 68, 20);
		lbQuant.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		spinner = new JSpinner();
		spinner.setBounds(670, 211, 46, 20);
		
		bt_addhd = new JButton("Add To Receipt");
		bt_addhd.setBounds(775, 229, 167, 32);
		bt_addhd.setBackground(Color.decode("#A7C4BC"));
		bt_addhd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bt_addhd.addActionListener(this);
		
		lbTotal = new JLabel("Total Price:");
		lbTotal.setBounds(388, 504, 119, 20);
		lbTotal.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_tkt = new JLabel("Ti\u1EC1n kh\u00E1ch tr\u1EA3: ");
		lb_tkt.setBounds(597, 504, 119, 20);
		lb_tkt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_td = new JLabel("Ti\u1EC1n d\u01B0:");
		lb_td.setBounds(823, 504, 119, 20);
		lb_td.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		bt_check = new JButton("Checkout");
		bt_check.setBounds(833, 534, 114, 36);
		bt_check.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		bt_check.setBackground(Color.decode("#A7C4BC"));
		bt_check.addActionListener(this);
		
		bt_can = new JButton("Cancel");
		bt_can.setBounds(732, 534, 88, 36);
		bt_can.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		bt_can.setBackground(Color.decode("#A7C4BC"));
		bt_can.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				bt_canActionPerformed(e);
			}
		});
		
//		model.addColumn("STT");
		model.addColumn("ID Receipt");
		model.addColumn("Merchandise Name");
		model.addColumn("Porducer");
		model.addColumn("Quantity");
		model.addColumn("Price Of Each");
		model.addColumn("Total");
		
		JScrollPane spp = new JScrollPane(tb);
		spp.setBounds(102, 271, 842, 202);
		
		
		getContentPane().add(pn);
		pn.add(lbTitle);
		pn.add(lbSubTitle);
		pn.add(lbIdReceipt);
		pn.add(txtIdReceipt);
		pn.add(lbCurDate);
		pn.add(txtCurDate);
		pn.add(lbCusName);
		pn.add(lbCusId);
		pn.add(txtCusId);
		pn.add(lbCusContact);
		pn.add(txtCusContact);
//		pn.add(textField_1);
//		pn.add(cbCus);
		pn.add(txtCusName);
//		pn.add(btaddkh);
//		pn.add(txtTmKimSn);
		pn.add(cbMer);
//		pn.add(btfind);
		pn.add(lbMerId);
		pn.add(txtMerId);
		pn.add(lbMerName);
		pn.add(txtMerName);
		pn.add(lbMerProc);
		pn.add(txtMerProc);
		pn.add(lbQuant);
		pn.add(spinner);
		pn.add(bt_addhd);
		pn.add(lbTotal);
		pn.add(lb_tkt);
		pn.add(lb_td);
		pn.add(bt_check);
		pn.add(bt_can);
		pn.add(spp);
	}

	private void bt_canActionPerformed(ActionEvent e) {
		if(e.getSource() == bt_can) {
			if(recDetailBUS.deleteOrder(curMhd)) {
				JOptionPane.showMessageDialog(this, "Hủy thành công");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				JOptionPane.showMessageDialog(this, "Hủy thất bại");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bt_check) {
			System.out.println(chooseCus.getAddress());
		}
		if(e.getSource() == bt_addhd) {
			int chooseQuant = (Integer) spinner.getValue();
			if(chooseMer!=null && chooseCus!=null && chooseQuant>0) {
				int inventory = recDetailBUS.compareInventory(txtMerId.getText());
				if(chooseQuant <= inventory) {
					String cusId = chooseCus.getId();
					JOptionPane.showMessageDialog(this, recDetailBUS.addOrder(curEmp, chooseMer, cusId, curMhd, chooseQuant));
				} else {
					JOptionPane.showMessageDialog(this, "Số lượng đặt lớn hơn số lượng tồn");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Mời chọn thông tin");
			}
		}
	}

}

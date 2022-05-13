package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import BUS.ReceiptBUS;
import BUS.ReceiptDetailBUS;
import DTO.Customer;
import DTO.Employee;
import DTO.Receipt;

public class ReceiptGUI extends JPanel implements ActionListener {
	private JPanel pn;
	private JTable table;
	private JLabel lb_1, lb_cus, lb_mhd, lbb_mhd;
	private JButton btnew, btadd, btdel, btclear;
	private JComboBox cbCus;
	
	Employee curEmp;
	Customer chooseCus;
	
	private JComboBox comboBoxCus;
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	String recId;
	
	ReceiptDetailBUS recDetailBUS = new ReceiptDetailBUS();
	ReceiptBUS recBUS = new ReceiptBUS();
	
	public ReceiptGUI() {
		initGUI();
	}
	
	public ReceiptGUI(Employee emp) {
		this.curEmp = emp;
		initGUI();
	}

	private void initGUI() {
		setSize(1050,630);
		setLayout(null);
		initComponents();
		loadReceiptList();
		setBackground(Color.decode("#DFEEEA"));
		
		
		
		
	}
	
	private void initComponents() {	
		pn = new JPanel();
		pn.setBounds(191, 116, 1050, 630);
		pn.setBackground(Color.decode("#DFEEEA"));
		pn.setLayout(null);
		
		lb_1 = new JLabel("Manage Receipts");
		lb_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lb_1.setBounds(423, 28, 215, 41);
		
		lb_cus = new JLabel("Choose Customer:");
		lb_cus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lb_cus.setBounds(794, 101, 150, 21);
		
		comboBoxCus = new JComboBox();
		comboBoxCus.setBounds(779, 134, 234, 26);
		
		lb_mhd = new JLabel("ID Receipt:");
		lb_mhd.setBounds(794, 180, 107, 21);
		lb_mhd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lbb_mhd = new JLabel("");
		lbb_mhd.setBounds(896, 170, 107, 41);
		lbb_mhd.setFont(new Font("Times New Roman", Font.BOLD, 26));
		
		btnew = new JButton("New");
		btnew.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnew.setBounds(834, 223, 131, 54);
		btnew.setBackground(Color.decode("#A7C4BC"));
		btnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnew) {
					Random r = new Random();
					int x = r.nextInt(1000)+1;
					lbb_mhd.setText("HD" + x);
				}
			}
		});
		// btnew.addActionListener(this);
		
		btadd = new JButton("Add");
		btadd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btadd.setBounds(834, 301, 131, 54);
		btadd.setBackground(Color.decode("#A7C4BC"));
		btadd.addActionListener(this);
		
		btdel = new JButton("Delete");
		btdel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btdel.setBounds(834, 381, 131, 54);
		btdel.setBackground(Color.decode("#A7C4BC"));
		btdel.addActionListener(this);
		
		cbCus = new JComboBox();
		ArrayList<Customer> cusData = recDetailBUS.getAllCustomer();
		for(int i = 0; i < cusData.size(); i++) {
			cbCus.addItem(cusData.get(i).getFullName());
		}
		cbCus.setBounds(779, 134, 234, 26);
		cbCus.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				chooseCus = recDetailBUS.getByFullName(cbCus.getSelectedItem().toString());
			}
		});
		btclear = new JButton("Clear");
		btclear.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btclear.setBounds(834, 459, 131, 54);
		btclear.setBackground(Color.decode("#A7C4BC"));
		btclear.addActionListener(this);
		
		model.addColumn("ID");
		model.addColumn("Employe name");
		model.addColumn("Customer name");
		model.addColumn("Create date");
		model.addColumn("Update date");
		
		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int i = tb.getSelectedRow();
				if(i>=0) {
					recId = model.getValueAt(i, 0).toString();
				}
			}
		});
		
		JScrollPane sp = new JScrollPane(tb);
		sp.setBounds(52, 105, 706, 438);
			
		add(lb_1);
		add(lb_cus);
//		add(comboBoxCus);
		add(lb_mhd);
		add(lbb_mhd);
		add(sp);
		add(btnew);
		add(btadd);
		add(btdel);
		add(btclear);
		add(cbCus);
	}
	
	public void loadReceiptList() {
		model.setRowCount(0);
		ArrayList<Receipt> arr = new ArrayList<Receipt>();
		arr = recBUS.getAllReceipt();
		for(int i=0; i<arr.size(); i++) {
			Receipt rec = arr.get(i);
			String id = rec.getId();
			String empName = rec.getEmployeeId();
			String cusName = rec.getCustomerId();
			java.sql.Date createDate = rec.getCreateDate();
			java.sql.Date updateDate = rec.getUpdateDate();
			Object[] row = {id,empName,cusName,createDate,updateDate};
			model.addRow(row);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnew) {
			Random r = new Random();
			int x = r.nextInt(1000)+1;
			lbb_mhd.setText("HD" + x);		
		}
		if(e.getSource() == btadd) {
			String hd = lbb_mhd.getText();
			if(hd != null && chooseCus != null) {
				String cusId = chooseCus.getId();
				JOptionPane.showMessageDialog(this, recBUS.addReceipt(curEmp, cusId, hd));
				ReceiptDetailGUI re = new ReceiptDetailGUI(hd,curEmp,chooseCus);
				re.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Chưa tạo mã hóa đơn hoặc chưa chọn thông tin khách hàng!");
			}
		}
		if(e.getSource() == btdel) {
			recBUS.deleteReceipt(recId);
			loadReceiptList();
		}
		if(e.getSource() == btclear) {
			
		}
	}
}

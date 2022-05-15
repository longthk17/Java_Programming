package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import BUS.CustomerBUS;
import BUS.EmployeeBUS;
import BUS.ReceiptBUS;
import BUS.ReceiptDetailBUS;
import DTO.Customer;
import DTO.Employee;
import DTO.Merchandise;
import DTO.Receipt;
import DTO.ReceiptDetail;

public class ReceiptGUI extends JPanel implements ActionListener {
	private JPanel pn;
	private JTable table;
	private JLabel lb_1, lb_cus, lb_mhd, lbb_mhd, lbTotal, txtTotal, lbSearch;
	private JTextField toolSearch;
	private JButton btnew, btadd, btdel, btnDetail;
	private JComboBox cbCus;
	
	Employee curEmp;
	Customer chooseCus;
	
	private JComboBox comboBoxCus;
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	String recId;
	
	ReceiptDetailBUS recDetailBUS = new ReceiptDetailBUS();
	ReceiptBUS recBUS = new ReceiptBUS();
	CustomerBUS cusBUS = new CustomerBUS();
	EmployeeBUS empBUS = new EmployeeBUS();
	
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
		lb_1.setFont(new Font("AddElectricCity", Font.BOLD, 30));
		lb_1.setBounds(323, 20, 450, 41);
		
		toolSearch = new JTextField();
		toolSearch.setBounds(280, 65, 400, 25);
		toolSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nameSearch = toolSearch.getText();
				if(nameSearch.equals("")) {
					loadReceiptList();
				} else {
					loadReceiptListSearch(nameSearch);
				}
			}			
		});
		
		lbSearch = new JLabel();
		lbSearch.setIcon(new ImageIcon(this.getClass().getResource("/images/magnifier.png")));
		lbSearch.setBounds(690, 25, 100, 100);
		
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
		ArrayList<Customer> cusData = cusBUS.getAllCustomer();
		for(int i = 0; i < cusData.size(); i++) {
			cbCus.addItem(cusData.get(i).getFullName());
		}
		cbCus.setBounds(779, 134, 234, 26);
		cbCus.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				chooseCus = cusBUS.getByFullName(cbCus.getSelectedItem().toString());
			}
		});
		btnDetail = new JButton("Detail");
		btnDetail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDetail.setBounds(834, 459, 131, 54);
		btnDetail.setBackground(Color.decode("#A7C4BC"));
		btnDetail.addActionListener(this);
		
		lbTotal = new JLabel("Total: ");
		lbTotal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbTotal.setBounds(52, 535, 131, 21);
		
		txtTotal = new JLabel();
		txtTotal.setBounds(120, 535, 200, 21);
		txtTotal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		model.addColumn("ID");
		model.addColumn("Employe name");
		model.addColumn("Customer name");
		model.addColumn("Create date");
//		model.addColumn("Update date");
		
		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int i = tb.getSelectedRow();
				Locale localeEN = new Locale("en", "EN");
			    NumberFormat en = NumberFormat.getInstance(localeEN);
				if(i>=0) {
					recId = model.getValueAt(i, 0).toString();
					lbb_mhd.setText(recId);
					String total = en.format(loadReceiptDetail(recId)) + " VND";
					txtTotal.setText(total);
				}
			}
		});
		
		JScrollPane sp = new JScrollPane(tb);
		sp.setBounds(52, 105, 706, 425);
			
		add(lb_1);
		add(toolSearch);
		add(lbSearch);
		add(lb_cus);
		add(lb_mhd);
		add(lbb_mhd);
		add(lbTotal);
		add(txtTotal);
		add(sp);
		add(btnew);
		add(btadd);
		add(btdel);
		add(btnDetail);
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
			Object[] row = {id,empName,cusName,createDate};
			model.addRow(row);
		}
	}

	private void loadReceiptListSearch(String nameSearch) {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		ArrayList<Receipt> arr = new ArrayList<Receipt>();
		if(!recBUS.getByIdSearch(nameSearch).isEmpty()) {
			arr = recBUS.getByIdSearch(nameSearch);
		} else if(!recBUS.getByEmployeeDetailSearch(nameSearch).isEmpty()) {
			arr = recBUS.getByEmployeeDetailSearch(nameSearch);
		} else if(!recBUS.getByCustomerDetailSearch(nameSearch).isEmpty()) {
			arr = recBUS.getByCustomerDetailSearch(nameSearch);
		}
		for(int i=0; i<arr.size(); i++) {
			Receipt rec = arr.get(i);
			String id = rec.getId();
			String empName = rec.getEmployeeId();
			String cusName = rec.getCustomerId();
			java.sql.Date createDate = rec.getCreateDate();
			Object[] row = {id,empName,cusName,createDate};
			model.addRow(row);
		}
	}
	
	public long loadReceiptDetail(String id) {
		ArrayList<ReceiptDetail> arr = new ArrayList<ReceiptDetail>();
		arr = recDetailBUS.getReceiptDetailById(id);
		long sumTotal = 0;
		for(int i=0; i<arr.size(); i++) {
			ReceiptDetail recDetail = arr.get(i);
			long amount = recDetail.getAmount();
			sumTotal += amount;
		}
		return sumTotal;
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
				if(recBUS.hasReceiptId(hd)) {
					JOptionPane.showMessageDialog(this, "Hóa đơn đã tồn tại");
				} else {
					String cusId = chooseCus.getId();
					JOptionPane.showMessageDialog(this, recBUS.addReceipt(curEmp, cusId, hd));
					ReceiptDetailGUI re = new ReceiptDetailGUI(hd,curEmp,chooseCus);
					re.setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chưa tạo mã hóa đơn hoặc chưa chọn thông tin khách hàng!");
			}
		}
		if(e.getSource() == btdel) {
			recBUS.deleteReceipt(recId);
			loadReceiptList();
		}
		if(e.getSource() == btnDetail) {
			int i = tb.getSelectedRow();
			if(i>=0) {
				chooseCus = cusBUS.getByFullName(model.getValueAt(i, 2).toString());
				String hd = model.getValueAt(i, 0).toString();
				curEmp = empBUS.getByFullName(model.getValueAt(i, 1).toString());
				ReceiptDetailGUI re = new ReceiptDetailGUI(hd,curEmp,chooseCus);
				re.setVisible(true);
				re.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				JOptionPane.showMessageDialog(this, "Lỗi rồi");
			}
		}
	}
}

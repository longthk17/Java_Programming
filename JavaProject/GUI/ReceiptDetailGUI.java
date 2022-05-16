package GUI;

import DTO.Customer;
import DTO.Employee;
import DTO.Merchandise;
import DTO.Receipt;
import DTO.ReceiptDetail;

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

import BUS.MerchandiseBUS;
import BUS.ReceiptBUS;
import BUS.ReceiptDetailBUS;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class ReceiptDetailGUI extends JFrame implements ActionListener {

	private JPanel pn;
	private JLabel lbTitle, lbSubTitle, lbIdReceipt, lbCurDate, lbCusName, txtCusName, lbCusId, lbCusContact, lbPrice, txtPrice, lbChooseMer, lbQuantStock, txtQuantStock, 
	lbMerId, lbMerName, lbMerProc, lbQuant, lbTotal, lb_tkt, lb_td, txtIdReceipt, txtCurDate, txtCusId, txtCusContact, txtMerId, txtMerName, txtMerProc, txtTotal;
	private JTextField textField_1, txtTmKimSn;
	private JButton btaddkh, btfind, bt_addhd, bt_check, bt_can, btRemove;
	private JSpinner spinner;
	private JComboBox cbCus, cbMer;
	
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	Employee curEmp;
	Merchandise chooseMer;
	Customer chooseCus;
	
	String curMhd;
	long totalReceipt = 0;

	Locale localeEN = new Locale("en", "EN");
    NumberFormat en = NumberFormat.getInstance(localeEN);

	ReceiptDetailBUS recDetailBUS = new ReceiptDetailBUS();
	ReceiptBUS recBUS = new ReceiptBUS();
	MerchandiseBUS merBUS = new MerchandiseBUS();
	
	
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
		
		loadReceiptDetailList(curMhd);
		checkDetail(curMhd);
		
		setBounds(0,0,1050,630);
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(false);
	}	
	
	private void initComponents() {	
		pn = new JPanel();
		pn.setBounds(0, 0, 1050, 630);
		pn.setBackground(Color.decode("#DFEEEA"));
		pn.setLayout(null);
		
		lbTitle = new JLabel("Receipt");
		lbTitle.setFont(new Font("AddElectricCity", Font.BOLD, 30));
		lbTitle.setBounds(381, 20, 200, 29);
		
		lbIdReceipt = new JLabel("ID Receipt: ");
		lbIdReceipt.setBounds(99, 69, 118, 20);
		lbIdReceipt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtIdReceipt = new JLabel("");
		txtIdReceipt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtIdReceipt.setText(curMhd);
		txtIdReceipt.setBounds(258, 65, 114, 29);
		
		lbCurDate = new JLabel("Date founded:");
		lbCurDate.setBounds(99, 105, 118, 20);
		lbCurDate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtCurDate = new JLabel("");
		txtCurDate.setBounds(258, 101, 134, 29);
		txtCurDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lbCusName = new JLabel("Customer:");
		lbCusName.setBounds(99, 140, 119, 20);
		lbCusName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtCusName = new JLabel();
		txtCusName.setBounds(258, 140, 174, 19);
		txtCusName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtCusName.setText(chooseCus.getFullName());
		
		lbCusId = new JLabel("ID Customer:");
		lbCusId.setBounds(99, 175, 134, 20);
		lbCusId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtCusId = new JLabel();
		txtCusId.setBounds(258, 175, 174, 19);
		txtCusId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtCusId.setText(chooseCus.getId());
		
		lbCusContact = new JLabel("Contact:");
		lbCusContact.setBounds(99, 210, 119, 20);
		lbCusContact.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtCusContact = new JLabel();
		txtCusContact.setBounds(258, 210, 200, 20);
		txtCusContact.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtCusContact.setText(chooseCus.getAddress() + " - " + chooseCus.getPhone());
		
		lbChooseMer = new JLabel("Choose Merchandise: ");
		lbChooseMer.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbChooseMer.setBounds(511, 69, 175, 20);

		cbMer = new JComboBox();
		ArrayList<Merchandise> merData = merBUS.getAllMerchandise();
		for(int i = 0; i < merData.size(); i++) {
			cbMer.addItem(merData.get(i).getMerchandiseName());
		}
		cbMer.setBounds(696, 64, 255, 22);
		cbMer.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Locale localeEN = new Locale("en", "EN");
			    NumberFormat en = NumberFormat.getInstance(localeEN);
				chooseMer = merBUS.getByMerchandiseName(cbMer.getSelectedItem().toString());
				String price = en.format(chooseMer.getPrice()) + " VND";
				txtMerId.setText(chooseMer.getId());
				txtMerName.setText(chooseMer.getMerchandiseName());
				txtMerProc.setText(chooseMer.getProducer());
				String inventory = String.valueOf(chooseMer.getQuantity());
				txtQuantStock.setText(inventory);
				txtPrice.setText(price);
			}
		});
		
		lbMerId = new JLabel("ID: ");
		lbMerId.setBounds(512, 105, 46, 20);
		lbMerId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtMerId = new JLabel();
		txtMerId.setBounds(729, 101, 98, 20);
		txtMerId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lbQuantStock = new JLabel("Quantity In Stock: ");
		lbQuantStock.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbQuantStock.setBounds(726, 215, 154, 20);
		
		txtQuantStock = new JLabel();
		txtQuantStock.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtQuantStock.setBounds(892, 215, 46, 20);
		
		lbMerName = new JLabel("Merchandise Name:");
		lbMerName.setBounds(512, 140, 163, 20);
		lbMerName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtMerName = new JLabel();
		txtMerName.setBounds(729, 140, 300, 20);
		txtMerName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lbMerProc = new JLabel("Producer:");
		lbMerProc.setBounds(511, 178, 85, 20);
		lbMerProc.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtMerProc = new JLabel();
		txtMerProc.setBounds(729, 175, 98, 20);
		txtMerProc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lbQuant = new JLabel("Quantity:");
		lbQuant.setBounds(511, 215, 85, 20);
		lbQuant.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		spinner = new JSpinner();
		spinner.setBounds(597, 215, 46, 20);
		
		lbPrice = new JLabel("Price");
		lbPrice.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbPrice.setBounds(511, 252, 150, 20);
		
		txtPrice = new JLabel();
		txtPrice.setBounds(597, 252, 150, 20);
		
		bt_addhd = new JButton("Add To Receipt");
		bt_addhd.setBounds(771, 245, 167, 32);
		bt_addhd.setBackground(Color.decode("#A7C4BC"));
		bt_addhd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bt_addhd.addActionListener(this);
		
		lbTotal = new JLabel("Total Price:");
		lbTotal.setBounds(713, 481, 119, 20);
		lbTotal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtTotal = new JLabel();
		txtTotal.setBounds(830,481,300,20);
		txtTotal.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		bt_check = new JButton("Checkout");
		bt_check.setBounds(843, 511, 114, 36);
		bt_check.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bt_check.setBackground(Color.decode("#A7C4BC"));
		bt_check.addActionListener(this);
		
		bt_can = new JButton("Cancel");
		bt_can.setBounds(603, 511, 109, 36);
		bt_can.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bt_can.setBackground(Color.decode("#A7C4BC"));
		bt_can.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				bt_canActionPerformed(e);
			}
		});
		
		btRemove = new JButton("Remove");
		btRemove.setBounds(723, 511, 109, 36);
		btRemove.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btRemove.setBackground(Color.decode("#A7C4BC"));
		btRemove.addActionListener(this);
		
//		model.addColumn("STT");
		model.addColumn("ID Receipt");
		model.addColumn("Merchandise Name");
		model.addColumn("Porducer");
		model.addColumn("Quantity");
		model.addColumn("Price Of Each");
		model.addColumn("Total");
		
		JScrollPane spp = new JScrollPane(tb);
		spp.setBounds(86, 291, 871, 180);
		
		totalReceipt = recDetailBUS.sumReceiptDetail(curMhd);
		String total = en.format(totalReceipt) + " VND";
		txtTotal.setText(total);
		
		getContentPane().add(pn);
		pn.add(lbTitle);
		pn.add(lbIdReceipt);
		pn.add(txtIdReceipt);
		pn.add(lbCurDate);
		pn.add(txtCurDate);
		pn.add(lbCusName);
		pn.add(lbCusId);
		pn.add(txtCusId);
		pn.add(lbCusContact);
		pn.add(txtCusContact);
		pn.add(txtCusName);
		pn.add(lbChooseMer);
		pn.add(cbMer);
		pn.add(lbMerId);
		pn.add(txtMerId);
		pn.add(lbQuantStock);
		pn.add(txtQuantStock);
		pn.add(lbMerName);
		pn.add(txtMerName);
		pn.add(lbMerProc);
		pn.add(txtMerProc);
		pn.add(lbQuant);
		pn.add(spinner);
		pn.add(lbPrice);
		pn.add(txtPrice);
		pn.add(bt_addhd);
		pn.add(lbTotal);
		pn.add(txtTotal);
		pn.add(bt_check);
		pn.add(bt_can);
		pn.add(btRemove);
		pn.add(spp);
	}
	
	public void checkDetail(String id) {
		if(recDetailBUS.hasReceipt(id)) {
			pn.remove(btRemove);
			pn.remove(bt_addhd);
			pn.remove(bt_can);
			pn.remove(bt_check);
		}
	}
	
	public void loadReceiptDetailList(String recId) {
		model.setRowCount(0);
		ArrayList<ReceiptDetail> arr = new ArrayList<ReceiptDetail>();
		arr = recDetailBUS.getReceiptDetailById(recId);
		for(int i=0; i < arr.size(); i++) {
			ReceiptDetail recDetail = arr.get(i);
			String id = recDetail.getId();
			int quantity = recDetail.getQuantity();
			
			String amount = en.format(recDetail.getAmount()) + " VND";
			String price = en.format(recDetail.getPrice()) + " VND";
			String merchandiseId = recDetail.getMerchandiseId();
			String receiptId = recDetail.getReceiptId();
			String merchandise = recDetail.getMerchandiseName();
			String producer = recDetail.getProducer();
			Object[] row = {id,merchandise,producer,quantity,price,amount};
			model.addRow(row);
		}
	}

	private void bt_canActionPerformed(ActionEvent e) {
		if(e.getSource() == bt_can) {
			if(recBUS.deleteReceipt(curMhd)) {
				JOptionPane.showMessageDialog(this, "Hủy thành công");
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Hủy thất bại");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bt_check) {
			int qes;
			qes = JOptionPane.showConfirmDialog(this, "Bạn chấp nhận thanh toán?", "Question", JOptionPane.YES_NO_OPTION);
			if(qes==JOptionPane.YES_OPTION) {
				ArrayList<ReceiptDetail> arr = new ArrayList<ReceiptDetail>();
				arr = recDetailBUS.getReceiptDetailById(curMhd);
				for(int i = 0; i< arr.size(); i++) {
					ReceiptDetail recDetail = arr.get(i);
					String merId = recDetail.getMerchandiseId();
					int quantity = recDetail.getQuantity();
					merBUS.updateMerchandiseFromDetail(merId, quantity);
				}
				totalReceipt = 0;
			}
			dispose();	
		}
		if(e.getSource() == bt_addhd) {
			int chooseQuant = (Integer) spinner.getValue();
			String totalFinal;
			Locale localeEN = new Locale("en", "EN");
		    NumberFormat en = NumberFormat.getInstance(localeEN);
			if(chooseMer!=null && chooseQuant>0) {
				int quantity = chooseQuant + recDetailBUS.getMerchandiseQuantity(chooseMer.getId(), curMhd);
				long total = quantity * chooseMer.getPrice();
				String idMer = chooseMer.getId();
				int inventory = recDetailBUS.compareInventory(txtMerId.getText());
				if(quantity <= inventory) {
					JOptionPane.showMessageDialog(this, recDetailBUS.insertDetail(idMer, curMhd, quantity, total));
					totalReceipt = recDetailBUS.sumReceiptDetail(curMhd);
					totalFinal = en.format(totalReceipt) + " VND";
					txtTotal.setText(totalFinal);
				} else {
					JOptionPane.showMessageDialog(this, "Số lượng đặt lớn hơn số lượng tồn");
				}
				loadReceiptDetailList(curMhd);
			} else {
				JOptionPane.showMessageDialog(this, "Mời chọn thông tin");
			}
		}
		
		if(e.getSource() == btRemove) {
			int i = tb.getSelectedRow();
			String name = (String) model.getValueAt(i, 1);
			String totalFinal;
			Locale localeEN = new Locale("en", "EN");
		    NumberFormat en = NumberFormat.getInstance(localeEN);
			if(i>=0) {
				ReceiptDetail recDe = recDetailBUS.getMerchandiseByDetail(name);
				if(recDetailBUS.deleteDetail(recDe.getId())) {
					totalReceipt -= recDe.getAmount();
					totalFinal = en.format(totalReceipt) + " VND";
					txtTotal.setText(totalFinal);
					loadReceiptDetailList(curMhd);
				} else {
					JOptionPane.showMessageDialog(this, "Xóa thất bại");
				}
			}
		}
	}

}

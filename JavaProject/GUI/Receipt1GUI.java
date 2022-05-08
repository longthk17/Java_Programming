package GUI;

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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Receipt1GUI extends JFrame {

	private JPanel pn;
	private JLabel lb_1, lbtthd, lbshd, lbnl, lbtkh, lbckh, lbdcll, 
	lb_msp, lb_tsp, lb_nh, lb_sl, lb_tt, lb_tkt, lb_td, lb_shd, lb_nl;
	private JTextField textField_1, txtTmKimSn;
	private JButton btaddkh, btfind, bt_addhd, bt_check, bt_can;
	private JSpinner spinner;
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	String mhd;
	
	public void date() {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y");
		lb_nl.setText(dateForm.format(thisDate));
	
	}
	
	public Receipt1GUI(String hd) {
		this.mhd = hd;
		lb_shd.setText(hd);
		//date();
		initGUI();
	}
	
	
	
	private void initGUI() {
		setTitle("RECEIPT");
		initComponents();
		
		setBounds(0,0,1050,630);
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setVisible(false);
		
		
	}	

	
	private void initComponents() {	
		pn = new JPanel();
		pn.setBounds(0, 0, 1050, 630);
		pn.setBackground(Color.decode("#DFEEEA"));
		pn.setLayout(null);
		
		lb_1 = new JLabel("RECEIPT");
		lb_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lb_1.setBounds(459, 10, 114, 29);
		
		lbtthd = new JLabel("Th\u00F4ng tin h\u00F3a \u0111\u01A1n");
		lbtthd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbtthd.setBounds(52, 45, 154, 20);
		
		lbshd = new JLabel("ID Receit: ");
		lbshd.setBounds(102, 89, 83, 20);
		lbshd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_shd = new JLabel("");
		lb_shd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_shd.setBounds(244, 89, 85, 29);
		
		
		lbnl = new JLabel("Date founded:");
		lbnl.setBounds(102, 119, 98, 20);
		lbnl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_nl = new JLabel("");
		lb_nl.setBounds(244, 115, 134, 29);
		lb_nl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lbtkh = new JLabel("Customer:");
		lbtkh.setBounds(102, 149, 119, 20);
		lbtkh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lbckh = new JLabel("Choose Customer:");
		lbckh.setBounds(102, 179, 134, 20);
		lbckh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lbdcll = new JLabel("Contact Address:");
		lbdcll.setBounds(102, 209, 119, 20);
		lbdcll.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 149, 174, 19);
		textField_1.setColumns(10);
		
		/*Choice choice_1 = new Choice();
		choice_1.setBounds(238, 181, 174, 18);
		add(choice_1);*/
		
		btaddkh = new JButton("Add");
		btaddkh.setBounds(422, 149, 68, 21);
		btaddkh.setBackground(Color.decode("#A7C4BC"));
		btaddkh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		txtTmKimSn = new JTextField();
		txtTmKimSn.setBounds(628, 89, 195, 19);
		txtTmKimSn.setText("T\u00ECm ki\u1EBFm s\u1EA3n ph\u1EA9m");
		txtTmKimSn.setColumns(10);
		
		btfind = new JButton("Search");
		btfind.setBounds(850, 88, 77, 21);
		btfind.setBackground(Color.decode("#A7C4BC"));
		btfind.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lb_msp = new JLabel("ID: ");
		lb_msp.setBounds(573, 119, 98, 20);
		lb_msp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_tsp = new JLabel("Merchandise Name:");
		lb_tsp.setBounds(573, 149, 154, 20);
		lb_tsp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_nh = new JLabel("Producer:");
		lb_nh.setBounds(573, 179, 85, 20);
		lb_nh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_sl = new JLabel("Quantity:");
		lb_sl.setBounds(573, 209, 68, 20);
		lb_sl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		spinner = new JSpinner();
		spinner.setBounds(670, 211, 46, 20);
		
		bt_addhd = new JButton("Add To Receipt");
		bt_addhd.setBounds(775, 229, 167, 32);
		bt_addhd.setBackground(Color.decode("#A7C4BC"));
		bt_addhd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lb_tt = new JLabel("Total Price:");
		lb_tt.setBounds(388, 504, 119, 20);
		lb_tt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
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
		
		bt_can = new JButton("Cancel");
		bt_can.setBounds(732, 534, 88, 36);
		bt_can.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		bt_can.setBackground(Color.decode("#A7C4BC"));
		bt_can.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				bt_canActionPerformed(e);
			}
		});
		
		model.addColumn("STT");
		model.addColumn("ID Receipt");
		model.addColumn("Merchandise Name");
		model.addColumn("Porducer");
		model.addColumn("Quantity");
		model.addColumn("Price Of Each");
		model.addColumn("Total");
		
		JScrollPane spp = new JScrollPane(tb);
		spp.setBounds(102, 271, 842, 202);
		
		
		getContentPane().add(pn);
		pn.add(lb_1);
		pn.add(lbtthd);
		pn.add(lbshd);
		pn.add(lb_shd);
		pn.add(lbnl);
		pn.add(lb_nl);
		pn.add(lbtkh);
		pn.add(lbckh);
		pn.add(lbdcll);
		pn.add(textField_1);
		pn.add(btaddkh);
		pn.add(txtTmKimSn);
		pn.add(btfind);
		pn.add(lb_msp);
		pn.add(lb_tsp);
		pn.add(lb_nh);
		pn.add(lb_sl);
		pn.add(spinner);
		pn.add(bt_addhd);
		pn.add(lb_tt);
		pn.add(lb_tkt);
		pn.add(lb_td);
		pn.add(bt_check);
		pn.add(bt_can);
		pn.add(spp);
		
		
		
	}

	private void bt_canActionPerformed(ActionEvent e) {
		if(e.getSource() == bt_can) {
			dispose();
		}
	}

}

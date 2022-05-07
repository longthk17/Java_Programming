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

import DTO.Receipt;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Receipt1GUI extends JFrame {

	private JPanel pn;
	private JLabel lb_1, lbtthd, lbshd, lbnl, lbtkh, lbckh, lbdcll, 
	lb_msp, lb_tsp, lb_nh, lb_sl, lb_tt, lb_tkt, lb_td, lb_shd;
	private JTextField textField_1, txtTmKimSn;
	private JButton btaddkh, btfind, bt_addhd, bt_xhd, bt_check, bt_can;
	private JSpinner spinner;
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	String curMhd;
	
	public Receipt1GUI(String mhd) {
		this.curMhd = mhd;
		initGUI();
	}
	
	
	
	private void initGUI() {
		setTitle("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setBounds(0,0,1050,630);
		getContentPane().setLayout(null);
		setResizable(false);
		setVisible(false);
		getContentPane().setBackground(Color.PINK);	
		initComponents();
	}	

	
	private void initComponents() {	
		pn = new JPanel();
		pn.setBounds(0, 0, 1050, 630);
		pn.setBackground(Color.decode("#DFEEEA"));
		pn.setLayout(null);
		
		lb_1 = new JLabel("H\u00D3A \u0110\u01A0N");
		lb_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lb_1.setBounds(457, 10, 114, 29);
		

		lbtthd = new JLabel("Th\u00F4ng tin h\u00F3a \u0111\u01A1n");
		lbtthd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbtthd.setBounds(56, 59, 154, 20);

		
		lbshd = new JLabel("S\u1ED1 h\u00F3a \u0111\u01A1n: ");
		lbshd.setBounds(102, 89, 83, 20);
		lbshd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_shd = new JLabel("");
		lb_shd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_shd.setText(curMhd);
		lb_shd.setBounds(223, 84, 85, 29);
		
		lbnl = new JLabel("Ng\u00E0y l\u1EADp:");
		lbnl.setBounds(102, 119, 83, 20);
		lbnl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lbtkh = new JLabel("T\u00ECm kh\u00E1ch h\u00E0ng:");
		lbtkh.setBounds(102, 149, 119, 20);
		lbtkh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lbckh = new JLabel("Ch\u1ECDn kh\u00E1ch h\u00E0ng:");
		lbckh.setBounds(102, 179, 123, 20);
		lbckh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lbdcll = new JLabel("\u0110\u1ECBa ch\u1EC9 li\u00EAn l\u1EA1c:");
		lbdcll.setBounds(102, 209, 119, 20);
		lbdcll.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 149, 174, 19);
		textField_1.setColumns(10);
		
		/*Choice choice_1 = new Choice();
		choice_1.setBounds(238, 181, 174, 18);
		add(choice_1);*/
		
		btaddkh = new JButton("Th\u00EAm");
		btaddkh.setBounds(422, 149, 68, 21);
		btaddkh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		txtTmKimSn = new JTextField();
		txtTmKimSn.setBounds(628, 89, 195, 19);
		txtTmKimSn.setText("T\u00ECm ki\u1EBFm s\u1EA3n ph\u1EA9m");
		txtTmKimSn.setColumns(10);
		
		btfind = new JButton("T\u00ECm");
		btfind.setBounds(850, 88, 61, 21);
		btfind.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lb_msp = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m: ");
		lb_msp.setBounds(573, 119, 98, 20);
		lb_msp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_tsp = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m:");
		lb_tsp.setBounds(573, 149, 98, 20);
		lb_tsp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_nh = new JLabel("Nh\u00E3n hi\u1EC7u:");
		lb_nh.setBounds(573, 179, 85, 20);
		lb_nh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_sl = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lb_sl.setBounds(573, 209, 68, 20);
		lb_sl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		spinner = new JSpinner();
		spinner.setBounds(670, 211, 46, 20);
		
		bt_addhd = new JButton("Th\u00EAm v\u00E0o h\u00F3a \u0111\u01A1n");
		bt_addhd.setBounds(775, 240, 167, 21);
		bt_addhd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lb_tt = new JLabel("T\u1ED5ng ti\u1EC1n:");
		lb_tt.setBounds(388, 504, 119, 20);
		lb_tt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_tkt = new JLabel("Ti\u1EC1n kh\u00E1ch tr\u1EA3: ");
		lb_tkt.setBounds(597, 504, 119, 20);
		lb_tkt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lb_td = new JLabel("Ti\u1EC1n d\u01B0:");
		lb_td.setBounds(823, 504, 119, 20);
		lb_td.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		bt_xhd = new JButton("Xu\u1EA5t h\u00F3a \u0111\u01A1n");
		bt_xhd.setBounds(831, 549, 116, 21);
		bt_xhd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		bt_check = new JButton("Thanh to\u00E1n");
		bt_check.setBounds(723, 549, 98, 21);
		bt_check.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		bt_can = new JButton("H\u1EE7y");
		bt_can.setBounds(628, 549, 85, 21);
		bt_can.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bt_can.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				bt_canActionPerformed(e);
			}
		});
		
		model.addColumn("STT");
		model.addColumn("M\u00E3 s\u1EA3n ph\u1EA9m");
		model.addColumn("T\u00EAn s\u1EA3n ph\u1EA9m");
		model.addColumn("Nh\u00E3n hi\u1EC7u");
		model.addColumn("S\u1ED1 l\u01B0\u1EE3ng");
		model.addColumn("Gi\u00E1 b\u00E1n");
		model.addColumn("Th\u00E0nh ti\u1EC1n");
		
		JScrollPane spp = new JScrollPane(tb);
		spp.setBounds(85, 269, 842, 225);
		
		
		getContentPane().add(pn);
		pn.add(lb_1);
		pn.add(lbtthd);
		pn.add(lbshd);
		pn.add(lb_shd);
		pn.add(lbnl);
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
		pn.add(bt_xhd);
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

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
import javax.swing.JComboBox;

public class Receipt1GUI extends JFrame implements ActionListener{

	private JPanel pn;
	private JLabel lb_1, lbshd, lbnl, lbtkh, lbdcll, 
	lb_msp, lb_tsp, lb_nh, lb_sl, lb_tt, lb_shd, 
	lb_nl, lb_slt, lbb_slt, lb_csp;
	private JButton bt_addhd, bt_check, bt_can;
	private JSpinner spinner;
	private JComboBox comboBoxMer;
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);

	String curMhd;
	
	public void date() {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/Y");
		lb_nl.setText(dateForm.format(thisDate));
	
	}
	
	public Receipt1GUI(String mhd) {
		this.curMhd = mhd;
		initGUI();
		date();
	}
	
	private void initGUI() {
		setTitle("");
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
		lb_1.setBounds(461, 20, 114, 29);
		
		lbshd = new JLabel("ID Receit: ");
		lbshd.setBounds(99, 69, 118, 20);
		lbshd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lb_shd = new JLabel("");
		lb_shd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lb_shd.setText(curMhd);
		lb_shd.setBounds(258, 65, 114, 29);
		
		lbnl = new JLabel("Date founded:");
		lbnl.setBounds(99, 105, 118, 20);
		lbnl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lb_nl = new JLabel("");
		lb_nl.setBounds(258, 101, 134, 29);
		lb_nl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lbtkh = new JLabel("Customer:");
		lbtkh.setBounds(99, 140, 119, 20);
		lbtkh.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lbdcll = new JLabel("Contact Address:");
		lbdcll.setBounds(99, 178, 141, 20);
		lbdcll.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lb_csp = new JLabel("Choose Merchandise:");
		lb_csp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lb_csp.setBounds(511, 69, 175, 20);
		
		comboBoxMer = new JComboBox();
		comboBoxMer.setBounds(696, 64, 255, 22);
		
		lb_msp = new JLabel("ID: ");
		lb_msp.setBounds(512, 105, 46, 20);
		lb_msp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lb_slt = new JLabel("Quantity In Stock:");
		lb_slt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lb_slt.setBounds(726, 215, 154, 20);
		
		lbb_slt = new JLabel("//");
		lbb_slt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbb_slt.setBounds(892, 215, 46, 20);
		
		lb_tsp = new JLabel("Merchandise Name:");
		lb_tsp.setBounds(512, 140, 163, 20);
		lb_tsp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lb_nh = new JLabel("Producer:");
		lb_nh.setBounds(511, 178, 85, 20);
		lb_nh.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lb_sl = new JLabel("Quantity:");
		lb_sl.setBounds(511, 215, 85, 20);
		lb_sl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		spinner = new JSpinner();
		spinner.setBounds(597, 215, 46, 20);
		
		bt_addhd = new JButton("Add To Receipt");
		bt_addhd.setBounds(771, 245, 167, 32);
		bt_addhd.setBackground(Color.decode("#A7C4BC"));
		bt_addhd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bt_addhd.addActionListener(this);
		
		lb_tt = new JLabel("Total Price:");
		lb_tt.setBounds(713, 481, 119, 20);
		lb_tt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		bt_check = new JButton("Checkout");
		bt_check.setBounds(843, 511, 114, 36);
		bt_check.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bt_check.setBackground(Color.decode("#A7C4BC"));
		bt_check.addActionListener(this);
		
		bt_can = new JButton("Cancel");
		bt_can.setBounds(723, 511, 109, 36);
		bt_can.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bt_can.setBackground(Color.decode("#A7C4BC"));
		bt_can.addActionListener(this);
		
		model.addColumn("STT");
		model.addColumn("ID Receipt");
		model.addColumn("Merchandise Name");
		model.addColumn("Porducer");
		model.addColumn("Quantity");
		model.addColumn("Price Of Each");
		model.addColumn("Total");
		
		JScrollPane spp = new JScrollPane(tb);
		spp.setBounds(86, 291, 871, 180);
		
		
		getContentPane().add(pn);
		pn.add(lb_1);
		pn.add(lbshd);
		pn.add(lb_shd);
		pn.add(lbnl);
		pn.add(lb_nl);
		pn.add(lbtkh);
		pn.add(lbdcll);
		pn.add(lb_msp);
		pn.add(lb_tsp);
		pn.add(lb_nh);
		pn.add(lb_sl);
		pn.add(spinner);
		pn.add(bt_addhd);
		pn.add(lb_tt);
		pn.add(bt_check);
		pn.add(bt_can);
		pn.add(spp);
		pn.add(lb_slt);	
		pn.add(lbb_slt);
		pn.add(comboBoxMer);
		pn.add(lb_csp);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bt_can) {
			dispose();
		}
		
	}
}

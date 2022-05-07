package GUI;

import DTO.Receipt;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener.*;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReceiptGUI extends JPanel {
	private JPanel pn;
	private JTable table;
	private JLabel lb_1, lb_2, lb_mhd, lbb_mhd;
	private JButton btnew, btadd;
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	Receipt1GUI rec1 = new Receipt1GUI();
	
	public ReceiptGUI() {
		initGUI();
	}

	private void initGUI() {
		setSize(1050,630);
		setLayout(null);
		initComponents();
		setBackground(Color.decode("#DFEEEA"));
	}
	
	private void initComponents() {	
		pn = new JPanel();
		pn.setBounds(191, 116, 1050, 630);
		pn.setBackground(Color.decode("#DFEEEA"));
		pn.setLayout(null);
		
		lb_1 = new JLabel("Qu\u1EA3n L\u00ED \u0110\u01A1n B\u00E1n H\u00E0ng ");
		lb_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lb_1.setBounds(401, -1, 248, 41);
		
		lb_mhd = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n:");
		lb_mhd.setBounds(34, 120, 107, 21);
		lb_mhd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lbb_mhd = new JLabel("");
		lbb_mhd.setBounds(161, 116, 116, 35);
		lbb_mhd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnew = new JButton("T\u1EA1o h\u00F3a \u0111\u01A1n m\u1EDBi");
		btnew.setBounds(10, 181, 131, 21);
		btnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnew) {
					 
					Random r = new Random();
					int x = r.nextInt(1000)+1;
					lbb_mhd.setText("HD" + x);	
					
				}
			}
		});
		
		btadd = new JButton("Ch\u1EC9nh s\u1EEDa h\u00F3a \u0111\u01A1n");
		btadd.setBounds(151, 181, 147, 21);
		btadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				btaddActionPerformed(e);
			}
		});
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Quantity");
		model.addColumn("Phone");
		model.addColumn("Total");
		
		JScrollPane sp = new JScrollPane(tb);
		sp.setBounds(319, 82, 648, 400);
		
		
		add(lb_1);
		add(lb_mhd);
		add(lbb_mhd);
		add(sp);
		add(btnew);
		add(btadd);
	}
	
	
	/*public void btnewActionPerformed(ActionEvent e) {
		if(e.getSource() == btnew) {
			Receipt ree = new Receipt(); 
			Random r = new Random();
			int x = r.nextInt(1000)+1;
			lbb_mhd.setText("HD" + x);
			ree.setMhd(lbb_);
		}
	}*/
	
	private void btaddActionPerformed(ActionEvent e) {
		if(e.getSource() == btadd) {
			Receipt1GUI re = new Receipt1GUI();
		}
	}
}

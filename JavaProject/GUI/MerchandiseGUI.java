package GUI;

import java.awt.Color;
import javax.swing.JPanel;

import DTO.Employee;
import DTO.Merchandise;
import BUS.MerchandiseBUS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.EmployeeBUS;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MerchandiseGUI extends JPanel implements ActionListener{

	private JLabel lbTitle, lbID, lbID_Name, lbProducer, lbMerchandise_Name, lbQuantity, lbPrice;
	private JTextField tfID, tfProducer, tfMerchandise_Name, tfQuantity, tfPrice;
	private JButton btnAdd, btnUp, btnDel;
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	MerchandiseBUS merBUS = new MerchandiseBUS();
	
	public MerchandiseGUI() {
		initGUI();
	}
	
	private void initGUI() {
		setSize(1050,630);
		setLayout(null);

		initComponents();
		loadMerchandiseList();
		
		setBackground(Color.decode("#DFEEEA"));
	}
	
	private void initComponents() {
		lbTitle = new JLabel("Merchandise");
		lbTitle.setFont(new Font("AddElectricCity", Font.BOLD, 30));
		lbTitle.setBounds(415, 15, 303, 50);
		
		lbID = new JLabel("ID");
		lbID.setVerticalAlignment(SwingConstants.TOP);
		lbID.setFont(new Font("Verdana", Font.BOLD, 15));
		lbID.setBounds(160, 103, 22, 25);
		
		tfID = new JTextField();
		tfID.setBounds(192, 103, 150, 25);
		tfID.setColumns(10);
		
		lbProducer = new JLabel("Producer");
		lbProducer.setVerticalAlignment(SwingConstants.TOP);
		lbProducer.setFont(new Font("Verdana", Font.BOLD, 15));
		lbProducer.setBounds(680, 103, 74, 25);
		
		tfProducer = new JTextField();
		tfProducer.setColumns(10);
		tfProducer.setBounds(785, 103, 150, 25);
		
		lbMerchandise_Name = new JLabel("Merchandise Name");
		lbMerchandise_Name.setVerticalAlignment(SwingConstants.TOP);
		lbMerchandise_Name.setFont(new Font("Verdana", Font.BOLD, 15));
		lbMerchandise_Name.setBounds(22, 171, 165, 25);
		
		tfMerchandise_Name = new JTextField();
		tfMerchandise_Name.setColumns(10);
		tfMerchandise_Name.setBounds(192, 171, 150, 25);
		
		lbQuantity = new JLabel("Quantity");
		lbQuantity.setVerticalAlignment(SwingConstants.TOP);
		lbQuantity.setFont(new Font("Verdana", Font.BOLD, 15));
		lbQuantity.setBounds(375, 171, 74, 25);
		
		tfQuantity = new JTextField();
		tfQuantity.setColumns(10);
		tfQuantity.setBounds(486, 174, 150, 25);
		
		lbPrice = new JLabel("Price");
		lbPrice.setVerticalAlignment(SwingConstants.TOP);
		lbPrice.setFont(new Font("Verdana", Font.BOLD, 15));
		lbPrice.setBounds(707, 171, 47, 25);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(785, 171, 150, 25);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Keyes", Font.BOLD, 20));
		btnAdd.setFocusable(false);
		btnAdd.setBackground(Color.decode("#A7C4BC"));
		btnAdd.setBounds(160, 248, 150, 50);
		btnAdd.addActionListener(this);
		
		btnUp = new JButton("Update");
		btnUp.setFont(new Font("Keyes", Font.BOLD, 20));
		btnUp.setFocusable(false);
		btnUp.setBackground(Color.decode("#A7C4BC"));
		btnUp.setBounds(425, 248, 150, 50);
		btnUp.addActionListener(this);
		
		btnDel = new JButton("Delete");
		btnDel.setFont(new Font("Keyes", Font.BOLD, 20));
		btnDel.setFocusable(false);
		btnDel.setBackground(Color.decode("#A7C4BC"));
		btnDel.setBounds(695, 248, 150, 50);
		btnDel.addActionListener(this);
		
		model.addColumn("ID");
		model.addColumn("Merchandise Name");
		model.addColumn("Producer");
		model.addColumn("Quantity");
		model.addColumn("Price");
			
		JScrollPane sp = new JScrollPane(tb);
		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tfID.setEditable(false);
				int i = tb.getSelectedRow();
				if(i>=0) {
					tfID.setText(model.getValueAt(i, 0).toString());
					tfMerchandise_Name.setText(model.getValueAt(i, 1).toString());
					tfProducer.setText(model.getValueAt(i, 2).toString());
					tfQuantity.setText(model.getValueAt(i, 3).toString());
					tfPrice.setText(model.getValueAt(i, 4).toString());
				}
			}
			
		});
		sp.setBounds(75, 326, 842, 225);
		

		add(lbTitle);
		add(lbID);
		add(tfID);
		add(lbProducer);
		add(tfProducer);
		add(lbMerchandise_Name);
		add(tfMerchandise_Name);
		add(lbQuantity);
		add(tfQuantity);
		add(lbPrice);
		add(tfPrice);
		add(btnAdd);
		add(btnUp);
		add(btnDel);
		add(sp);
	}
	
	public void loadMerchandiseList() {
		model.setRowCount(0);
		ArrayList<Merchandise> arr = new ArrayList<Merchandise>();
		arr = merBUS.getAllMerchandise();
		for(int i=0; i < arr.size(); i++) {
			Merchandise mer = arr.get(i);
			String id = mer.getId();
			String producer = mer.getProducer();
			String merchandiseName = mer.getMerchandiseName();
			int quantity = mer.getQuantity();
			int price = mer.getPrice();
			Object[] row = {id, producer, merchandiseName, quantity, price};
			model.addRow(row);
		}
	}
	
	public boolean checkNull(String string) {
		if(string != null && !string.trim().equals("")) {
			return true;
		} else return false;
	}	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			try {
				tfID.setEditable(true);
				if(checkNull(tfID.getText()) && checkNull(tfProducer.getText()) && checkNull(tfMerchandise_Name.getText()) && checkNull(tfQuantity.getText()) && checkNull(tfPrice.getText())) {
					Merchandise mer = new Merchandise();
					mer.setId(tfID.getText());
					mer.setProducer(tfProducer.getText());
					mer.setMerchandiseName(tfMerchandise_Name.getText());
					String quantity = tfQuantity.getText();
					mer.setQuantity(Integer.parseInt(quantity));
					String price = tfPrice.getText();
					mer.setPrice(Integer.parseInt(price));
					JOptionPane.showMessageDialog(this, merBUS.addMerchandise(mer));
					tfID.setText("");
					tfProducer.setText("");
					tfMerchandise_Name.setText("");
					tfQuantity.setText("");
					tfPrice.setText("");
					loadMerchandiseList();
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
				}
			} catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
			}
		}
		
		if(e.getSource() == btnUp) {
			try {
				if(checkNull(tfID.getText()) && checkNull(tfProducer.getText()) && checkNull(tfMerchandise_Name.getText()) && checkNull(tfQuantity.getText()) && checkNull(tfPrice.getText())) {
					Merchandise mer = new Merchandise();
					mer.setId(tfID.getText());
					mer.setProducer(tfProducer.getText());
					mer.setMerchandiseName(tfMerchandise_Name.getText());
					String quantity = tfQuantity.getText();
					mer.setQuantity(Integer.parseInt(quantity));
					String price = tfPrice.getText();
					mer.setPrice(Integer.parseInt(price));
					JOptionPane.showMessageDialog(this, merBUS.updateMerchandise(mer));
					loadMerchandiseList();
					tfID.setText("");
					tfProducer.setText("");
					tfMerchandise_Name.setText("");
					tfQuantity.setText("");
					tfPrice.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "Vui lĂ²ng nháº­p Ä‘á»§ thĂ´ng tin");
				}
			} catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "ThĂ´ng tin khĂ´ng há»£p lá»‡");
			}
		}
		if(e.getSource() == btnDel) {
			int i = tb.getSelectedRow();
			String ID = (String) model.getValueAt(i, 0);
			if(i>=0) {
				merBUS.deleteMerchandise(ID);
				JOptionPane.showMessageDialog(this, "Xóa thành công");
				loadMerchandiseList();
				tfID.setText("");
				tfProducer.setText("");
				tfMerchandise_Name.setText("");
				tfQuantity.setText("");
				tfPrice.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Xóa thất bại");
			}
		}
		
		/*if(e.getSource() == btnClear) {
			tfID.setText("");
			tfID_Name.setText("");
			tfProducer.setText("");
			tfMerchandise_Name.setText("");
			tfQuantity.setText("");
			tfPrice.setText("");
		}*/
		
	}
	
}
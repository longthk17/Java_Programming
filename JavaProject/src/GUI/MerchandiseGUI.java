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
	private JTextField tfID, tfID_Name, tfProducer, tfMerchandise_Name, tfQuantity, tfPrice;
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
		
		loadMerchandiseList();
		initComponents();
		setBackground(Color.decode("#DFEEEA"));
	}
	
	private void initComponents() {
		lbTitle = new JLabel("Merchandise");
		lbTitle.setFont(new Font("Keyes", Font.PLAIN, 40));
		lbTitle.setBounds(415, 15, 303, 50);
		
		lbID = new JLabel("ID");
		lbID.setVerticalAlignment(SwingConstants.TOP);
		lbID.setFont(new Font("Keyes", Font.PLAIN, 18));
		lbID.setBounds(160, 103, 22, 25);
		
		tfID = new JTextField();
		tfID.setBounds(192, 103, 150, 25);
		tfID.setColumns(10);
		
		lbID_Name = new JLabel("ID Name");
		lbID_Name.setVerticalAlignment(SwingConstants.TOP);
		lbID_Name.setFont(new Font("Keyes", Font.PLAIN, 18));
		lbID_Name.setBounds(375, 103, 74, 25);
		
		tfID_Name = new JTextField();
		tfID_Name.setColumns(10);
		tfID_Name.setBounds(486, 103, 150, 25);
		
		lbProducer = new JLabel("Producer");
		lbProducer.setVerticalAlignment(SwingConstants.TOP);
		lbProducer.setFont(new Font("Keyes", Font.PLAIN, 18));
		lbProducer.setBounds(680, 103, 74, 25);
		
		tfProducer = new JTextField();
		tfProducer.setColumns(10);
		tfProducer.setBounds(785, 103, 150, 25);
		
		lbMerchandise_Name = new JLabel("Merchandise Name");
		lbMerchandise_Name.setVerticalAlignment(SwingConstants.TOP);
		lbMerchandise_Name.setFont(new Font("Keyes", Font.PLAIN, 18));
		lbMerchandise_Name.setBounds(22, 171, 165, 25);
		
		tfMerchandise_Name = new JTextField();
		tfMerchandise_Name.setColumns(10);
		tfMerchandise_Name.setBounds(192, 171, 150, 25);
		
		lbQuantity = new JLabel("Quantity");
		lbQuantity.setVerticalAlignment(SwingConstants.TOP);
		lbQuantity.setFont(new Font("Keyes", Font.PLAIN, 18));
		lbQuantity.setBounds(375, 171, 74, 25);
		
		tfQuantity = new JTextField();
		tfQuantity.setColumns(10);
		tfQuantity.setBounds(486, 174, 150, 25);
		
		lbPrice = new JLabel("Price");
		lbPrice.setVerticalAlignment(SwingConstants.TOP);
		lbPrice.setFont(new Font("Keyes", Font.PLAIN, 18));
		lbPrice.setBounds(707, 171, 47, 25);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(785, 171, 150, 25);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Keyes", Font.BOLD, 20));
		btnAdd.setBounds(160, 248, 150, 50);
		btnAdd.addActionListener(this);
		
		btnUp = new JButton("Update");
		btnAdd.setFont(new Font("Keyes", Font.BOLD, 20));
		btnUp.setBounds(425, 248, 150, 50);
		btnUp.addActionListener(this);
		
		btnDel = new JButton("Delete");
		btnAdd.setFont(new Font("Keyes", Font.BOLD, 20));
		btnDel.setBounds(695, 248, 150, 50);
		btnDel.addActionListener(this);
		
		model.addColumn("ID");
		model.addColumn("ID Name");
		model.addColumn("Producer");
		model.addColumn("Merchandise Name");
		model.addColumn("Quantity");
		model.addColumn("Price");
			
		JScrollPane sp = new JScrollPane(tb);
		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tfID.setEditable(false);
				int i = tb.getSelectedRow();
				if(i>=0) {
					tfID.setText(model.getValueAt(i, 0).toString());
					tfID_Name.setText(model.getValueAt(i, 1).toString());
					tfProducer.setText(model.getValueAt(i, 2).toString());
					tfMerchandise_Name.setText(model.getValueAt(i, 3).toString());
					tfQuantity.setText(model.getValueAt(i, 4).toString());
					tfPrice.setText(model.getValueAt(i, 5).toString());
				}
			}
			
		});
		sp.setBounds(75, 326, 842, 225);
		

		add(lbTitle);
		add(lbID);
		add(tfID);
		add(lbID_Name);
		add(tfID_Name);
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
			String id = mer.getID();
			String idname = mer.getIDName();
			String producer = mer.getProducer();
			String merchandisename = mer.getMerchandiseName();
			int quantity = mer.getQuantity();
			int price = mer.getPrice();
			Object[] row = {id, idname, producer, merchandisename, quantity, price};
			model.addRow(row);
		}
	}
	
	public boolean checkNull(String string) {
		if(string != null && !string.trim().equals("")) {
			return true;
		} else return false;
	}
	
	
	/*private void btnAddActionPerformed(ActionEvent e) {
		if( tfID.getText().equals("") || tfID_Name.getText().equals("") || tfProducer.getText().equals("") || tfMerchandise_Name.getText().equals("") || tfQuantity.getText().equals("") || tfPrice.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter All Data");
		}
		else {
			String data[] = {tfID.getText(), tfID_Name.getText(), tfProducer.getText(), tfMerchandise_Name.getText(), tfQuantity.getText(), tfPrice.getText()};
			model.addRow(data);
			JOptionPane.showMessageDialog(this, "Add Data Successfully!");
			tfID.setText("");
			tfID_Name.setText("");
			tfProducer.setText("");
			tfMerchandise_Name.setText("");
			tfQuantity.setText("");
			tfPrice.setText("");
		}
	}
	
	private void btnDelActionPerformed (ActionEvent e) {
		DefaultTableModel tbModel  = (DefaultTableModel) tb.getModel();
		if(tb.getSelectedRowCount() == 1) {
			tbModel.removeRow(tb.getSelectedRow());
		}
		else {
			if(tb.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Table is Empty.");
			}else {
				JOptionPane.showMessageDialog(this, "Please Select Single Row For Deleted.");
			}
		}
	}
	
	private void tbMouseClicked (MouseEvent e) {
		DefaultTableModel tbModel  = (DefaultTableModel) tb.getModel();
		String tbID = tbModel.getValueAt(tb.getSelectedRow(), 0).toString();
		String tbIDName = tbModel.getValueAt(tb.getSelectedRow(), 1).toString();
		String tbPro = tbModel.getValueAt(tb.getSelectedRow(), 2).toString();
		String tbMer = tbModel.getValueAt(tb.getSelectedRow(), 3).toString();
		String tbQuan = tbModel.getValueAt(tb.getSelectedRow(), 4).toString();
		String tbPri = tbModel.getValueAt(tb.getSelectedRow(), 5).toString();
		
		tfID.setText(tbID);
		tfID_Name.setText(tbIDName);
		tfProducer.setText(tbPro);
		tfMerchandise_Name.setText(tbMer);
		tfQuantity.setText(tbQuan);
		tfPrice.setText(tbPri);
	}
	
	private void btnUpActionPerformed (ActionEvent e) {
		DefaultTableModel tbModel  = (DefaultTableModel) tb.getModel();
		if(tb.getSelectedRowCount() == 1) {
			String ID = tfID.getText();
			String IDName = tfID_Name.getText();
			String Pro = tfProducer.getText();
			String Mer = tfMerchandise_Name.getText();
			String Quan = tfQuantity.getText();
			String Pri = tfPrice.getText();
			
			tbModel.setValueAt(ID, tb.getSelectedRow(), 0);
			tbModel.setValueAt(IDName, tb.getSelectedRow(), 1);
			tbModel.setValueAt(Pro, tb.getSelectedRow(), 2);
			tbModel.setValueAt(Mer, tb.getSelectedRow(), 3);
			tbModel.setValueAt(Quan, tb.getSelectedRow(), 4);
			tbModel.setValueAt(Pri, tb.getSelectedRow(), 5);
			
			JOptionPane.showMessageDialog(this, "Update Successfully.");
		}
		else {
			if(tb.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Table is Empty.");
			}else {
				JOptionPane.showMessageDialog(this, "Please Select Single Row For Deleted.");
			}
		}
	}*/
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			try {
				tfID.setEditable(true);
				if(checkNull(tfID.getText()) && checkNull(tfID_Name.getText()) && checkNull(tfProducer.getText()) && checkNull(tfMerchandise_Name.getText()) && checkNull(tfQuantity.getText()) && checkNull(tfPrice.getText())) {
					Merchandise mer = new Merchandise();
					mer.setID(tfID.getText());
					mer.setIDName(tfID_Name.getText());
					mer.setProducer(tfProducer.getText());
					mer.setMerchandiseName(tfMerchandise_Name.getText());
					String quantity = tfQuantity.getText();
					mer.setQuantity(Integer.parseInt(quantity));
					String price = tfPrice.getText();
					mer.setPrice(Integer.parseInt(price));
					
					JOptionPane.showMessageDialog(this, merBUS.addMerchandise(mer));
					loadMerchandiseList();
				} else {
					JOptionPane.showMessageDialog(this, "Vui lĂ²ng nháº­p Ä‘á»§ thĂ´ng tin");
				}
			} catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "ThĂ´ng tin khĂ´ng há»£p lá»‡");
			}
		}
		
		if(e.getSource() == btnUp) {
			try {
				if(checkNull(tfID.getText()) && checkNull(tfID_Name.getText()) && checkNull(tfProducer.getText()) && checkNull(tfMerchandise_Name.getText()) && checkNull(tfQuantity.getText()) && checkNull(tfPrice.getText())) {
					Merchandise mer = new Merchandise();
					mer.setID(tfID.getText());
					mer.setIDName(tfID_Name.getText());
					mer.setProducer(tfProducer.getText());
					mer.setMerchandiseName(tfMerchandise_Name.getText());
					String quantity = tfQuantity.getText();
					mer.setQuantity(Integer.parseInt(quantity));
					String price = tfPrice.getText();
					mer.setPrice(Integer.parseInt(price));
					
					JOptionPane.showMessageDialog(this, merBUS.updateMerchandise(mer));
					loadMerchandiseList();
					tfID.setText("");
					tfID_Name.setText("");
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
				tfID_Name.setText("");
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
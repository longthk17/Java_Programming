package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame implements ActionListener {
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	JButton btnAdd, btnDelete, btnUpdate, btnSearch;
	JTextField tfsearch, tf_tensp, tf_masp, tf_gia;
	JLabel lb_tensp, lb_masp, lb_gia, lb_tenloaisp;
	JComboBox cbTypeItem, cbTypeItem_search;
	JPanel pn1, pn2, pn3;
	

	String DB_URL = "jdbc:mysql://localhost:3307/test";
	String user = "root";
	String pass = "";
	Connection conn;
	
	
	public Main() {
		// hàm khởi tạo giao diện chính
		initGUI();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, user, pass);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void initGUI() {
		setTitle("NGU");
		setLayout(new FlowLayout());
		
		//hàm khởi tạo các elements
		initComponents();
		//load DB và hiển thị lên giao diện
		showItem();
		
		setBounds(500,80,600,550);
		setVisible(true);
	}
	
	private void initComponents() {		
		btnAdd = new JButton("Add Item");
		btnAdd.addActionListener(this);
		btnDelete = new JButton("Delete Item");
		btnDelete.addActionListener(this);
		btnUpdate = new JButton("Update Item");
		btnUpdate.addActionListener(this);
		btnSearch = new JButton("Search Item");
		btnSearch.addActionListener(this);
		
		tfsearch = new JTextField();
		tf_masp = new JTextField(15);
		tf_tensp = new JTextField(15);
		tf_gia = new JTextField(15);
		
		lb_masp = new JLabel("Ma San Pham");
		lb_tensp = new JLabel("Ten san pham");
		lb_gia = new JLabel("gia");
		lb_tenloaisp = new JLabel("ten loai");
		
		pn1 = new JPanel();
		pn1.setLayout(new GridLayout(4,4,20,20));
		pn2 = new JPanel();
		pn3 = new JPanel();
		
		tb.setPreferredScrollableViewportSize(new Dimension(500,200));
		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int i = tb.getSelectedRow();
				if(i>=0) {
					tf_masp.setText(model.getValueAt(i, 0).toString());
					tf_tensp.setText(model.getValueAt(i, 1).toString());
					tf_gia.setText(model.getValueAt(i, 2).toString());
				}
			}
		});
		model.addColumn("MaSP");
		model.addColumn("TenSP");
		model.addColumn("Gia");
		model.addColumn("TenLoaiSP");
		
		JScrollPane sp = new JScrollPane(tb);
		
		cbTypeItem = new JComboBox();
		for(int i=0; i < typeList().size(); i++) {
			cbTypeItem.addItem(typeList().get(i).tenloai_sp);
		}
		cbTypeItem.setSize(20, 10);
		
		cbTypeItem_search = new JComboBox();
		
		for(int i=0; i < typeList().size(); i++) {
			cbTypeItem_search.addItem(typeList().get(i).tenloai_sp);
		}
		cbTypeItem_search.setSize(20,10);
		
		pn1.add(lb_masp);
		pn1.add(tf_masp);
		pn1.add(lb_tensp);
		pn1.add(tf_tensp);
		pn1.add(lb_gia);
		pn1.add(tf_gia);
		pn1.add(lb_tenloaisp);
		pn1.add(cbTypeItem);
		pn2.add(btnAdd);
		pn2.add(btnDelete);
		pn2.add(btnUpdate);
		pn3.add(sp);
		
		
		add(pn1);
		add(pn2);
		add(pn3);
		add(cbTypeItem_search);
		add(btnSearch);
		
	}
	
	private ArrayList<Item> itemList() {
		ArrayList<Item> itemsList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, user, pass);
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT sanpham.MaSP, sanpham.TenSP, sanpham.Gia, loaisanpham.TenLoaiSP FROM sanpham INNER JOIN loaisanpham ON sanpham.MaLoaiSP = loaisanpham.MaLoaiSP";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Item item = new Item(rs.getInt("MaSP"), rs.getString("TenSP"), rs.getInt("Gia"), rs.getString("TenLoaiSP"));
				itemsList.add(item);
			}
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		return itemsList;
	}
	
	private void showItem() {
		//reset table null
		model.setRowCount(0);
		ArrayList<Item> list = itemList();
		Object[] row = new Object[4];
		for(int i=0; i < list.size(); i++) {
			row[0] = list.get(i).getMa_sp();
			row[1] = list.get(i).getTen_sp();
			row[2] = list.get(i).getPrice();
			row[3] = list.get(i).getTenloai_sp();
			model.addRow(row);
		}
	}
	
	private ArrayList<Item> itemsSearch(String tenloaisp) {
		ArrayList<Item> itemsList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, user, pass);
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT sanpham.MaSP, sanpham.TenSP, sanpham.Gia, loaisanpham.TenLoaiSP FROM sanpham INNER JOIN loaisanpham ON sanpham.MaLoaiSP = loaisanpham.MaLoaiSP WHERE TenLoaiSP = '" + tenloaisp + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Item item = new Item(rs.getInt("MaSP"), rs.getString("TenSP"), rs.getInt("Gia"), rs.getString("TenLoaiSP"));
				itemsList.add(item);
			}
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		return itemsList;
	}
	
	private void showItemSearch(String tenloaisp) {
		//reset table null
		model.setRowCount(0);
		ArrayList<Item> list = itemsSearch(tenloaisp);
		Object[] row = new Object[4];
		for(int i=0; i < list.size(); i++) {
			row[0] = list.get(i).getMa_sp();
			row[1] = list.get(i).getTen_sp();
			row[2] = list.get(i).getPrice();
			row[3] = list.get(i).getTenloai_sp();
			model.addRow(row);
		}
	}

	public ArrayList<ItemType> typeList() {
		ArrayList<ItemType> typesList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, user, pass);
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT TenLoaiSP FROM loaisanpham";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ItemType type = new ItemType(rs.getString("TenLoaiSP"));
				typesList.add(type);
			}
			
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		return typesList;
	}
	
	private void insertItem(int maSP, String tenSP, int gia, String loai) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, user, pass);
			Statement stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO sanpham SET MaSP = '"+ maSP +"', TenSP = '"+ tenSP + "', Gia = " + gia + ", MaLoaiSP = (SELECT MaLoaiSP FROM loaisanpham WHERE TenLoaiSP = '"+ loai +"')";
			stmt.executeUpdate(sql);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	private void deleteItem(int masp) {
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "DELETE FROM sanpham WHERE MaSP=" + masp;
			stmt.executeUpdate(sql);
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	private void updateItem(String tensp, int gia, int masp, String loai) {
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "UPDATE sanpham SET TenSP = '" + tensp + "', Gia = '" + gia + "', MaLoaiSP = (SELECT MaLoaiSP FROM loaisanpham WHERE TenLoaiSP = '" + loai + "') WHERE MaSP=" + masp;
			stmt.executeUpdate(sql);
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAdd) {
			String masp = tf_masp.getText();
			String tensp = tf_tensp.getText();
			String gia = tf_gia.getText();
			String tenloaisp = (String) cbTypeItem.getSelectedItem();
			int new_masp = Integer.parseInt(masp);
			int new_gia = Integer.parseInt(gia);
			insertItem(new_masp, tensp, new_gia, tenloaisp);
			showItem();
			tf_masp.setText("");
			tf_tensp.setText("");
			tf_gia.setText("");
			cbTypeItem.setSelectedIndex(0);
		}
		
		if(e.getSource() == btnDelete) {
			int i = tb.getSelectedRow();
			int masp = (int) model.getValueAt(i, 0);
			if(i>=0) {
				model.removeRow(i);
				
				deleteItem(masp);
				
				showItem();
			}
		}
		if(e.getSource() == btnUpdate) {
			String tensp = tf_tensp.getText();
			String tenloaisp = (String) cbTypeItem.getSelectedItem();
			int masp = Integer.parseInt(tf_masp.getText());
			int gia = Integer.parseInt(tf_gia.getText());
			updateItem(tensp, gia, masp,tenloaisp);
			showItem();
			tf_masp.setText("");
			tf_tensp.setText("");
			tf_gia.setText("");
			cbTypeItem.setSelectedIndex(0);
		}
		if(e.getSource() == btnSearch) {
			String tenloaisp = (String) cbTypeItem_search.getSelectedItem();
//			System.out.println(tenloaisp);
			showItemSearch(tenloaisp);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}

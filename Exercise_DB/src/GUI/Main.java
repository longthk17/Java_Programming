package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable();
	JButton btnAdd, btnDelete, btnUpdate, btnSearch;
	JTextField tfsearch;
	JPanel pn1;
	
	public Main() {
		initGUI();
	}
	
	private void initGUI() {
		setTitle("NGU");
		setLayout(null);
		
		initComponents();
		
		setBounds(500,80,500,400);
		setVisible(true);
	}
	
	private void initComponents() {
		btnAdd = new JButton("Add Item");
		btnDelete = new JButton("Delete Item");
		btnUpdate = new JButton("Update Item");
		btnSearch = new JButton("Search Item");
		
		tfsearch = new JTextField();
		
		pn1 = new JPanel();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}

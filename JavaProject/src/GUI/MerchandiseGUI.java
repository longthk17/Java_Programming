package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MerchandiseGUI extends JPanel{

	private JPanel contentPane;
	private JLabel lb_1, lb_ID, lb_ID_Name, lb_NhaSanXuat, lb_TenSanPham, lb_SoLuong, lb_Gia;
	private JTextField textField_MaLoai, textField_TenLoai, textField_NhaSanXuat, textField_TenSanPham, textField_SoLuong, textField_Gia;
	DefaultTableModel model = new DefaultTableModel();
	JTable tb = new JTable(model);
	
	public MerchandiseGUI() {
		initGUI();
	}
	
	private void initGUI() {
		setSize(1050,630);
		setLayout(null);
		initComponents();
		setBackground(Color.decode("#DFEEEA"));
	}
	
	private void initComponents() {
		lb_1 = new JLabel("Merchandise Management");
		lb_1.setFont(new Font("Verdana", Font.BOLD, 25));
		lb_1.setBounds(600, 200, 200, 30);
		
		lb_ID = new JLabel("ID");
		lb_ID.setFont(new Font("Keyes", Font.PLAIN, 12));
		lb_ID.setBounds(39, 55, 150, 21);
		
		textField_MaLoai = new JTextField();
		textField_MaLoai.setBounds(99, 56, 100, 20);
		textField_MaLoai.setColumns(10);
		
		lb_ID_Name = new JLabel("Tên Loại");
		lb_ID_Name.setFont(new Font("Keyes", Font.PLAIN, 12));
		lb_ID_Name.setBounds(217, 55, 62, 21);
	
		textField_TenLoai = new JTextField();
		textField_TenLoai.setColumns(10);
		textField_TenLoai.setBounds(277, 56, 200, 20);
		
		lb_NhaSanXuat = new JLabel("Nhà Sản Xuất");
		lb_NhaSanXuat.setFont(new Font("Keyes", Font.PLAIN, 12));
		lb_NhaSanXuat.setBounds(399, 59, 78, 21);
		
		textField_NhaSanXuat = new JTextField();
		textField_NhaSanXuat.setColumns(10);
		textField_NhaSanXuat.setBounds(493, 60, 112, 20);
		
		lb_TenSanPham = new JLabel("TĂªn Sáº£n Pháº©m");
		lb_TenSanPham.setFont(new Font("Keyes", Font.PLAIN, 12));
		lb_TenSanPham.setBounds(10, 101, 89, 21);
		
		textField_TenSanPham = new JTextField();
		textField_TenSanPham.setColumns(10);
		textField_TenSanPham.setBounds(99, 102, 100, 20);
		
		lb_SoLuong = new JLabel("Sá»‘ LÆ°á»£ng");
		lb_SoLuong.setFont(new Font("Keyes", Font.PLAIN, 12));
		lb_SoLuong.setBounds(217, 105, 62, 21);
		
		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(277, 102, 112, 20);
		
		lb_Gia = new JLabel("GiĂ¡");
		lb_Gia.setFont(new Font("Keyes", Font.PLAIN, 12));
		lb_Gia.setBounds(450, 101, 27, 21);
		
		textField_Gia = new JTextField();
		textField_Gia.setColumns(10);
		textField_Gia.setBounds(493, 102, 112, 20);
		
		JButton btnAdd = new JButton("ThĂªm");
		ImageIcon iconbtnAdd = new ImageIcon("C:\\Users\\nguye\\Downloads\\add.png");
		btnAdd = new JButton(iconbtnAdd);
		btnAdd.setBounds(50, 156, 120, 53);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String MĂ£  = textField_MaLoai.getText();
			}
		});		
		
		
		JButton btnFix = new JButton("Sá»­a");
		btnFix.setBounds(253, 156, 120, 53);
		
		JButton btnDelete = new JButton("XĂ³a");
		btnDelete.setBounds(448, 156, 120, 53);
		
		model.addColumn("MĂ£ Loáº¡i");
		model.addColumn("TĂªn Loáº¡i");
		model.addColumn("NhĂ  Sáº£n Xuáº¥t");
		model.addColumn("TĂªn Sáº£n Pháº©m");
		model.addColumn("Sá»‘ LÆ°á»£ng");
		model.addColumn("GiĂ¡");
		JScrollPane scrollPane = new JScrollPane(tb);
		scrollPane.setBounds(39, 260, 550, 209);
		
		add(lb_1);
		add(lb_ID);
		add(textField_MaLoai);
		add(lb_ID_Name);
		add(textField_TenLoai);
		add(lb_NhaSanXuat);
		add(textField_NhaSanXuat);
		add(lb_TenSanPham);
		add(textField_TenSanPham);
		add(lb_SoLuong);
		add(textField_SoLuong);
		add(lb_Gia);
		add(textField_Gia);
		add(btnAdd);
		add(btnFix);
		add(btnDelete);
		add(scrollPane);
	}
}
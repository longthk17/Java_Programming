
import java.sql.*;
import javax.sql.*;

public class Main {
	String DB_URL = "jdbc:mysql://localhost:3307/test";
	String user = "root";
	String pass = "";
	Connection conn;
	
	public Main() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, user, pass);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void showItem() {
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT sanpham.MaSP, sanpham.TenSP, sanpham.Gia, loaisanpham.TenLoaiSP FROM sanpham INNER JOIN loaisanpham ON sanpham.MaLoaiSP = loaisanpham.MaLoaiSP";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int maSP = rs.getInt("MaSP");
				String tenSP = rs.getString("TenSP");
				int giaSP = rs.getInt("Gia");
				String tenloaiSP = rs.getString("TenLoaiSP");
				
				System.out.println("MaSP: " + maSP);
				System.out.println("TenSP: " + tenSP);
				System.out.println("Gia: " + giaSP);
				System.out.println("TenLoaiSP: " + tenloaiSP);
			    System.out.println("=================");
			
			} 
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	private void insertItem(String tenSP, int gia, String loai) {
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO sanpham SET TenSP = '"+ tenSP + "', Gia = " + gia + ", MaLoaiSP = (SELECT MaLoaiSP FROM loaisanpham WHERE TenLoaiSP = '"+ loai +"')";
			stmt.executeUpdate(sql);
		} catch(SQLException ex) {
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
	
	private void updateItem(String tensp, int gia, int masp) {
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "UPDATE sanpham SET TenSP = '" + tensp + "', Gia = " + gia + " WHERE MaSP=" + masp;
			stmt.executeUpdate(sql);
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	// tim kiem san pham theo ma loai san pham
	private void searchItem(int maloaisp) {
		try {
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM sanpham WHERE MaLoaiSP = " + maloaisp;
			ResultSet rs = stmt.executeQuery(sql);
			

			while(rs.next()) {
				int maSP = rs.getInt("MaSP");
				String tenSP = rs.getString("TenSP");
				int giaSP = rs.getInt("Gia");
				int loaisp = rs.getInt("MaLoaiSP");
				
				System.out.println("MaSP: " + maSP);
				System.out.println("TenSP: " + tenSP);
				System.out.println("Gia: " + giaSP);
				System.out.println("MaLoaiSP: " + loaisp);
			    System.out.println("=================");
			
			} 
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
//		main.insertItem("may giat", 3000000, "toshiba");
//		main.deleteItem(9);
//		main.updateItem("Ngu", 100, 7);
		main.searchItem(4);
//		main.showItem();
	}

}

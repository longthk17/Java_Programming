package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Employee;
import DTO.Merchandise;
import Utils.Date;
import Utils.Hashing;
import Utils.MySQLConnUtils;

public class MerchandiseDAL {
	
	public ArrayList<Merchandise> getAllMerchandise() {
		ArrayList<Merchandise> merList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM merchandise";
			PreparedStatement prest = conn.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String merchandisename = rs.getString("merchandiseName");
				String producer = rs.getString("producer");
				int quantity = rs.getInt("quantity");
				long price = rs.getInt("price");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Merchandise mer = new Merchandise(id, producer, merchandisename, quantity, price,createDate,updateDate);
				merList.add(mer);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return merList;
	}
	
	public static Merchandise getByMerchandiseName(String name) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM merchandise WHERE merchandiseName = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				Merchandise mer = new Merchandise();
				mer.setId(rs.getString("id"));
				mer.setMerchandiseName(rs.getString("merchandiseName"));
				mer.setProducer(rs.getString("producer"));
				mer.setQuantity(rs.getInt("quantity"));
				mer.setPrice(rs.getLong("price"));
				mer.setCreateDate(rs.getDate("create_date"));
				mer.setUpdateDate(rs.getDate("update_date"));
				return mer;
			} else return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Merchandise> getByFullNameSearch(String name) {
		ArrayList<Merchandise> merList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM merchandise WHERE merchandiseName LIKE '%" + name + "%'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String merchandisename = rs.getString("merchandiseName");
				String producer = rs.getString("producer");
				int quantity = rs.getInt("quantity");
				long price = rs.getInt("price");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Merchandise mer = new Merchandise(id, producer, merchandisename, quantity, price,createDate,updateDate);
				merList.add(mer);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return merList;
	}
	
	public static ArrayList<Merchandise> getByIdSearch(String name) {
		ArrayList<Merchandise> merList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM merchandise WHERE id LIKE '%" + name + "%'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String merchandisename = rs.getString("merchandiseName");
				String producer = rs.getString("producer");
				int quantity = rs.getInt("quantity");
				long price = rs.getInt("price");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Merchandise mer = new Merchandise(id, producer, merchandisename, quantity, price,createDate,updateDate);
				merList.add(mer);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return merList;
	}
	
	public static ArrayList<Merchandise> getByProducerSearch(String name) {
		ArrayList<Merchandise> merList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM merchandise WHERE producer LIKE '%" + name + "%'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String merchandisename = rs.getString("merchandiseName");
				String producer = rs.getString("producer");
				int quantity = rs.getInt("quantity");
				long price = rs.getInt("price");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Merchandise mer = new Merchandise(id, producer, merchandisename, quantity, price,createDate,updateDate);
				merList.add(mer);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return merList;
	}
	
	public boolean addMerchandise(Merchandise mer) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "INSERT INTO merchandise values(?,?,?,?,?,?,?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, mer.getId());
			prest.setString(2, mer.getMerchandiseName());
			prest.setString(3, mer.getProducer());
			prest.setInt(4, mer.getQuantity());
			prest.setLong(5, mer.getPrice());
			java.sql.Date date = Date.getCurrentDatetime();
			prest.setDate(6, date);
			prest.setDate(7, null);
			if(prest.executeUpdate()>=1 ) {
				return true;
			} else return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean updateMerchandise(Merchandise mer) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "UPDATE merchandise SET producer = ?, merchandisename = ?, quantity = ?, price = ?, update_date = ?"
					+ "WHERE id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, mer.getProducer());
			prest.setString(2, mer.getMerchandiseName());
			prest.setInt(3, mer.getQuantity());
			prest.setLong(4, mer.getPrice());
			java.sql.Date date = Date.getCurrentDatetime();
			prest.setDate(5, date);
			prest.setString(6, mer.getId());
			if(prest.executeUpdate() >= 1 ) {
				return true;
			} else return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//lấy số lượng merchandise có trong DB
	public int getMerchandiseQuantity(String merId) {
		int quantity = 0;
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT quantity FROM merchandise WHERE id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, merId);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				quantity = rs.getInt("quantity");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return quantity;
	}
	
	public boolean updateMerchandiseFromDetail(String merId, int quantity) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "UPDATE merchandise SET quantity = ? WHERE id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			int newQuant = getMerchandiseQuantity(merId) - quantity;
			prest.setInt(1, newQuant);
			prest.setString(2, merId);
			if(prest.executeUpdate()>=1) {
				return true;
			} else return false;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteMerchandise(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "DELETE FROM merchandise WHERE ID = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, id);
			if(prest.executeUpdate()>=1) {
				return true;
			} else return false;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean hasMerchandiseID(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM merchandise WHERE id = '" + id + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}

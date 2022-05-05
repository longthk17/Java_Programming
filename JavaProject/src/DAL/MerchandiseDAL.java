package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Merchandise;
import GUI.Hashing;

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
				String idname = rs.getString("idname");
				String producer = rs.getString("producer");
				String merchandisename = rs.getString("merchandisename");
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("price");
				Merchandise mer = new Merchandise(id, idname, producer, merchandisename, quantity, price);
				merList.add(mer);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return merList;
	}
	
	/*public static Merchandise getByUsername(String IDName) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM merchandise WHERE IDName = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, IDName);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				Merchandise mer = new Merchandise();
				mer.setID(rs.getString("id"));
				mer.setIDName(rs.getString("fullName"));
				mer.setProducer(rs.getString("username"));
				mer.setMerchandiseName(rs.getString("password"));
				mer.setQuantity(rs.getInt("Quantity"));
				mer.setPrice(rs.getInt("type"));
				return mer;
			} else return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}*/
	
	public boolean addMerchandise(Merchandise mer) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "INSERT INTO merchandise values(?,?,?,?,?,?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, mer.getID());
			prest.setString(2, mer.getIDName());
			prest.setString(3, mer.getProducer());
			prest.setString(4, mer.getMerchandiseName());
			prest.setInt(5, mer.getQuantity());
			prest.setInt(6, mer.getPrice());
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
			sql = "UPDATE merchandise SET idname = ?, producer = ?, merchandisename = ?, quantity = ?, price = ?"
					+ "WHERE id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, mer.getIDName());
			prest.setString(2, mer.getProducer());
			prest.setString(3, mer.getMerchandiseName());
			prest.setInt(4, mer.getQuantity());
			prest.setInt(5, mer.getPrice());
			prest.setString(6, mer.getID());
			if(prest.executeUpdate() >= 1 ) {
				return true;
			} else return false;
		} catch (Exception ex) {
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
	
	/*public boolean hasIDName(String IDName) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM IDName WHERE IDName = '" + IDName + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}*/
}

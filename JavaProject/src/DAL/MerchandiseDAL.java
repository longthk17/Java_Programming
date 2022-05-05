package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Employee;
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
				String ID = rs.getString("ID");
				String IDName = rs.getString("IDName");
				String Producer = rs.getString("username");
				String MerchandiseName = rs.getString("password");
				int Quantity = rs.getInt("Quantity");
				int Price = rs.getInt("Price");
				Merchandise mer = new Merchandise(ID, IDName, Producer, MerchandiseName, Quantity, Price);
				merList.add(mer);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return merList;
	}
	
	public static Merchandise getByUsername(String IDName) {
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
	}
	
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
			sql = "UPDATE merchandise SET IDName = ?, Producer = ?, MerchandiseName = ?, Quantity = ?, Price = ?"
					+ "WHERE id = ?";
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
	
	public boolean deleteMerchandise(String ID) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "DELETE FROM merchandise WHERE ID = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, ID);
			if(prest.executeUpdate()>=1) {
				return true;
			} else return false;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean hasMerchandiseID(String ID) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM merchandise WHERE ID = '" + ID + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean hasIDName(String IDName) {
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
	}
}

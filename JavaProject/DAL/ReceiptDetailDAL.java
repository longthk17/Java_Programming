package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import DTO.Customer;
import DTO.Employee;
import DTO.Merchandise;
import DTO.Receipt;
import DTO.ReceiptDetail;
import Utils.Date;
import Utils.MySQLConnUtils;

public class ReceiptDetailDAL {
	
	public ArrayList<ReceiptDetail> getReceiptDetailById(String recId) {
		ArrayList<ReceiptDetail> recDetailList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT receipt_detail.receipt_id, receipt.id, merchandise.merchandiseName, merchandise.producer, receipt_detail.quantity, merchandise.price, receipt_detail.amount, receipt_detail.merchandise_id "
					+ "FROM receipt_detail "
					+ "INNER JOIN merchandise ON merchandise.id = receipt_detail.merchandise_id "
					+ "INNER JOIN receipt ON receipt.id = receipt_detail.receipt_id WHERE receipt_id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, recId);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				int quantity = rs.getInt("quantity");
				long amount = rs.getLong("amount");
				long price = rs.getLong("price");
				String merchandiseId = rs.getString("merchandise_id");
				String receiptId = rs.getString("receipt_id");
				String merchandise = rs.getString("merchandiseName");
				String producer = rs.getString("producer");
				ReceiptDetail recDetail = new ReceiptDetail(id,quantity,amount,price,merchandiseId,receiptId,merchandise,producer);
				recDetailList.add(recDetail);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return recDetailList;
	}
	
	
	public static ReceiptDetail getMerchandiseByDetail(String name) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM receipt_detail INNER JOIN merchandise ON merchandise.id = receipt_detail.merchandise_id WHERE merchandise.merchandiseName = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				ReceiptDetail rec = new ReceiptDetail();
				rec.setId(rs.getString("id"));
				rec.setMerchandiseId(rs.getString("merchandise_id"));
				rec.setReceiptId(rs.getString("receipt_id"));
				rec.setQuantity(rs.getInt("quantity"));
				rec.setAmount(rs.getLong("amount"));
				return rec;
			} else return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean addOrder(Employee emp, String cusId, String recId) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			conn.setAutoCommit(false);
			String sql;
			sql = "INSERT INTO receipt values(?,?,?,?,?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, recId);
			prest.setString(2, emp.getId());
			prest.setString(3, cusId);
			java.sql.Date date = Date.getCurrentDatetime();
			prest.setDate(4, date);
			prest.setDate(5, null);
			if(prest.executeUpdate()>=1) {
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			} else {
				try {
					conn.rollback();
				} catch(SQLException ex1) {
					ex1.printStackTrace();
					return false;
				}
				return false;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean addMerchandiseOrder(Merchandise mer, String recId, int quantity) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			conn.setAutoCommit(false);
			String sql;
			sql = "INSERT INTO receipt_detail values(?,?,?,?,?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			String id = UUID.randomUUID().toString();
			prest.setString(1, id);
			prest.setString(2, mer.getId());
			prest.setString(3, recId);
			float amount = mer.getPrice() * quantity;
			prest.setInt(4, quantity);
			prest.setFloat(5, amount);
			if(prest.executeUpdate()>=1) {
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			} else {
				try {
					conn.rollback();
				} catch(SQLException ex1) {
					ex1.printStackTrace();
					return false;
				}
				return false;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean insertDetail(String merId, String recId, int quantity, long amount) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			conn.setAutoCommit(false);
			String sql;
			sql = "INSERT INTO receipt_detail values(?,?,?,?,?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			String id = UUID.randomUUID().toString();
			prest.setString(1,id);
			prest.setString(2,merId);
			prest.setString(3, recId);
			prest.setInt(4, quantity);
			prest.setLong(5, amount);
			conn.commit();
			conn.setAutoCommit(true);
			if(prest.executeUpdate()>=1) {
				return true;
			} else {
				try {
					conn.rollback();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
				return false;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean updateDetail(String recId, String merId, int quantity, long amount) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "UPDATE receipt_detail SET quantity = ?, amount = ? WHERE merchandise_id = ? AND receipt_id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setInt(1, quantity);
			prest.setLong(2, amount);
			prest.setString(3, merId);
			prest.setString(4, recId);
			if(prest.executeUpdate()>=1) {
				return true;
			} else {
				return false;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean hasMerchandiseDetail(String merId, String recId) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM receipt_detail WHERE merchandise_id = ? AND receipt_id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, merId);
			prest.setString(2, recId);
			ResultSet rs = prest.executeQuery();
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static int compareInventory(String merId) {
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
				return quantity;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return quantity;
	}
	
	
	//Lấy số lượng merchandise có trong receiptDetail
	public int getMerchandiseQuantity(String merId) {
		int quantity = 0;
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT quantity FROM receipt_detail WHERE merchandise_id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1,merId);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				quantity = rs.getInt("quantity");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return quantity;
	}
	
	public boolean deleteDetail(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql ="DELETE FROM receipt_detail WHERE id = ?";
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
}

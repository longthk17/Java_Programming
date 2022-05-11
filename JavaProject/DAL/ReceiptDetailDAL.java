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
	
	public ArrayList<ReceiptDetail> loadReceiptDetail(String recId) {
		ArrayList<ReceiptDetail> recDetailList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT receipt_detail.receipt_id, receipt.id, merchandise.merchandiseName, merchandise.producer, receipt_detail.quantity, merchandise.price, receipt_detail.amount, receipt_detail.merchandise_id FROM receipt_detail INNER JOIN merchandise ON merchandise.id = receipt_detail.merchandise_id INNER JOIN receipt ON receipt.id = receipt_detail.receipt_id WHERE receipt_id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				int quantity = rs.getInt("quantity");
				float amount = rs.getFloat("amount");
				float price = rs.getFloat("price");
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
				int price = rs.getInt("price");
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
	
	public ArrayList<Customer> getAllCustomer() {
		ArrayList<Customer> cusList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM customer";
			PreparedStatement prest = conn.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				java.sql.Date create_date = rs.getDate("create_date");
				java.sql.Date update_date = rs.getDate("update_date");
				Customer emp = new Customer(id, fullName, gender,  phone, email, address,create_date,update_date);
				cusList.add(emp);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return cusList;
	}
	
	public static Customer getByFullName(String fullName) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM customer WHERE fullName = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, fullName);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				Customer cus = new Customer();
				cus.setId(rs.getString("id"));
				cus.setFullName(rs.getString("fullName"));
				cus.setPhone(rs.getString("phone"));
				cus.setEmail(rs.getString("email"));
				cus.setAddress(rs.getString("address"));
				cus.setGender(rs.getString("gender"));
				cus.setCreateDate(rs.getDate("create_date"));
				cus.setUpdateDate(rs.getDate("update_date"));
				return cus;
			} else return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
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
				mer.setPrice(rs.getInt("price"));
				mer.setCreateDate(rs.getDate("create_date"));
				mer.setUpdateDate(rs.getDate("update_date"));
				return mer;
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
	
	public boolean deleteOrder(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "DELETE FROM receipt WHERE id = ?";
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

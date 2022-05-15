package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Employee;
import DTO.Receipt;
import Utils.Date;
import Utils.MySQLConnUtils;

public class ReceiptDAL {
	
	public ArrayList<Receipt> getAllReceipt() {
		ArrayList<Receipt> recList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT receipt.id, employee.fullName, customer.fullName, receipt.create_date, receipt.update_date "
					+ "FROM receipt "
					+ "INNER JOIN employee ON employee.id = receipt.employee_id "
					+ "INNER JOIN customer ON customer.id = receipt.customer_id";
			PreparedStatement prest = conn.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String empName = rs.getString(2);
				String cusName = rs.getString(3);
				java.sql.Date createDate = rs.getDate(4);
				java.sql.Date updateDate = rs.getDate(5);
				Receipt rec = new Receipt(id,empName,cusName,createDate,updateDate);
				recList.add(rec);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return recList;
	}
	
	public static ArrayList<Receipt> getByIdSearch(String recId) {
		ArrayList<Receipt> recList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT receipt.id, employee.fullName, customer.fullName, receipt.create_date, receipt.update_date "
					+ "FROM receipt "
					+ "INNER JOIN employee ON employee.id = receipt.employee_id "
					+ "INNER JOIN customer ON customer.id = receipt.customer_id "
					+ "WHERE receipt.id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, recId);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String empName = rs.getString(2);
				String cusName = rs.getString(3);
				java.sql.Date createDate = rs.getDate(4);
				java.sql.Date updateDate = rs.getDate(5);
				Receipt rec = new Receipt(id,empName,cusName,createDate,updateDate);
				recList.add(rec);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return recList;
	}
	
	public static ArrayList<Receipt> getByEmployeeDetailSearch(String name) {
		ArrayList<Receipt> recList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT receipt.id, employee.fullName, customer.fullName, receipt.create_date, receipt.update_date "
					+ "FROM receipt "
					+ "INNER JOIN employee ON employee.id = receipt.employee_id "
					+ "INNER JOIN customer ON customer.id = receipt.customer_id "
					+ "WHERE receipt.employee_id = "
					+ "(SELECT id FROM employee WHERE fullName = ?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String empName = rs.getString(2);
				String cusName = rs.getString(3);
				java.sql.Date createDate = rs.getDate(4);
				java.sql.Date updateDate = rs.getDate(5);
				Receipt rec = new Receipt(id,empName,cusName,createDate,updateDate);
				recList.add(rec);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return recList;
	}
	
	public static ArrayList<Receipt> getByCustomerDetailSearch(String name) {
		ArrayList<Receipt> recList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT receipt.id, employee.fullName, customer.fullName, receipt.create_date, receipt.update_date "
					+ "FROM receipt "
					+ "INNER JOIN employee ON employee.id = receipt.employee_id "
					+ "INNER JOIN customer ON customer.id = receipt.customer_id "
					+ "WHERE receipt.customer_id = "
					+ "(SELECT id FROM customer WHERE fullName = ?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String empName = rs.getString(2);
				String cusName = rs.getString(3);
				java.sql.Date createDate = rs.getDate(4);
				java.sql.Date updateDate = rs.getDate(5);
				Receipt rec = new Receipt(id,empName,cusName,createDate,updateDate);
				recList.add(rec);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return recList;
	}
	
	public boolean hasReceiptId(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM receipt WHERE id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, id);
			ResultSet rs = prest.executeQuery();
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean addReceipt(Employee emp, String cusId, String recId) {
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
	
	
	public boolean deleteReceipt(String id) {
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

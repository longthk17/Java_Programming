package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Customer;
import DTO.Employee;
import Utils.Date;
import Utils.Hashing;
import Utils.MySQLConnUtils;

public class CustomerDAL {
	
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
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Customer emp = new Customer(id, fullName, gender,  phone, email, address,createDate,updateDate);
				cusList.add(emp);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return cusList;
	}
	
	public static ArrayList<Customer> getByFullNameSearch(String name) {
		ArrayList<Customer> cusList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM customer WHERE fullName = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Customer cus = new Customer(id, fullName, gender,  phone, email, address,createDate,updateDate);
				cusList.add(cus);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return cusList;
	}
	
	public static ArrayList<Customer> getByIdSearch(String name) {
		ArrayList<Customer> cusList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM customer WHERE id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Customer cus = new Customer(id, fullName, gender,  phone, email, address,createDate,updateDate);
				cusList.add(cus);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return cusList;
	}
	
	public static ArrayList<Customer> getByPhoneSearch(String name) {
		ArrayList<Customer> cusList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM customer WHERE phone = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Customer cus = new Customer(id, fullName, gender,  phone, email, address,createDate,updateDate);
				cusList.add(cus);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return cusList;
	}
	

	public boolean addCustomer(Customer cus) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "INSERT INTO customer values(?,?,?,?,?,?,?,?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, cus.getId());
			prest.setString(2, cus.getFullName());
			prest.setString(3, cus.getGender());
			prest.setString(4, cus.getPhone());
			prest.setString(5, cus.getEmail());
			prest.setString(6, cus.getAddress());
			java.sql.Date date = Date.getCurrentDatetime();
			prest.setDate(7, date);
			prest.setDate(8, null);
			if(prest.executeUpdate()>=1 ) {
				return true;
			} else return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean updateCustomer(Customer cus) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "UPDATE customer SET fullName = ?, gender = ?, phone = ?, email = ?, address = ?, update_date = ?"
					+ "WHERE id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, cus.getFullName());
			prest.setString(2, cus.getGender());
			prest.setString(3, cus.getPhone());
			prest.setString(4, cus.getEmail());
			prest.setString(5, cus.getAddress());
			java.sql.Date date = Date.getCurrentDatetime();
			prest.setDate(6, date);
			prest.setString(7, cus.getId());
			if(prest.executeUpdate()>=1 ) {
				return true;
			} else return false;
			
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEmployee(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "DELETE FROM customer WHERE id = ?";
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
	public boolean hasCustomerId(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM CustomerDTO WHERE id = '" + id + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
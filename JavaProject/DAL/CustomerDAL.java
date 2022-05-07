package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Customer;
import Utils.Hashing;
import Utils.MySQLConnUtils;

public class CustomerDAL {
	public ArrayList<Customer> getAllCustomer() {
		ArrayList<Customer> empList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "insert into customer(id, fullName. gender, phone , email, address,create_date,update_date)";
			PreparedStatement prest = conn.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String create_date = rs.getString("create_date");
				String update_date = rs.getString("update_date");
				Customer emp = new Customer(id, fullName, gender,  phone, email, address,create_date,update_date);
				empList.add(emp);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return empList;
	}
	

	public boolean addCustomer(Customer emp) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "INSERT INTO CustomerDTO values(?,?,?,?,?,?,?,?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, emp.getId());
			prest.setString(2, emp.getFullName());
			prest.setString(3, emp.getGender());
			prest.setString(4, emp.getPhone());
			prest.setString(5, emp.getEmail());
			prest.setString(6, emp.getAddress());
			prest.setString(7, emp.getCreate_date());
			prest.setString(7, emp.getUpdate_date());
			if(prest.executeUpdate()>=1 ) {
				return true;
			} else return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEmployee(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "DELETE FROM CustomerDTO WHERE id = ?";
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
package DAL;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DTO.Employee;
import Utils.Hashing;
import Utils.MySQLConnUtils;
import Utils.Date;

public class EmployeeDAL {
	
	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> empList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM employee";
			PreparedStatement prest = conn.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String fullName = rs.getString("fullName");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String type = rs.getString("type");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Employee emp = new Employee(id, fullName, username, password, phone, type, gender, address, createDate, updateDate);
				empList.add(emp);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return empList;
	}
	
	public static ArrayList<Employee> getByFullName(String name) {
		ArrayList<Employee> empList = new ArrayList<>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM employee WHERE fullName = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String fullName = rs.getString("fullName");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String type = rs.getString("type");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				java.sql.Date createDate = rs.getDate("create_date");
				java.sql.Date updateDate = rs.getDate("update_date");
				Employee emp = new Employee(id, fullName, username, password, phone, type, gender, address, createDate, updateDate);
				empList.add(emp);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return empList;
	}
	
	public static Employee getByUsername(String username) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM employee WHERE username = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, username);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getString("id"));
				emp.setFullName(rs.getString("fullName"));
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setPhone(rs.getString("phone"));
				emp.setType(rs.getString("type"));
				emp.setGender(rs.getString("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setCreateDate(rs.getDate("create_date"));
				emp.setUpdateDate(rs.getDate("update_date"));
				return emp;
			} else return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean addEmployee(Employee emp) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "INSERT INTO employee values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, emp.getId());
			prest.setString(2, emp.getFullName());
			prest.setString(3, emp.getUsername());
			String hashPass = Hashing.getMd5(emp.getPassword());
			prest.setString(4, hashPass);
			prest.setString(5, emp.getPhone());
			prest.setString(6, emp.getType());
			prest.setString(7, emp.getGender());
			prest.setString(8, emp.getAddress());
			java.sql.Date date = Date.getCurrentDatetime();
			prest.setDate(9, date);
			prest.setDate(10, null);
			if(prest.executeUpdate()>=1 ) {
				return true;
			} else return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean updateEmployee(Employee emp) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "UPDATE employee SET fullName = ?, username = ?, password = ?, phone = ?, type = ?, gender = ?, address = ?, update_date = ?"
					+ "WHERE id = ?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, emp.getFullName());
			prest.setString(2, emp.getUsername());
			String hashPass = Hashing.getMd5(emp.getPassword());
			prest.setString(3, hashPass);
			prest.setString(4, emp.getPhone());
			prest.setString(5, emp.getType());
			prest.setString(6, emp.getGender());
			prest.setString(7, emp.getAddress());
			java.sql.Date date = Date.getCurrentDatetime();
			prest.setDate(8, date);
			prest.setString(9, emp.getId());
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
			sql = "DELETE FROM employee WHERE id = ?";
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
	
	public boolean hasEmployeeID(String id) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM employee WHERE id = '" + id + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean hasEmployeeUsername(String username) {
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM employee WHERE username = '" + username + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}

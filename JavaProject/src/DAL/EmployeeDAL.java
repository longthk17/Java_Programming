package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Employee;

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
				Employee emp = new Employee(id, fullName, username, password, phone, type, gender, address);
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
				return emp;
			} else return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}

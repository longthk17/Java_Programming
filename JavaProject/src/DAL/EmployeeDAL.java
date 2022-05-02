package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.Employee;

public class EmployeeDAL {
	
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

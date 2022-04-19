package exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.codec.digest.DigestUtils;

class User {
	String username, password;
	int id;
	
	public User() {
		
	}
	
	public User(String username, String password, int id) {
		this.username = username;
		this.password = password;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void getByUsername(String username) {
		try {
			Connection connection = MySQLConnUtils.getMySQLConnection();
			String sql;
			sql = "SELECT * FROM users WHERE Username = ?";
			PreparedStatement prest = connection.prepareStatement(sql);
			prest.setString(1, username);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				this.username = rs.getString(2);
				this.password = rs.getString(3);
				this.id = rs.getInt(1);
			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
}

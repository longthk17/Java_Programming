package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.Employee;
import Utils.Date;
import Utils.MySQLConnUtils;

public class ReceiptDAL {
	
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

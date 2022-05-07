package DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.CustomerDTO;

public class CustomerDAL {
	public ArrayList<CustomerDTO> getAllCustomerDTO() {
		ArrayList<CustomerDTO> empList = new ArrayList<>();
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
				CustomerDTO emp = new CustomerDTO(id, fullName, gender,  phone, email, address,create_date,update_date);
				empList.add(emp);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return empList;
	}
}

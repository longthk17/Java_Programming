package DTO;

import java.sql.Date;

public class Employee {
	
	String id, fullName, username, password, phone, type, gender, address;
	Date createDate, updateDate;
	
	public Employee() {
		
	}

	public Employee(String id, String fullName, String username, String password, String phone, String type,
			String gender, String address, Date createDate, Date updateDate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.type = type;
		this.gender = gender;
		this.address = address;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}

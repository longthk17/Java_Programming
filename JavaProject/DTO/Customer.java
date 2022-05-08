package DTO;

import java.sql.Date;

public class Customer {
	String id, fullName, gender,phone,email, address;
	Date createDate, updateDate;
	public Customer() {
}
	public Customer(String id, String fullName, String gender, String phone, String email,
			 String address,Date createDate, Date updateDate ) {
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.createDate=createDate;
		this.updateDate=updateDate;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
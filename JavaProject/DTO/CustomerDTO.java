package DTO;

public class CustomerDTO {
	String id, fullName, gender,phone,email, address,create_date,update_date;
	public CustomerDTO() {
}
	public CustomerDTO(String id, String fullName, String gender, String phone, String email,
			 String address,String create_date, String update_date ) {
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.create_date=create_date;
		this.update_date=update_date;
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
		this.gender= gender;
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
		this.email=email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	 public String getCreate_date() {
		 return create_date;
	 }
	 public void setCreate_date(String create_date) {
		 this.create_date=create_date;
	 }
	 public String getUpdate_date() {
		 return update_date;
	 }
	 public void setUpdate_date(String update_date) {
		 this.update_date=update_date;
	 }
	
}
		
package BUS;

import java.util.ArrayList;

import DAL.EmployeeDAL;
import DTO.Employee;

public class EmployeeBUS {
	
	EmployeeDAL empDAL = new EmployeeDAL();
	public ArrayList<Employee> getAllEmployee() {
		return empDAL.getAllEmployee();
	}
	
	public String addEmployee(Employee emp) {
		if(empDAL.hasEmployeeID(emp.getId())) {
			return "Mã NV đã tồn tại";
		} else if (empDAL.hasEmployeeUsername(emp.getUsername())) {
			return "Tài khoản đã tồn tại";
		} else if (empDAL.addEmployee(emp)) {
			return "Thêm thành công";
		} else {
			return "Thêm thất bại";
		}
	}
	
	public String updateEmployee(Employee emp) {
		if (empDAL.updateEmployee(emp)) {
			return "Cập nhật thành công";
		} else {
			return "Cập nhật thất bại";
		}
	}
	
	public String deleteEmployee(String id) {
		if(empDAL.hasEmployeeID(id) == false) {
			return "Mã NV không tồn tại";
		} else if(empDAL.deleteEmployee(id)) {
			return "Xóa thành công";
		} else {
			return "Xóa thất bại";
		}
	}

}

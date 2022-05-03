package BUS;

import java.util.ArrayList;

import DAL.EmployeeDAL;
import DTO.Employee;

public class EmployeeBUS {
	
	EmployeeDAL empDAL = new EmployeeDAL();
	public ArrayList<Employee> getAllEmployee() {
		return empDAL.getAllEmployee();
	}

}

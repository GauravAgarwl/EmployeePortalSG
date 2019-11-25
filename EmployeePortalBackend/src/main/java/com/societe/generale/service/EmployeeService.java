package com.societe.generale.service;

import java.util.List;

import com.societe.generale.model.EmployeeModel;

public interface EmployeeService {

	public List<EmployeeModel> findAll();
	
	public void save(EmployeeModel employeeModel);
}

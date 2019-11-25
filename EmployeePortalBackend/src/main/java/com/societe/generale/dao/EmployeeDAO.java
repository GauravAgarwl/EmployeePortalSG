package com.societe.generale.dao;

import java.util.List;

import com.societe.generale.model.EmployeeModel;

public interface EmployeeDAO {

	public List<EmployeeModel> findAll();
	
	public void save(EmployeeModel flashModel);
}

package com.societe.generale.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.generale.dao.EmployeeDAO;
import com.societe.generale.model.EmployeeModel;
import com.societe.generale.service.EmployeeService;



@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<EmployeeModel> findAll() {
		
		return employeeDAO.findAll();
	}
	
	@Override
	@Transactional
	public void save(EmployeeModel employeeModel) {
		employeeDAO.save(employeeModel);

	}


}

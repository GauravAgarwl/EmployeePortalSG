package com.societe.generale.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.societe.generale.dao.EmployeeDAO;
import com.societe.generale.model.EmployeeModel;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<EmployeeModel> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<EmployeeModel> theQuery = 
				currentSession.createQuery("from EmployeeModel order by first_name asc" , EmployeeModel.class);
		
		
		List<EmployeeModel> employeeModel =theQuery.getResultList();
		
		return employeeModel;
	}


	@Override
	public void save(EmployeeModel employeeModel) {
		
		Session currentSession= entityManager.unwrap(Session.class);
				
		currentSession.saveOrUpdate(employeeModel);	

	}

}


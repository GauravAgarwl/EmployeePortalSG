package com.societe.generale;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.societe.generale.dao.EmployeeDAO;
import com.societe.generale.model.EmployeeModel;
import com.societe.generale.service.impl.EmployeeServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Mock
	private EmployeeDAO employeeDAO;
	
	@Before
    public void init() {
         MockitoAnnotations.initMocks(this);
    }
	@Test
	public void getAllEmployeesTest() {
		List<EmployeeModel> list = new ArrayList<EmployeeModel>();
		EmployeeModel emp1 = new EmployeeModel(1,"Gaurav","Agarwal","M","R&D");
		EmployeeModel emp2 = new EmployeeModel(1,"Ankur","Agarwal","M","R&D");
		EmployeeModel emp3 = new EmployeeModel(1,"Abhishek","Agarwal","M","R&D");
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		when(employeeDAO.findAll()).thenReturn(list);
		
		List<EmployeeModel> empList = employeeService.findAll();
		assertEquals(3, empList.size());
		verify(employeeDAO, times(1)).findAll();
	}
	
	 @Test
	 public void createEmployeeTest()
	 {
		 EmployeeModel emp = new EmployeeModel(1,"Gaurav","Agarwal","M","R&D");
	         
		 employeeService.save(emp);
	         
	     verify(employeeDAO, times(1)).save(emp);
	 }
}

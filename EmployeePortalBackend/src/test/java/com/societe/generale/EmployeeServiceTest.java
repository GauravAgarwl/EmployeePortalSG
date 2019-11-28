package com.societe.generale;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
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
import com.societe.generale.model.EmployeeBuilder;
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
		Date testDate = new Date(01/01/1970);
		EmployeeModel emp1 = new EmployeeBuilder().setId(1).setFirstName("Gaurav").setLastName("Agarwal")
							.setDepartment("R&D").setGender("M").setDateOfBirth(testDate).getEmployee();
		
		EmployeeModel emp2 = new EmployeeBuilder().setId(1).setFirstName("Ankur").setLastName("Agarwal")
				.setDepartment("R&D").setGender("M").setDateOfBirth(testDate).getEmployee();

		EmployeeModel emp3 = new EmployeeBuilder().setId(1).setFirstName("Abhishek").setLastName("Agarwal")
				.setDepartment("R&D").setGender("M").setDateOfBirth(testDate).getEmployee();

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
		 Date testDate = new Date(01/01/1970);
		 EmployeeModel emp = new EmployeeBuilder().setId(1).setFirstName("Gaurav").setLastName("Agarwal")
					.setDepartment("R&D").setGender("M").setDateOfBirth(testDate).getEmployee();
		 
		 employeeService.save(emp);
	         
	     verify(employeeDAO, times(1)).save(emp);
	 }
}

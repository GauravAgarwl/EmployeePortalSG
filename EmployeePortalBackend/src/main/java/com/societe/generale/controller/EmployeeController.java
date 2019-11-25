package com.societe.generale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.societe.generale.model.EmployeeModel;
import com.societe.generale.model.User;
import com.societe.generale.service.EmployeeService;
import com.societe.generale.service.UserService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employeeDetails")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	 @Autowired
	 private UserService userService;
	 
	 private User user = new User();
	 
	@GetMapping("/getEmp")
	public List<EmployeeModel> findAll(){
		return employeeService.findAll();
	}
	
	@PostMapping("/register")
	public EmployeeModel addflashcard(@RequestBody  EmployeeModel employeeModel){
		
		employeeModel.setId(0);
		employeeService.save(employeeModel);
		user.setPassword(employeeModel.getLastName());
		user.setUsername(employeeModel.getFirstName());
		userService.save(user);
		return employeeModel;
	}
}

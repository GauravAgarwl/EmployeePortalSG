package com.societe.generale.model;

import java.sql.Date;

public class EmployeeBuilder {

	private int id;

	private String firstName;
		
	private String lastName;

	private String gender;

	private Date dateOfBirth;
	
	private String department;
	
	public EmployeeBuilder setId(int id)
	{
		this.id=id;
		return this;
	}
	public EmployeeBuilder setFirstName(String firstName)
	{
		this.firstName=firstName;
		return this;
	}
	public EmployeeBuilder setLastName(String lastName)
	{
		this.lastName=lastName;
		return this;
	}
	public EmployeeBuilder setGender(String gender)
	{
		this.gender=gender;
		return this;
	}
	public EmployeeBuilder setDepartment(String department)
	{
		this.department=department;
		return this;
	}
	public EmployeeBuilder setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth=dateOfBirth;
		return this;
	}
	
	public EmployeeModel getEmployee()
	{
		return new EmployeeModel(id, firstName, lastName, gender, department, dateOfBirth);
	}
	
}

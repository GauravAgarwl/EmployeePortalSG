package com.societe.generale.model;

public class UserBuilder {

	private int id;
    private String username;
    private String password;
    
    public UserBuilder setId(int id)
    {
    	this.id=id;
    	return this;
    }
    public UserBuilder setUsername(String username)
    {
    	this.username=username;
    	return this;
    }
    public UserBuilder setPassword(String password)
    {
    	this.password=password;
    	return this;
    }
    
    public User getUser()
    {
    	return new User(id, username, password);
    }
}

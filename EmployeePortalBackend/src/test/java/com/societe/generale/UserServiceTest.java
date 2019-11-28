package com.societe.generale;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.societe.generale.dao.UserDao;
import com.societe.generale.model.User;
import com.societe.generale.service.impl.UserServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserDao userDao;
	
	@Before
    public void init() {
         MockitoAnnotations.initMocks(this);
    }
	@Test
	public void saveUser()
	{
		User user = new User(1,"Lokesh","Gupta");
        
		userDao.save(user);
         
        verify(userDao, times(1)).save(user);
		
	}
	
	@Test
	public void findOneUser()
	{
		 when(userDao.findByUsername("Gaurav")).thenReturn(new User(1,"Lokesh","Gupta"));
         
		User user = userService.findOne("Gaurav");
		assertEquals("Lokesh", user.getUsername());
	}

}

package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.UserDAO;

import com.niit.model.User;



public class UserTest {
static UserDAO userDAO;
	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		// SessionFactory
		// sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		userDAO=(UserDAO)configApplnContext.getBean("userDAO");	}


@Test
public void addUserTest()
{
    User user=new User();
    user.setName("Rohan");
    user.setPhone("8897456125");
    user.setAddress("Sion");
    user.setCountry("India");
    user.setPassword("123");
    user.setRole("Admin");
     
    assertTrue(userDAO.updateUser(user));    
}
}
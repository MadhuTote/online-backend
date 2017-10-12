package com.niit.Dao;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.*;
import com.niit.model.*;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	/*public void insertUser(User user)
	{
		Session session=sessionFac.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		
	}*/
	
/*@Autowired

public UserDaoImpl (SessionFactory sessionFactory)
{
	super();
	sessionFac=sessionFactory;
}*/
@Transactional
public boolean addUser(User user) {
	try
    {
    sessionFactory.getCurrentSession().save(user);
    return true;
    }
    catch(Exception e)
    {
    return false;
    }
	
}
@Transactional
public boolean updateUser(User user) {
	 try
     {
     sessionFactory.getCurrentSession().saveOrUpdate(user);
     return true;
     }
     catch(Exception e)
     {
     System.out.println("Exception Arised:"+e);
     return false;
     }
	
}
}

package com.niit.Dao;
import java.util.List;

import com.niit.model.*;

public interface  UserDAO
{
//public void insertUser  (User user);
	public boolean addUser(User user);
	public boolean updateUser(User user);
	
}

package fi.ThirdSpringJDBC.dao;

import java.util.Iterator;

import fi.ThirdSpringJDBC.beans.Users;

public interface UsersDao {

	public boolean registerUser(String userName, String password
			,String name, String email);
	
	public boolean changePassword(String userName, String password);
	
	public Users getUserDetails(String Username);
	
	public Iterator<Users> getAllUsers();
	
	
	
}

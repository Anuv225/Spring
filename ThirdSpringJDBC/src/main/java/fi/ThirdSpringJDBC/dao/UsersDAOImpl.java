package fi.ThirdSpringJDBC.dao;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import fi.ThirdSpringJDBC.beans.Users;
import jakarta.annotation.PostConstruct;

@Component
public class UsersDAOImpl implements UsersDao{
	
	@Autowired
	Environment env;
	
	JdbcTemplate jdbc;
	
	String sqlRegister;
	String sqlChangePassword;
	String sqlGetUserDetails;
	String sqlGetAllUsers;
	
	
	@PostConstruct
	public void initialize() {
		
		sqlRegister = env.getProperty("sql.registration");
		sqlChangePassword = env.getProperty("sql.changepassword");
		sqlGetUserDetails = env.getProperty("sql.allusers");
		sqlGetAllUsers = env.getProperty("sql.userdetails");
		
	}

	@Override
	public boolean registerUser(String userName, String password, String name, String email) {
		
		jdbc.update(sqlRegister,userName,password,name,email);
		return true;
	}

	@Override
	public boolean changePassword(String userName, String password) {
		jdbc.update(sqlChangePassword,userName,password);
		return true;
	}

	@Override
	public Users getUserDetails(String Username) {
		
		return null;
	}

	@Override
	public Iterator<Users> getAllUsers() {
		
		return jdbc.query(sqlGetAllUsers, new UsersRowMapper()).iterator();
	}

}

package fi.SecondSpring.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("objUsers")
public class Users {

	
	String userName;
	String password;
	
	public Users() {
		
	}
	
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("initialize post the "
				+ "construction of the userObj");
		
	}
	
	@PreDestroy
	public void preDestruct() {
		System.out.println("This method is fired before the destruction of object");
	}
	
	
	
	
}

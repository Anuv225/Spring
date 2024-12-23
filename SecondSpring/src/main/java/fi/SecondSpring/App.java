package fi.SecondSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fi.SecondSpring.beans.Users;
import fi.SecondSpring.config.AppConfig;


public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	
    	try(AnnotationConfigApplicationContext applicationContext = 
    			new AnnotationConfigApplicationContext(AppConfig.class);)
    	{
    		Users userObj = (Users) applicationContext.getBean("objUsers");
        	
        	userObj.setPassword("123456");
        	userObj.setUserName("Anuvind");
        	
        	System.out.println(userObj.getUserName());
        	System.out.println(userObj.getPassword());
        	
        	
        	Users secondUserObj = (Users) applicationContext.getBean("objUsers");
        	
        	System.out.println(secondUserObj.getUserName());
        	System.out.println(secondUserObj.getPassword());
    	
    	
    	}
    	
    }
}

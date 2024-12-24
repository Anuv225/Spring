package fi.ThirdSpringJDBC;

import java.util.Iterator;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fi.ThirdSpringJDBC.beans.Users;
import fi.ThirdSpringJDBC.config.AppConfig;
import fi.ThirdSpringJDBC.dao.UsersDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(AnnotationConfigApplicationContext applicationContext =
        		new AnnotationConfigApplicationContext(AppConfig.class);
        		Scanner sc = new Scanner(System.in);){
        	
        	UsersDao dao  = (UsersDao)applicationContext.getBean("usersDao");
        	
        	Iterator<Users> allUsers = dao.getAllUsers();
        	
        	while(allUsers.hasNext()) {
        		Users objUser = allUsers.next();
        		System.out.println(objUser);
        	}
        	
        }
    }
}

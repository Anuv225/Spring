package fi.SpringFirst;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext applicationContext = 
    			new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	Users user = applicationContext.getBean(Users.class);
    	
    	user.setPassword("SuperSecretPassword");
    	user.setUserName("Anuvind");
    	
    	System.out.println(user);
    	
    	applicationContext.close();
    	
    	
    	
    }
}

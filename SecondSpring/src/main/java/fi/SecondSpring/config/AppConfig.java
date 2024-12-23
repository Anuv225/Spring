package fi.SecondSpring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import fi.SecondSpring.beans.Users;

@Configuration
@ComponentScan(basePackages= {"fi.SecondSpring"})
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Bean
	@Scope(scopeName="prototype")
	public Users objUsers(@Value("${default.username}") String user,
			@Value("${default.password}")
	String pwd) {
		return new Users(user,pwd);
	}
	
	
	
	
}

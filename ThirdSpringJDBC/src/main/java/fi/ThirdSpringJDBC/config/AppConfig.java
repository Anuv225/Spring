package fi.ThirdSpringJDBC.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fi.ThirdSpringJDBC.dao.UsersDAOImpl;
import fi.ThirdSpringJDBC.dao.UsersDao;



@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public DataSource dataSource() {
		
		String url = env.getProperty("db.connection.url");
		String user  = env.getProperty("db.connection.username");
		String  pwd = env.getProperty("db.connection.password");
		String driver = env.getProperty("db.connection.driver");
		
		DriverManagerDataSource ds = 
				new DriverManagerDataSource();
		
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setPassword(pwd);
		ds.setUsername(user);
		
		return ds;
		
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public UsersDao usersDao() {
		return new UsersDAOImpl();
	}
	
	
	

}

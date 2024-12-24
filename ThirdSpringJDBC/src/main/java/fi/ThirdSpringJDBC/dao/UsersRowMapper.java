package fi.ThirdSpringJDBC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.ThirdSpringJDBC.beans.Users;

public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Users objUser = new Users();
		
		objUser.setUserName(rs.getString("username"));
		objUser.setPassword(rs.getString("password"));
		objUser.setEmail(rs.getString("email"));
		objUser.setName(rs.getString("name"));
		
		return objUser;
	}

}

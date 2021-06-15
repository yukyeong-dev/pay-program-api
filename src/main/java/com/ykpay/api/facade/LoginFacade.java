package com.ykpay.api.facade;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ykpay.api.user.model.User;

public class LoginFacade {
	
	public ArrayList<User> loginQuery(String id, String pw, JdbcTemplate template) {
		RowMapper<User> dto = new BeanPropertyRowMapper<User>(User.class);
		return (ArrayList<User>) template.query("select * from user_table where user_id = '"+id+"' and user_password ='"+pw+"'" , dto);
	}
	
	

}

package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserCountFacade {
	
	public String userCountQuery(JdbcTemplate template, String sessionId , String productConnect) {
		return template.queryForObject("select count(*) from order_table where user_id = '"+sessionId+"' and product_connect = '"+productConnect+"' ",String.class);
		
	}
}

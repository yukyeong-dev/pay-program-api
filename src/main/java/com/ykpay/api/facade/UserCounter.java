package com.ykpay.api.facade;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ykpay.api.product.model.Counter;

public class UserCounter {
	
	public ArrayList<Counter> userCounterQuery(JdbcTemplate template, String productConnect) {
		RowMapper<Counter> dto = new BeanPropertyRowMapper<Counter>(Counter.class);
		 ArrayList<Counter> b = (ArrayList<Counter>) template.query("SELECT product_price FROM productprb_table where product_connect='"+productConnect+"' ", dto);
		
		 
		 
		 
		 
		 
		 return b;
		
	}

}

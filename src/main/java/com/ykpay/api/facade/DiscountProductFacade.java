package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

public class DiscountProductFacade {
	
	public void discountProductUpdateQuery(JdbcTemplate template,String productPrice, String productCode) {
		template.update("update productprb_table set product_price='"+productPrice+"' where product_code = '"+productCode+"'");
	}

}

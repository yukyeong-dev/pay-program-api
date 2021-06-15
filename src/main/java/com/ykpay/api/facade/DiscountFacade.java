package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

public class DiscountFacade {
	
	public int saleTableUpdateQuery(JdbcTemplate template,String productCode,String start, String end,String persent) {
		System.out.println("3들어옴");
		System.out.println("리문은 : "+"update productprbsale_table set sale_start='"+start+"', sale_end='"+end+"', sale_rate='"+persent+"' where product_code='"+productCode+"'" );
		return template.update("update productprbsale_table set sale_start='"+start+"', sale_end='"+end+"', sale_rate='"+persent+"' where product_code='"+productCode+"' ");
		
	}

}

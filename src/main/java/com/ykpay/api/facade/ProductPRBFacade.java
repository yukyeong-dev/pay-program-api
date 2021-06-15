package com.ykpay.api.facade;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ykpay.api.product.model.ProductPRB;

public class ProductPRBFacade {
	
	public ArrayList<ProductPRB> productPRBQuery(JdbcTemplate template) {
		RowMapper<ProductPRB> dto = new BeanPropertyRowMapper<ProductPRB>(ProductPRB.class);
		return (ArrayList<ProductPRB>) template.query("select a.product_oldprice, a.product_connect, a.product_code, a.product_name, a.product_explain, a.product_price, a.product_barcode, a.productImgUrl, ifnull(b.sale_start,'') as sale_start, ifnull(b.sale_end,'') as sale_end, ifnull(b.sale_rate,'') sale_rate from productprb_table as a LEFT OUTER JOIN productprbsale_table AS b ON a.product_code = b.product_code order by a.product_code", dto);
	}

}

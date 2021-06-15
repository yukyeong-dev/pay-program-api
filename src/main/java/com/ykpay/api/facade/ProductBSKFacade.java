package com.ykpay.api.facade;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ykpay.api.product.model.ProductBSK;

public class ProductBSKFacade {

	public ArrayList<ProductBSK> productBSKQuery(JdbcTemplate template) {
		RowMapper<ProductBSK> dto = new BeanPropertyRowMapper<ProductBSK>(ProductBSK.class);
		return (ArrayList<ProductBSK>)template.query("select a.product_oldprice, a.product_code, a.product_name, a.product_explain, a.product_price, a.product_barcode, a.productImgUrl from productbsk_table a, store_table b where b.store_code = a.product_connect", dto);
		
	}
	
}

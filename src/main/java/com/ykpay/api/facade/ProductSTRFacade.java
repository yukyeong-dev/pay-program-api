package com.ykpay.api.facade;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ykpay.api.product.model.ProductSTR;

public class ProductSTRFacade {

	public ArrayList<ProductSTR> productSTRQuery(JdbcTemplate template) {
		RowMapper<ProductSTR> dto = new BeanPropertyRowMapper<ProductSTR>(ProductSTR.class);
		return (ArrayList<ProductSTR>)template.query("select a.product_oldprice, a.product_code, a.product_name, a.product_explain, a.product_price, a.product_barcode, a.productImgUrl from productstr_table a, store_table b where b.store_code = a.product_connect", dto);
	}

}

package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ykpay.api.util.GetToday;

public class OrderInsertOrderTable {
	GetToday today = new GetToday();

	public void orderInsertOrderQuery(JdbcTemplate template,String sessionId, String address, int totalPoint, String productName, int productPrice, String productCode, String productBarcode, int amount, int sum, String productConnect) {
		template.update("insert into order_table (user_id, user_address, totalPoint, product_name,product_price,product_code,product_barcode,amount,point_sum,regdate,product_connect) values ('"+sessionId+"','"+address+"','"+totalPoint+"','"+productName+"','"+productPrice+"','"+productCode+"','"+productBarcode+"','"+amount+"','"+sum+"','"+today.getToday()+"','"+productConnect+"')");
		
	}

}

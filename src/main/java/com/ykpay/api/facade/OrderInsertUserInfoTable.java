package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ykpay.api.util.GetToday;

public class OrderInsertUserInfoTable {
	GetToday today = new GetToday();

	public int orderInsertUserInfoQuery(JdbcTemplate template, String sessionId, String address, int totalPoint,String productName, int productPrice, String productCode, String productBarcode, int amount, int sum,String productConnect) {
		return template.update("insert into userInfo_order_table (user_id, user_address, totalPoint, product_name, product_price, product_code, product_barcode, amount, point_sum, point_remain, regdate, product_connect)	values ('"+sessionId+"','"+address+"','"+totalPoint+"','"+productName+"','"+productPrice+"','"+productCode+"','"+productBarcode+"','"+amount+"','"+sum+"',totalPoint-point_sum,'"+today.getToday()+"','"+productConnect+"')");
	}

}

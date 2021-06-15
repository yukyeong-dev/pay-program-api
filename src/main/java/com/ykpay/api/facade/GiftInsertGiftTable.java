package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ykpay.api.util.GetToday;

public class GiftInsertGiftTable {
	GetToday today = new GetToday();

	public int giftInsertGiftQuery(JdbcTemplate template, String sessionId, String phoneNumber, int totalPoint, String productName, int productPrice, String productCode, String productBarcode, int amount, int sum) {
		return template.update("insert into gift_table (user_id, phoneNumber,totalPoint, product_name,product_price,product_code,product_barcode,amount,point_sum,regdate) values ('"+sessionId+"','"+phoneNumber+"','"+totalPoint+"','"+productName+"','"+productPrice+"','"+productCode+"','"+productBarcode+"','"+amount+"','"+sum+"','"+today.getToday()+"')");
	}

}

package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ykpay.api.util.GetToday;

public class GiftInsertUserInfoGiftTable {
	GetToday today = new GetToday();

	public int giftInsertUserInfoGiftQuery(JdbcTemplate template, String sessionId, String phoneNumber, int totalPoint, String productName, int productPrice, String productCode, String productBarcode, int amount, int sum) {
		return template.update("insert into userInfo_gift_table (user_id, phoneNumber, totalPoint, product_name, product_price, product_code, product_barcode, amount, point_sum, point_remain, regdate) values ('"+sessionId+"','"+phoneNumber+"','"+totalPoint+"','"+productName+"','"+productPrice+"','"+productCode+"','"+productBarcode+"','"+amount+"','"+sum+"',totalPoint-point_sum,'"+today.getToday()+"')");
	}

}

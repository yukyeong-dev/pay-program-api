package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ykpay.api.util.GetToday;

public class OrderUpdateChargingTable {
	GetToday today = new GetToday();

	public void orderUpdateChargingQuert(JdbcTemplate template,String sessionId,int sum) {
		template.update("update charging_table set total_point=total_point-'"+sum+"', charging_point=charging_point-'"+sum+"',charging_regdate='"+today.getToday()+"' where connection_user = '"+sessionId+"'");
	}

}

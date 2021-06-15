package com.ykpay.api.facade;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ykpay.api.util.GetToday;

public class ChargingCheckUpdateChargingQueryTable {
	GetToday today = new GetToday();
	
	public int chargingCheckUpdateChargingQuery(JdbcTemplate template, int chargingPoint,GetToday today,String sessionId) {
		return template.update("update charging_table set charging_point = charging_point+ '"+chargingPoint+"', total_point = total_point+ '"+chargingPoint+"', charging_regdate= '"+today.getToday()+"' where connection_user ='"+sessionId+"' ");
	}

}

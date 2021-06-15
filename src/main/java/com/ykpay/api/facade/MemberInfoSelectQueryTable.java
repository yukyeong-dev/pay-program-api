package com.ykpay.api.facade;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ykpay.api.member.model.MemberOrder;

public class MemberInfoSelectQueryTable {

	public ArrayList<MemberOrder> memberInfoSelectQuery(JdbcTemplate template, String sessionId) {
		RowMapper<MemberOrder> dto = new BeanPropertyRowMapper<MemberOrder>(MemberOrder.class);
		return (ArrayList<MemberOrder>) template.query("select * from userinfo_order_table where user_id = '"+sessionId+"'", dto);
		
	}

}

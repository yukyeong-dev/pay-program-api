package com.ykpay.api.facade;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ykpay.api.member.model.MemberGift;

public class MemberInfoGiftSelectQueryTable {

	public ArrayList<MemberGift> memberInfoGiftSelectQuery(JdbcTemplate template, String sessionId) {
		RowMapper<MemberGift> dto = new BeanPropertyRowMapper<MemberGift>(MemberGift.class);
		return (ArrayList<MemberGift>) template.query("select * from userinfo_gift_table where user_id = '"+sessionId+"'", dto);		
	}

}

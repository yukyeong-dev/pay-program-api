package com.ykpay.api.facade;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ykpay.api.charging.model.Charging;

public class ChargingFacade {

	public Charging chargingQuery(JdbcTemplate template) {
		RowMapper<Charging> dto = new BeanPropertyRowMapper<Charging>(Charging.class);
		return template.queryForObject("SELECT * FROM charging_table", dto);
	}
}

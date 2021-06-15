package com.ykpay.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ykpay.api.charging.model.Charging;
import com.ykpay.api.facade.MainFacade;
import com.ykpay.api.util.GetToday;

@RestController
public class ChargingController {
	GetToday today = new GetToday();
	MainFacade facade = new MainFacade();
	
	@Autowired
	public JdbcTemplate template;	
	
	
	//나의 충전된 포인트를 조회 해온다
	@RequestMapping(value = "charging", method = RequestMethod.GET)
	public ArrayList<Charging> charging() {				
		ArrayList<Charging> result = new ArrayList<Charging>();
		result.add(facade.charging(template));
		return result;	
	}
	
	//충전하기 를 눌렀을 때 금액을 충전해준다.
	@RequestMapping(value = "chargingCheck", method = {RequestMethod.POST,RequestMethod.GET})
	public int chargingCheck(@RequestParam(value="chargingPoint",required=false,defaultValue="0")int chargingPoint,@RequestParam(value="sessionId",required=false,defaultValue="0")String sessionId){
		return facade.chargingCheck(template,chargingPoint,today,sessionId);
	}
	
}
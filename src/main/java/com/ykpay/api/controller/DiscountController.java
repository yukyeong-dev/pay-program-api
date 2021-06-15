package com.ykpay.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ykpay.api.facade.MainFacade;

@RestController
public class DiscountController {
	MainFacade facade = new MainFacade();
	
	@Autowired
	public JdbcTemplate template;	
	
	//세일 적용하기 눌렀을 때
	@RequestMapping(value="discount", method={RequestMethod.GET,RequestMethod.POST})
	public int discount(@RequestParam(value="productCode",required=false, defaultValue="0")String productCode,@RequestParam(value="start",required=false, defaultValue="0")String start,@RequestParam(value="end",required=false, defaultValue="0")String end,@RequestParam(value="persent",required=false, defaultValue="0")String persent) {
		return facade.discountUpdate(template,productCode,start,end,persent);
	}
	
}

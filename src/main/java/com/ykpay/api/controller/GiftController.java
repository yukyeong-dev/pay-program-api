package com.ykpay.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ykpay.api.facade.MainFacade;

@RestController
public class GiftController {
	MainFacade facade = new MainFacade();
	
	@Autowired
	public JdbcTemplate template;	
	
	
	//결제내역 저장하기
	@RequestMapping(value = "gift", method = {RequestMethod.POST,RequestMethod.GET})
	public int giftCheck(@RequestParam(value="sessionId",required=false,defaultValue="0")String sessionId,@RequestParam(value="phoneNumber",required=false,defaultValue="0")String phoneNumber,@RequestParam(value="totalPoint",required=false,defaultValue="0")int totalPoint,@RequestParam(value="productName",required=false,defaultValue="0")String productName,@RequestParam(value="productPrice",required=false,defaultValue="0")int productPrice,@RequestParam(value="productCode",required=false,defaultValue="0")String productCode,@RequestParam(value="productBarcode",required=false,defaultValue="0")String productBarcode,@RequestParam(value="amount",required=false,defaultValue="0")int amount,@RequestParam(value="sum",required=false,defaultValue="0")int sum){
		return facade.giftCheck(template, sessionId, phoneNumber, totalPoint, productName, productPrice, productCode, productBarcode, amount, sum);
	}
}

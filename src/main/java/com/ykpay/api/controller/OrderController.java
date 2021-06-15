package com.ykpay.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ykpay.api.facade.MainFacade;

@RestController
public class OrderController {
	MainFacade facade= new MainFacade();
	
	@Autowired
	public JdbcTemplate template;	
	
	
	//구매한적이 있다면
	@RequestMapping(value="userCount", method= {RequestMethod.POST, RequestMethod.GET})
	public String userCount(@RequestParam(value="sessionId",required=false,defaultValue="0")String sessionId,@RequestParam(value="productConnect",required=false,defaultValue="0")String productConnect) {
		return facade.userCount(template, sessionId, productConnect);	
		
		//원가격과 할인률과 
	}
	
	
	//결제내역 저장하기 - 할인률이 있다면과 없다면으로 나눠주기
	@RequestMapping(value = "order", method = {RequestMethod.POST,RequestMethod.GET})
	public int chargingCheck(@RequestParam(value="sessionId",required=false,defaultValue="0")String sessionId,@RequestParam(value="address",required=false,defaultValue="0")String address,@RequestParam(value="totalPoint",required=false,defaultValue="0")int totalPoint,@RequestParam(value="productName",required=false,defaultValue="0")String productName,@RequestParam(value="productPrice",required=false,defaultValue="0")int productPrice,@RequestParam(value="productCode",required=false,defaultValue="0")String productCode,@RequestParam(value="productBarcode",required=false,defaultValue="0")String productBarcode,@RequestParam(value="amount",required=false,defaultValue="0")int amount,@RequestParam(value="sum",required=false,defaultValue="0")int sum,@RequestParam(value="apply",required=false,defaultValue="0")int apply,@RequestParam(value="productConnect",required=false,defaultValue="0")String productConnect){
		if(apply > 0) {
					
			//여기서 할인률 가져와서 계산해주고 update해주기
			//토탈금액//
			double percentage1 =  apply * 0.01;				//할인률나옴
			double money1 = sum * percentage1;				//할인받는 금액
			double total_money1 = sum - money1;				//총 지불 금액
			int total_sum = Integer.parseInt(String.valueOf(Math.round(total_money1)));
			
			//상품금액//
			double percentage2 =  apply * 0.01;				//할인률나옴
			double money2 = sum * percentage2;				//할인받는 금액
			double total_money2 = sum - money2;				//총 지불 금액
			int total_productPrice = Integer.parseInt(String.valueOf(Math.round(total_money2)));
			
			
			return facade.orderCheck(template, sessionId, address, totalPoint, productName, total_productPrice, productCode, productBarcode, amount, total_sum, productConnect);
		}else {
			return facade.orderCheck(template, sessionId, address, totalPoint, productName, productPrice, productCode, productBarcode, amount, sum,productConnect);
		}
		
	}
	
}

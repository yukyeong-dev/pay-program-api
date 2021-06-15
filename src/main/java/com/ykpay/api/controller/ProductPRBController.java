package com.ykpay.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ykpay.api.facade.MainFacade;
import com.ykpay.api.product.model.ProductPRB;

@RestController
public class ProductPRBController {
	MainFacade facade = new MainFacade();
	
	@Autowired
	public JdbcTemplate template;
	
	
	@RequestMapping(value="productPRB", method = {RequestMethod.POST,RequestMethod.GET})
	public ArrayList<ProductPRB> productapi(@RequestParam(value="start",required=false,defaultValue="0")String start,@RequestParam(value="end",required=false,defaultValue="0")String end,@RequestParam(value="persent",required=false,defaultValue="0")String persent,@RequestParam(value="productPrice",required=false,defaultValue="0")String productPrice,@RequestParam(value="productCode",required=false,defaultValue="0")String productCode,@RequestParam(value="productOldprice",required=false,defaultValue="0")String productOldprice) throws ParseException {		

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		if(start.equals("0")&&end.equals("0")&&persent.equals("0")) {
System.out.println("aaaaaaaaaaa");
			return facade.productPRB(template);
		}else {
System.out.println("bbbbbbbbbb");		
		Date date = new Date();					//현재시간
		Date start_time = format.parse(start);	//시작일
		Date end_time = format.parse(end);		//종료일
		
		
			if(date.getTime() >= start_time.getTime() && date.getTime() <= end_time.getTime()) {
System.out.println("cccccccccccccc");
				double percentage = Integer.parseInt(persent) * 0.01;				//할인율
				double money = Integer.parseInt(productPrice) * percentage;			//할인받는 금액
				double total_money = Integer.parseInt(productPrice) - money;		//최종지불 금액
				String total = Double.toString(total_money);
		
				return facade.discountproduct(template, total, productCode);
				
				
			}else {//기간이 끝나면 다시 원가격으로 되돌아와야한다. 
System.out.println("ddddddddddddd");		
				
	/*			//productOldprice		
				double percentage = Integer.parseInt(persent) * 0.01;				//할인율
				double money = Integer.parseInt(productPrice) * percentage;			//할인받는 금액
				double total_money = Integer.parseInt(productPrice) - money;		//최종지불 금액
				String total = Double.toString(total_money);*/
				
				return facade.discountproduct(template, productOldprice, productCode);
			}
		}
	}
	
			
}







package com.ykpay.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ykpay.api.facade.MainFacade;
import com.ykpay.api.product.model.ProductSTR;

@RestController
public class ProductSTRController {
	MainFacade facade = new MainFacade();
	
	@Autowired
	public JdbcTemplate template;
	
	
	@RequestMapping(value="productSTR", method = RequestMethod.GET)
	public ArrayList<ProductSTR> productSTR(){
		return facade.productSTR(template);
	}
}

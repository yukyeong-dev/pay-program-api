package com.ykpay.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ykpay.api.facade.MainFacade;
import com.ykpay.api.user.model.User;

@RestController
public class LoginController {	
	public MainFacade facade = new MainFacade();
	
	@Autowired
	public JdbcTemplate template;
	
	@RequestMapping(method= {RequestMethod.POST,RequestMethod.GET},value="/login")
	public ArrayList<User> login(@RequestParam(value="userId",required=false,defaultValue="0")String id, @RequestParam(value="userPw",required=false,defaultValue="0")String pw)throws IOException{
		System.out.println("서버 아이디: "+id);
		System.out.println("서버 비번: "+pw);
		System.out.println("서버 템플릿: "+template);
		return facade.loginStart(id, pw, template);
	}

}

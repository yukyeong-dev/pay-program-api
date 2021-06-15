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
import com.ykpay.api.member.model.MemberGift;
import com.ykpay.api.member.model.MemberOrder;

@RestController
public class MemberInfoController {	
	public MainFacade facade = new MainFacade();
	
	@Autowired
	public JdbcTemplate template;
	
	
	//유저정보 - 구매내역
	@RequestMapping(value="/memberMyInfoOrder", method= {RequestMethod.POST,RequestMethod.GET})
	public ArrayList<MemberOrder> memberMyInfoOrder(@RequestParam(value="userId",required=false,defaultValue="0")String id)throws IOException{
		return facade.memberInfo(template, id);
	}
	
	
	
	//유저정보 - 선물내역
	@RequestMapping(value="/memberMyInfoGift", method = {RequestMethod.POST, RequestMethod.GET})
	public ArrayList<MemberGift> memberMyInfoGift(@RequestParam(value="userId",required=false,defaultValue="0")String id)throws IOException{
		return facade.memberInfoGift(template, id);
	}
	
}

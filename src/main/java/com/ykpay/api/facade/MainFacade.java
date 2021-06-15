package com.ykpay.api.facade;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ykpay.api.charging.model.Charging;
import com.ykpay.api.member.model.MemberGift;
import com.ykpay.api.member.model.MemberOrder;
import com.ykpay.api.product.model.Counter;
import com.ykpay.api.product.model.ProductBSK;
import com.ykpay.api.product.model.ProductPRB;
import com.ykpay.api.product.model.ProductSTR;
import com.ykpay.api.user.model.User;
import com.ykpay.api.util.GetToday;

public class MainFacade {
		
	public MainFacade() {
	}

	public LoginFacade loginFacade = new LoginFacade();
	public ChargingFacade chargingFacade = new ChargingFacade();
	public ChargingCheckUpdateChargingQueryTable chargingCheckUpdateChargingTable = new ChargingCheckUpdateChargingQueryTable();
	public ProductPRBFacade productPRBFacade = new ProductPRBFacade();
	public ProductBSKFacade productBSKFacade = new ProductBSKFacade();
	public ProductSTRFacade productSTRFacade = new ProductSTRFacade();
	public OrderInsertOrderTable orderInsertOrderTable = new OrderInsertOrderTable();
	public OrderInsertUserInfoTable orderInsertUserInfoTable = new OrderInsertUserInfoTable();
	public OrderUpdateChargingTable orderUpdateChargingTable = new OrderUpdateChargingTable();
	public GiftInsertGiftTable giftInsertGiftTable = new GiftInsertGiftTable();
	public GiftInsertUserInfoGiftTable giftInsertUserInfoGiftTable = new GiftInsertUserInfoGiftTable();
	public MemberInfoSelectQueryTable memberInfoSelectQueryTable = new MemberInfoSelectQueryTable();
	public MemberInfoGiftSelectQueryTable memberInfoGiftSelectQueryTable = new MemberInfoGiftSelectQueryTable();
	public DiscountFacade discountFacade = new DiscountFacade();
	public DiscountProductFacade discountProductFacade = new DiscountProductFacade();
	public UserCountFacade userCountFacade = new UserCountFacade();
	public UserCounter userCounter = new UserCounter();

	
	
	public MainFacade(LoginFacade loginFacade, ChargingFacade chargingFacade,ChargingCheckUpdateChargingQueryTable chargingCheckUpdateChargingTable,ProductPRBFacade productPRBFacade,ProductBSKFacade productBSKFacade,ProductSTRFacade productSTRFacade,OrderInsertOrderTable orderInsertOrderTable,OrderInsertUserInfoTable orderInsertUserInfoTable,OrderUpdateChargingTable orderUpdateChargingTable,GiftInsertGiftTable giftInsertGiftTable, GiftInsertUserInfoGiftTable giftInsertUserInfoGiftTable, MemberInfoSelectQueryTable memberInfoSelectQueryTable,MemberInfoGiftSelectQueryTable memberInfoGiftSelectQueryTable,DiscountFacade discountFacade,DiscountProductFacade discountProductFacade,UserCountFacade userCountFacade,UserCounter userCounter) {
		this.loginFacade = loginFacade;
		this.chargingFacade = chargingFacade;
		this.chargingCheckUpdateChargingTable = chargingCheckUpdateChargingTable;
		this.productPRBFacade = productPRBFacade;
		this.productBSKFacade = productBSKFacade;
		this.productSTRFacade = productSTRFacade;
		this.orderInsertOrderTable = orderInsertOrderTable;
		this.orderUpdateChargingTable = orderUpdateChargingTable;
		this.orderInsertUserInfoTable = orderInsertUserInfoTable;
		this.giftInsertGiftTable = giftInsertGiftTable;
		this.giftInsertUserInfoGiftTable = giftInsertUserInfoGiftTable;
		this.memberInfoSelectQueryTable = memberInfoSelectQueryTable;
		this.memberInfoGiftSelectQueryTable = memberInfoGiftSelectQueryTable;
		this.discountFacade = discountFacade;
		this.discountProductFacade = discountProductFacade;
		this.userCountFacade = userCountFacade;
		this.userCounter = userCounter;
	}

	
	//로그인할 때
	public ArrayList<User> loginStart(String id,String pw,JdbcTemplate template) {
		return loginFacade.loginQuery(id, pw, template);
	}
	
	//충전할 때
	public Charging charging(JdbcTemplate template) {
		return chargingFacade.chargingQuery(template);
	}
	
	//충정할 때 금액을 충전해준다.
	public int chargingCheck(JdbcTemplate template, int chargingPoint,GetToday today,String sessionId) {
		return chargingCheckUpdateChargingTable.chargingCheckUpdateChargingQuery(template, chargingPoint, today, sessionId);		
	}
	
	//상품보여주기 - 파리바게트
	public ArrayList<ProductPRB> productPRB(JdbcTemplate template) {
		return productPRBFacade.productPRBQuery(template);
	}
	
	//상품을 구매한 적이 있다면 카운트 올라가기
	public String userCount(JdbcTemplate template, String sessionId,String productConnect) {
		/*		
		String count = userCountFacade.userCountQuery(template, sessionId);	//구매한적이 있다
	if(count != "") {		//할인율 가져와서 계산하고 업데이트해주기
			return userCounter.userCounterQuery(template, productConnect);
		}else {					//구매한적이 없으면 그냥 목록띄워주기
	//		return ;
		}
*/		return userCountFacade.userCountQuery(template, sessionId, productConnect);	//구매한적이 있다
	}
	
	
	
	public ArrayList<ProductPRB> discountproduct(JdbcTemplate template,String productPrice, String productCode){
		discountProductFacade.discountProductUpdateQuery(template, productPrice, productCode);
		return productPRBFacade.productPRBQuery(template);
	}
	
	
	
	//상품보여주기 - 베스킨라빈스
	public ArrayList<ProductBSK> productBSK(JdbcTemplate template){
		return productBSKFacade.productBSKQuery(template);		
	}

	//상품보여주기 - 스타벅스
	public ArrayList<ProductSTR> productSTR(JdbcTemplate template){
		return productSTRFacade.productSTRQuery(template);		
	}
	
	//주문했을 떄 - 결제내역 저장하기
	public int orderCheck(JdbcTemplate template,String sessionId, String address, int totalPoint, String productName, int productPrice, String productCode, String productBarcode, int amount, int sum,String productConnect) {
		orderInsertOrderTable.orderInsertOrderQuery(template,sessionId,address,totalPoint,productName, productPrice,productCode,productBarcode,amount,sum,productConnect);
		orderUpdateChargingTable.orderUpdateChargingQuert(template,sessionId,sum);
		return orderInsertUserInfoTable.orderInsertUserInfoQuery(template,sessionId,address,totalPoint,productName, productPrice,productCode,productBarcode,amount,sum,productConnect);
	}
	
	//선물했을 때 - 선물내역 저장하기
	public int giftCheck(JdbcTemplate template,String sessionId, String phoneNumber, int totalPoint, String productName, int productPrice, String productCode, String productBarcode, int amount, int sum) {
		giftInsertGiftTable.giftInsertGiftQuery(template,sessionId,phoneNumber,totalPoint,productName, productPrice,productCode,productBarcode,amount,sum);
		orderUpdateChargingTable.orderUpdateChargingQuert(template,sessionId,sum);
		return giftInsertUserInfoGiftTable.giftInsertUserInfoGiftQuery(template,sessionId,phoneNumber,totalPoint,productName, productPrice,productCode,productBarcode,amount,sum);
	}
	
	// 주문 내역
	public ArrayList<MemberOrder> memberInfo(JdbcTemplate template,String sessionId){
		return memberInfoSelectQueryTable.memberInfoSelectQuery(template,sessionId);
	}
	
	//선물한 내역
	public ArrayList<MemberGift> memberInfoGift(JdbcTemplate template,String sessionId){
		return memberInfoGiftSelectQueryTable.memberInfoGiftSelectQuery(template,sessionId);
	}
	//세일설정
	public int discountUpdate(JdbcTemplate template,String productCode, String start, String end, String persent) {
		System.out.println("2들어옴");
		return discountFacade.saleTableUpdateQuery(template, productCode, start, end, persent);
	}
	
}









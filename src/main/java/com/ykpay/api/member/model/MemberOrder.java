package com.ykpay.api.member.model;

public class MemberOrder {
		
	public String userId;
	public String userAddress;
	public int totalpoint;	
	public String productName;
	public int productPrice;
	public String productCode;
	public String productBarcode;
	public int amount;
	public int pointSum;
	public int pointRemain;
	public String regdate;
	
	public MemberOrder() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getTotalpoint() {
		return totalpoint;
	}

	public void setTotalpoint(int totalpoint) {
		this.totalpoint = totalpoint;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPointSum() {
		return pointSum;
	}

	public void setPointSum(int pointSum) {
		this.pointSum = pointSum;
	}

	public int getPointRemain() {
		return pointRemain;
	}

	public void setPointRemain(int pointRemain) {
		this.pointRemain = pointRemain;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public MemberOrder(String userId, String userAddress, int totalpoint, String productName, int productPrice,
			String productCode, String productBarcode, int amount, int pointSum, int pointRemain, String regdate) {
		super();
		this.userId = userId;
		this.userAddress = userAddress;
		this.totalpoint = totalpoint;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCode = productCode;
		this.productBarcode = productBarcode;
		this.amount = amount;
		this.pointSum = pointSum;
		this.pointRemain = pointRemain;
		this.regdate = regdate;
	}	

	
}

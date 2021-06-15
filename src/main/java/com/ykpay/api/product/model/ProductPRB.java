package com.ykpay.api.product.model;


public class ProductPRB {
	private String productConnect;
	private String productCode;
	private String productName;
	private String productExplain;
	private int productPrice;	
	private String productBarcode;
	private String productImgUrl;
	private String saleStart;
	private String saleEnd;
	private int saleRate;
	private String productOldprice;
	
	public ProductPRB() {
	}

	public String getProductOldprice() {
		return productOldprice;
	}

	public void setProductOldprice(String productOldprice) {
		this.productOldprice = productOldprice;
	}

	public String getProductConnect() {
		return productConnect;
	}

	public void setProductConnect(String productConnect) {
		this.productConnect = productConnect;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductExplain() {
		return productExplain;
	}

	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public String getSaleStart() {
		return saleStart;
	}

	public void setSaleStart(String saleStart) {
		this.saleStart = saleStart;
	}

	public String getSaleEnd() {
		return saleEnd;
	}

	public void setSaleEnd(String saleEnd) {
		this.saleEnd = saleEnd;
	}

	public int getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(int saleRate) {
		this.saleRate = saleRate;
	}

	public ProductPRB(String productConnect, String productCode, String productName, String productExplain,
			int productPrice, String productBarcode, String productImgUrl, String saleStart, String saleEnd,
			int saleRate, String productOldprice) {
		super();
		this.productConnect = productConnect;
		this.productCode = productCode;
		this.productName = productName;
		this.productExplain = productExplain;
		this.productPrice = productPrice;
		this.productBarcode = productBarcode;
		this.productImgUrl = productImgUrl;
		this.saleStart = saleStart;
		this.saleEnd = saleEnd;
		this.saleRate = saleRate;
		this.productOldprice = productOldprice;
	}

	
	

}

package com.ykpay.api.product.model;

public class ProductBSK {
	private String productCode;
	private String productName;
	private String productExplain;
	private int productPrice;	
	private String productBarcode;
	private String productImgUrl;
	
	public ProductBSK() {
		
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
	public ProductBSK(String productCode, String productName, String productExplain, int productPrice,
			String productBarcode, String productImgUrl) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productExplain = productExplain;
		this.productPrice = productPrice;
		this.productBarcode = productBarcode;
		this.productImgUrl = productImgUrl;
	}
	
}

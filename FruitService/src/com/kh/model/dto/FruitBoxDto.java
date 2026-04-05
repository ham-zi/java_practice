package com.kh.model.dto;

public class FruitBoxDto {

	private String ProductId;
	private String fruitName;
	private double fruitBrix;
	private int fruitStock;
	private int productPrice;
	
	public FruitBoxDto(String productId, String fruitName, double fruitBrix, int fruitStock, int productPrice) {
		super();
		ProductId = productId;
		this.fruitName = fruitName;
		this.fruitBrix = fruitBrix;
		this.fruitStock = fruitStock;
		this.productPrice = productPrice;
	}
	
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public double getFruitBrix() {
		return fruitBrix;
	}
	public void setFruitBrix(double fruitBrix) {
		this.fruitBrix = fruitBrix;
	}
	public int getFruitStock() {
		return fruitStock;
	}
	public void setFruitStock(int fruitStock) {
		this.fruitStock = fruitStock;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}

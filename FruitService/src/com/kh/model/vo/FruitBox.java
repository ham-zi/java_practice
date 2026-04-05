package com.kh.model.vo;

import java.util.Objects;

public class FruitBox {
	private final String ProductId;
	private final String fruitName;
	private final double fruitBrix;
	private final int fruitStock;
	private final int productPrice;
	
	public FruitBox(String productId, String fruitName, double fruitBrix, int fruitStock, int productPrice) {
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

	public String getFruitName() {
		return fruitName;
	}

	public double getFruitBrix() {
		return fruitBrix;
	}

	public int getFruitStock() {
		return fruitStock;
	}

	public int getProductPrice() {
		return productPrice;
	}

	@Override
	public String toString() {
		return "FruitBox [ProductId=" + ProductId + ", fruitName=" + fruitName + ", fruitBrix=" + fruitBrix
				+ ", fruitStock=" + fruitStock + ", productPrice=" + productPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ProductId, fruitBrix, fruitName, fruitStock, productPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FruitBox other = (FruitBox) obj;
		return Objects.equals(ProductId, other.ProductId)
				&& Double.doubleToLongBits(fruitBrix) == Double.doubleToLongBits(other.fruitBrix)
				&& Objects.equals(fruitName, other.fruitName) && fruitStock == other.fruitStock
				&& productPrice == other.productPrice;
	}
	
	
	
}

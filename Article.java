package com.m2iformation.TPStock;

public class Article {
	private int reference; 
	private String name;
	private float price; 
	private int quantity;
	
	public Article() {
		super();
	}

	public Article(int reference, String name, float price, int quantity) {
		super();
		this.reference = reference;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public final int getReference() {
		return reference;
	}

	public final void setReference(int reference) {
		this.reference = reference;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final float getPrice() {
		return price;
	}

	public final void setPrice(float price) {
		this.price = price;
	}

	public final int getQuantity() {
		return quantity;
	}

	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void modifier(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Article [reference=" + reference + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}	
}

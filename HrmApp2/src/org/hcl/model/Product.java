package org.hcl.model;

public class Product {
	private int pid;
	private String productName;
	private String imageUrl;
	private String description;
	private int price;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String productName, String imageUrl, String description, int price) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.description = description;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
}

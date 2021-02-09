package com.demo.pojo;

public class Product {
	private int pid;
	private String pname;
	private int qty;
	private double price;
	private String imageUrl;
	private int cid;
	private String brandName;
	private String subcategory;
	private String description;
	private String wt;
	public Product(int pid, String pname, int qty, double price, String imageUrl, int cid, String brandName,
			String subcategory, String description, String wt) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.imageUrl = imageUrl;
		this.cid = cid;
		this.brandName = brandName;
		this.subcategory = subcategory;
		this.description = description;
		this.wt = wt;
	}
	public Product() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWt() {
		return wt;
	}
	public void setWt(String wt) {
		this.wt = wt;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", imageUrl="
				+ imageUrl + ", cid=" + cid + ", brandName=" + brandName + ", subcategory=" + subcategory
				+ ", description=" + description + ", wt=" + wt + "]";
	}
	
}

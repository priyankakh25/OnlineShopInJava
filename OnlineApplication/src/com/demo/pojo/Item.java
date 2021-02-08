package com.demo.pojo;

public class Item {
	int pid;
	String pName;
	String imgUrl;
	double price;
	int qty;
	public Item(int pid, String pName, String imgUrl, double price, int qty) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.imgUrl = imgUrl;
		this.price = price;
		this.qty = qty;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Item [pid=" + pid + ", pName=" + pName + ", imgUrl=" + imgUrl + ", price=" + price + ", qty=" + qty
				+ "]";
	}
	
}

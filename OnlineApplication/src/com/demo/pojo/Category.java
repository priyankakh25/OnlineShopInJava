package com.demo.pojo;
public class Category {
	private int cid;
	private String cname;
	private String imgUrl;
	
	public Category() {
		super();
	}

	public Category(int cid, String cname, String imgUrl) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.imgUrl = imgUrl;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", imgUrl=" + imgUrl + "]";
	}
	
}

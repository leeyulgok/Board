package com.borad.web.notice.model;

public class NoticeModel {
	private int num;
	private String id;
	private String title;
	private String content;
	private String regdate;
	private int hit;
	private int pub;
	
	public NoticeModel() {
		
	}

	public NoticeModel(int num, String id, String title, String content, String regdate, int hit, int pub) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.pub = pub;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getPub() {
		return pub;
	}

	public void setPub(int pub) {
		this.pub = pub;
	}
	
	
}

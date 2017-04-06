package com.oop.container;

public class SMSRecord {
	Integer id;
	String fromNumber;
	String toNumber;
	String content;
	public Integer getId() {
		return id;
	}
	protected void setId(Integer id) {
		this.id = id;
	}
	public String getFromNumber() {
		return fromNumber;
	}
	protected void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}
	public String getToNumber() {
		return toNumber;
	}
	protected void setToNumber(String toNumber) {
		this.toNumber = toNumber;
	}
	public String getContent() {
		return content;
	}
	protected void setContent(String content) {
		this.content = content;
	}
}

package com.oop.container;

public class CallRecord {
	Integer id;
	String fromNumber;
	String toNumber;
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
}

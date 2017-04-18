package com.oop.container;

import org.json.simple.JSONObject;

public class SMSRecord {
	Integer id;
	String fromNumber;
	String toNumber;
	String content;
	public SMSRecord(String _fromNumber, String _toNumber, String _content) {
		id = -1;
		fromNumber = _fromNumber;
		toNumber = _toNumber;
		content = _content;
	}
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
	public JSONObject toJSONObject() {
		JSONObject res = new JSONObject();
		res.put("fromNumber", fromNumber);
		res.put("toNumber", toNumber);
		res.put("content", content);
		return res;
	}
}

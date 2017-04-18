package com.oop.container;

import org.json.simple.JSONObject;

public class CallRecord {
	Integer id;
	String fromNumber;
	String toNumber;
	public CallRecord(String _fromNumber, String _toNumber) {
		id = -1;
		fromNumber = _fromNumber;
		toNumber = _toNumber;
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
	public JSONObject toJSONObject() {
		JSONObject res = new JSONObject();
		res.put("fromNumber", fromNumber);
		res.put("toNumber", toNumber);
		return res;
	}
}

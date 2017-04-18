package com.oop.container;

import java.util.*;

import org.json.simple.JSONObject;

public class Person {
	Integer id;
	String nickname;
	String phoneNumber;
	Date recent;
	
	public Person(String nickname_, String phoneNumber_) {
		id = -1;
		nickname = nickname_;
		phoneNumber = phoneNumber_;
		recent = new Date();
	}
	public Integer getId() {
		return id;
	}
	protected void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	protected void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getRecent() {
		return recent;
	}
	protected void setRecent(Date recent) {
		this.recent = recent;
	}
	public JSONObject toJSONObject() {
		JSONObject res = new JSONObject();
		res.put("nickname", nickname);
		res.put("phoneNumber", phoneNumber);
		res.put("recent", recent.toString());
		return res;
	}
}

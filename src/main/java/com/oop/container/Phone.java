package com.oop.container;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Phone {
	public CallRecordContainer callContainer;
	public PersonContainer personContainer;
	public SMSRecordContainer smsContainer;
	public Phone() {
		callContainer = new CallRecordContainer();
		personContainer = new PersonContainer();
		smsContainer = new SMSRecordContainer();
	}
	public String toJSONString() {
		JSONObject root = new JSONObject();
		JSONArray callArray = new JSONArray();
		JSONArray personArray = new JSONArray();
		JSONArray smsArray = new JSONArray();
		for(Integer key : callContainer) {
			CallRecord unit = callContainer.get(key);
			callArray.add(unit.toJSONObject());
		}
		for(Integer key : personContainer) {
			Person unit = personContainer.get(key);
			personArray.add(unit.toJSONObject());
		}
		for(Integer key : smsContainer) {
			SMSRecord unit = smsContainer.get(key);
			smsArray.add(unit.toJSONObject());
		}
		root.put("call", callArray);
		root.put("person", personArray);
		root.put("sms", smsArray);
		return root.toJSONString();
	}
}

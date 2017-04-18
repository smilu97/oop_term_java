package com.oop.container;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	public void saveToJSONFile(String path) throws IOException {
		String JSONString = toJSONString();
		FileWriter writer = new FileWriter(path);
		writer.write(JSONString);
		writer.close();
	}
	public void loadFromJSONFile(String path) throws IOException, ParseException {
		FileReader reader = new FileReader(path);
		JSONParser parser = new JSONParser();
		JSONObject root = (JSONObject)parser.parse(reader);
		JSONArray callArray   = (JSONArray)root.get("call");
		JSONArray personArray = (JSONArray)root.get("person");
		JSONArray smsArray    = (JSONArray)root.get("sms");
		callContainer   = new CallRecordContainer();
		personContainer = new PersonContainer();
		smsContainer    = new SMSRecordContainer();
		for(Object obj: callArray) {
			JSONObject call = (JSONObject)obj;
			CallRecord unit = new CallRecord((String)call.get("fromNumber"), (String)call.get("toNumber"));
			callContainer.add(unit);
		}
		for(Object obj: personArray) {
			JSONObject person = (JSONObject)obj;
			Person unit = new Person((String)person.get("nickname"), (String)person.get("phoneNumber"));
			personContainer.add(unit);
		}
		for(Object obj: smsArray) {
			JSONObject sms = (JSONObject)obj;
			SMSRecord unit = new SMSRecord((String)sms.get("fromNumber"), (String)sms.get("toNumber"),
					(String)sms.get("content"));
			smsContainer.add(unit);
		}
	}
}

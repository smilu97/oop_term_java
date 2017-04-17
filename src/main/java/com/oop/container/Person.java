package com.oop.container;

import java.util.*;

public class Person {
	Integer id;
	String nickname;
	String phoneNumber;
	Date recent;
	
	public Person(String nickname_, String phoneNumber_) {
		nickname = nickname_;
		phoneNumber = phoneNumber_;
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
	public class PersonComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			if (o1.getId() < o2.getId()) return 1;
			return 0;
		}
	}
}

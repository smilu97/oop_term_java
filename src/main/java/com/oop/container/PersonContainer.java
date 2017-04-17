package com.oop.container;

import java.util.Date;
import java.util.NavigableSet;

import com.google.common.collect.Ordering;
import com.google.common.collect.TreeMultimap;

public class PersonContainer {
	private TreeMultimap<Integer, Person> keyId;
	private TreeMultimap<String,  Person> keyNickname;
	private TreeMultimap<String,  Person> keyPhoneNumber;
	private TreeMultimap<Date,    Person> keyRecent;
	
	private Integer maxId;
	
	PersonContainer () {
		maxId = 0;
		keyId          = TreeMultimap.create(Ordering.natural(), new PersonComparator());
		keyNickname    = TreeMultimap.create(Ordering.natural(), new PersonComparator());
		keyPhoneNumber = TreeMultimap.create(Ordering.natural(), new PersonComparator());
		keyRecent      = TreeMultimap.create(Ordering.natural(), new PersonComparator());
	}
	public void add (Person item) {
		item.setId(maxId);
		keyId.put(maxId++, item);
		keyNickname.put(item.getNickname(), item);
		keyPhoneNumber.put(item.getPhoneNumber(), item);
		keyRecent.put(item.getRecent(), item);
	}
	public void del (int id) {
		NavigableSet<Person> items;
		Person item;
		items = keyId.get(id);
		if (items.isEmpty()) return;
		item = items.first();
		keyId.removeAll(id);
		items = keyNickname.get(item.getNickname());
		for(Person p : items) {
			if (p.getId() == id) {
				keyNickname.remove(item.getNickname(), p);
				break;
			}
		}
		items = keyPhoneNumber.get(item.getPhoneNumber());
		for(Person p : items) {
			if (p.getId() == id) {
				keyPhoneNumber.remove(item.getPhoneNumber(),  p);
				break;
			}
		}
		items = keyRecent.get(item.getRecent());
		for(Person p : items) {
			if (p.getId() == id) {
				keyRecent.remove(item.getRecent(),  p);
				break;
			}
		}
	}
	public Person get (int id) {
		return keyId.get(id).first();
	}
	public void updateNickname (int id, String newNickname) {
		Person item = keyId.get(id).first();
		if (item == null) return;
		NavigableSet<Person> items = keyNickname.get(item.getNickname());
		for(Person p : items) {
			if (p.getId() == id) {
				keyNickname.remove(item.getNickname(), p);
				break;
			}
		}
		item.setNickname(newNickname);
		keyNickname.put(newNickname, item);
	}
	public void updatePhoneNumber(int id, String newPhoneNumber) {
		Person item = keyId.get(id).first();
		if (item == null) return;
		NavigableSet<Person> items = keyPhoneNumber.get(item.getPhoneNumber());
		for(Person p : items) {
			if (p.getId() == id) {
				keyPhoneNumber.remove(item.getPhoneNumber(), p);
				break;
			}
		}
		item.setPhoneNumber(newPhoneNumber);;
		keyPhoneNumber.put(newPhoneNumber, item);
	}
	public void updateRecent(int id, Date newRecent) {
		Person item = keyId.get(id).first();
		if (item == null) return;
		NavigableSet<Person> items = keyRecent.get(item.getRecent());
		for(Person p : items) {
			if (p.getId() == id) {
				keyRecent.remove(item.getRecent(), p);
				break;
			}
		}
		item.setRecent(newRecent);
		keyRecent.put(newRecent, item);
	}
	public NavigableSet<Person> findByNickname(String _nickname) {
		return keyNickname.get(_nickname);
	}
	public NavigableSet<Person> findByPhoneNumber(String _phoneNumber) {
		return keyPhoneNumber.get(_phoneNumber);
	}
}

package com.oop.container;

import java.util.Iterator;
import java.util.NavigableSet;

import com.google.common.collect.Ordering;
import com.google.common.collect.TreeMultimap;

public class SMSRecordContainer implements Iterable<Integer>{
	private TreeMultimap<Integer, SMSRecord> keyId;
	private TreeMultimap<String,  SMSRecord> keyFromNumber;
	private TreeMultimap<String,  SMSRecord> keyToNumber;
	
	private Integer maxId = 0;
	
	SMSRecordContainer () {
		maxId = 0;
		keyId         = TreeMultimap.create(Ordering.natural(), new SMSRecordComparator());
		keyFromNumber = TreeMultimap.create(Ordering.natural(), new SMSRecordComparator());
		keyToNumber   = TreeMultimap.create(Ordering.natural(), new SMSRecordComparator());
	}
	public void add (SMSRecord item) {
		item.setId(maxId);
		keyId.put(maxId++, item);
		keyFromNumber.put(item.getFromNumber(), item);
		keyToNumber.put(item.getToNumber(), item);
	}
	public void del (int id) {
		NavigableSet<SMSRecord> items;
		SMSRecord item;
		items = keyId.get(id);
		if (items.isEmpty()) return;
		item = items.first();
		keyId.removeAll(id);
		items = keyFromNumber.get(item.getFromNumber());
		for(SMSRecord p : items) {
			if (p.getId() == id) {
				keyFromNumber.remove(item.getFromNumber(), p);
				break;
			}
		}
		items = keyToNumber.get(item.getToNumber());
		for(SMSRecord p : items) {
			if (p.getId() == id) {
				keyToNumber.remove(item.getToNumber(),  p);
				break;
			}
		}
	}
	public SMSRecord get (int id) {
		return keyId.get(id).first();
	}
	public NavigableSet<SMSRecord> findByFromNumber(String _fromNumber) {
		return keyFromNumber.get(_fromNumber);
	}
	public NavigableSet<SMSRecord> findByToNumber(String _toNumber) {
		return keyToNumber.get(_toNumber);
	}
	@Override
	public Iterator<Integer> iterator() {
		return keyId.keySet().iterator();
	}
	public Iterator<String> fromNumberIterator() {
		return keyFromNumber.keySet().iterator();
	}
	public Iterator<String> toNumberIterator() {
		return keyToNumber.keySet().iterator();
	}
}

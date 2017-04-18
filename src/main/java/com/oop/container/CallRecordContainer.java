package com.oop.container;

import java.util.Iterator;
import java.util.NavigableSet;

import com.google.common.collect.Ordering;
import com.google.common.collect.TreeMultimap;

public class CallRecordContainer implements Iterable<Integer> {
	private TreeMultimap<Integer, CallRecord> keyId;
	private TreeMultimap<String, CallRecord> keyFromNumber;
	private TreeMultimap<String, CallRecord> keyToNumber;
	
	private Integer maxId = 0;
	
	CallRecordContainer () {
		maxId = 0;
		keyId         = TreeMultimap.create(Ordering.natural(), new CallRecordComparator());
		keyFromNumber = TreeMultimap.create(Ordering.natural(), new CallRecordComparator());
		keyToNumber   = TreeMultimap.create(Ordering.natural(), new CallRecordComparator());
	}
	public void add (CallRecord item) {
		item.setId(maxId);
		keyId.put(maxId++, item);
		keyFromNumber.put(item.getFromNumber(), item);
		keyToNumber.put(item.getToNumber(), item);
	}
	public void del (int id) {
		NavigableSet<CallRecord> items;
		CallRecord item;
		items = keyId.get(id);
		if (items.isEmpty()) return;
		item = items.first();
		keyId.removeAll(id);
		items = keyFromNumber.get(item.getFromNumber());
		for(CallRecord p : items) {
			if (p.getId() == id) {
				keyFromNumber.remove(item.getFromNumber(), p);
				break;
			}
		}
		items = keyToNumber.get(item.getToNumber());
		for(CallRecord p : items) {
			if (p.getId() == id) {
				keyToNumber.remove(item.getToNumber(),  p);
				break;
			}
		}
	}
	public CallRecord get (int id) {
		return keyId.get(id).first();
	}
	public NavigableSet<CallRecord> findByFromNumber(String _fromNumber) {
		return keyFromNumber.get(_fromNumber);
	}
	public NavigableSet<CallRecord> findByToNumber(String _toNumber) {
		return keyToNumber.get(_toNumber);
	}
	@Override
	public Iterator<Integer> iterator() {
		return keyId.keySet().iterator();
	}
}

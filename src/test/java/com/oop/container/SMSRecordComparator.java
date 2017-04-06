package com.oop.container;

import java.util.Comparator;

public class SMSRecordComparator implements Comparator<SMSRecord> {
	@Override
	public int compare(SMSRecord o1, SMSRecord o2) {
		if (o1.getId() < o2.getId()) return 1;
		return 0;
	}
}

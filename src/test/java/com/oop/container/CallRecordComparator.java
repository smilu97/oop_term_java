package com.oop.container;

import java.util.Comparator;

public class CallRecordComparator implements Comparator<CallRecord> {

	@Override
	public int compare(CallRecord o1, CallRecord o2) {
		if (o1.getId() < o2.getId()) return 1;
		return 0;
	}

}

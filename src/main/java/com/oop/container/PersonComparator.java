package com.oop.container;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getId() < o2.getId()) return 1;
		return 0;
	}

}

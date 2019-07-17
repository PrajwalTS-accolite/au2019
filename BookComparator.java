package com.accolite.au.java_collections;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{
	public int compare(Book o1, Book o2) {
		if(o1 == null) {
			if(o2 == null)
				return compareName(o1, o2);
			return -1;
		}
		if(o2==null)
			return 1;
		if(o1.getPrice() > o2.getPrice())
			return 1;
		if(o2.getPrice() > o1.getPrice())
			return -1;
		return compareName(o1, o2);
	}
	
	public int compareName(Book o1, Book o2) {
		if(o1 == null) {
			if(o2 == null)
				return 0;
			return -1;
		}
		if(o2==null)
			return 1;
		return(o1.getName().compareTo(o2.getName()));
	}
}



package com.accolite.au.java_collections;

import java.util.*;

public class ListSorting{
	
	public static void main(String[] args) {
		List<Book> booksList = new ArrayList<>();
		booksList.add(new Book(1, "The concepts of Physics Vol 2", "H C Verma", 1200));
		booksList.add(new Book(2, "Angles and Demons", "Dan Brown", 300));
		booksList.add(new Book(3, "2 States", "Chetan Bhagath", 200));
		booksList.add(new Book(4, "The concepts of Physics Vol 1", "H C Verma", 1200));
		booksList.add(new Book(5, "DaVinci Code", "Dan Brown", 500));
		booksList.add(new Book(6, "5 point someone", "Chetan Bhagath", 250));
		booksList.add(new Book(7, "Origin", "Dan Brown", 350));
		booksList.add(new Book(8, "The Lost Symbol", "Dan Brown", 300));
		booksList.add(new Book(9, "The concepts of Physics Vol 3", "H C Verma", 1200));
	
		System.out.println("Ünsorted List");
		System.out.println(booksList);
//		booksList.sort(new BookComparator());
		System.out.println("\nSorted List");
		Collections.sort(booksList, new BookComparator());
		System.out.println(booksList);
			
		Iterator<Book> itr = booksList.iterator();
		
		HashMap<String, Integer> authorMap = new HashMap<String, Integer>();
		
		while(itr.hasNext()) {
			Book bk = itr.next();
			bk.setPrice(0.8*bk.getPrice());
			String key = bk.getAuthor();
			Integer val = authorMap.put(key,1);
			if(val != null)
				authorMap.replace(key, (val+1));
		}
		
		System.out.println("\nUpdated List with decreased prices");
		System.out.println(booksList); 
		
		System.out.println("\nAuthors who have written more than two book");
		for(Map.Entry<String, Integer> entry: authorMap.entrySet()) {
			if(entry.getValue()>2)
				System.out.println(entry.getKey()+" : "+entry.getValue() + " books.");
		}	
	}
}

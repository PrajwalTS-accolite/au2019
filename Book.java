package com.accolite.au.java_collections;

public class Book implements Comparable<Book>{
	
	private String name;
	private String author;
	private double price;
	private int isbn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public Book(int isbn, String name, String author, double price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "\nISBN: "+this.isbn + " | Name: "+this.name +" | Author: " + this.author + " | Price: " + this.price ;  
	}
	
	public int compareTo(Book o) {
		if(this.price < o.price)
			return -1;
		if(this.price == o.price)
			return 0;
		return 1;
	}
	
}

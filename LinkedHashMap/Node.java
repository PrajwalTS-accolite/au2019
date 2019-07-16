package com.accolite.au.java;

public class Node {

	String key;
	String value;
	int hash;
	Node next;
	Node after;
	Node before;
	
	Node(String key, String value, int hash){
		this.key = key;
		this.value = value;
		next = null;
		after = null;
		before = null;
		this.hash = hash;
	}
	
	public Node getAfter() {
		return after;
	}
	
	public Node getBefore() {
		return before;
	}
	
	public String getKey() {
		return key;
	}
	
	public Node getNext() {
		return next;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setAfter(Node after) {
		this.after = after;
	}
	
	public void setBefore(Node before) {
		this.before = before;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	
}

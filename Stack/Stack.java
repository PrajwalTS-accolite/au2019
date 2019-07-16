package com.accolite.au.java;

import java.util.Scanner;
public class Stack {
	
	Integer[] stack;
	Integer top;
	int maxSize;
	
	Stack(int size)
	{
		maxSize = size;
		this.stack = new Integer[maxSize];
		top = -1;
	}
	
	
	public void push(Integer elem) {
		if(!isFull())
			stack[++top] = elem;
		else
			System.out.println("Stack full");
	}
	
	public Integer pop() {
		if(!isEmpty()) {
			Integer delElem = stack[top];
			top--;
			return delElem;
		}
		else {
			System.out.println("Stack empty");
			return null;
		}
	}
	
	public boolean isEmpty() {
		if(top == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(top+1 == maxSize)
			return true;
		else
			return false;
	}
	
	public int size() {
		return (top+1);
	}
	
	public void top()
	{
		if(!isEmpty())
			System.out.println("The top element is " + stack[top]);
		else
			System.out.println("The stack is empty.");
	}

}

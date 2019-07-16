package com.accolite.au.java;

import java.util.Scanner;

public class Operate_Stack {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nËnter the max size of the stack");
		int size = sc.nextInt();
		while(size==0) {
			System.out.println("Max size cannot be zero. Enter max size of the stack again.");
			size = sc.nextInt();
		}
		Stack newStack = new Stack(size);
		int choice;
		
		while(true) {
			System.out.println("\n1. Push\n"
					+ "2. Pop\n"
					+ "3. Size\n"
					+ "4. isEmpty\n"
					+ "5. isFull\n"
					+ "6. View Top Element");
			
			System.out.println("\nËnter your choice");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter element to be pushed");
				Integer elem = sc.nextInt();
				newStack.push(elem);
				break;
			case 2:
				Integer delElem = newStack.pop();
				if(delElem != null)
					System.out.println(delElem);
				break;
			case 3:
				System.out.println(newStack.size());
				break;
			case 4:
				if (newStack.isEmpty())
					System.out.println("Stack empty");
				else
					System.out.println("Stack is not empty");
				break;
			case 5:
				if (newStack.isFull())
					System.out.println("Stack full");
				else
					System.out.println("Stack is not full");
				break;
			case 6:
				newStack.top();
				break;
			default:
				System.out.println("Wrong input. Try again.");
			}
		}
	}
}

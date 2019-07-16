package com.accolite.au.java;

import java.util.Scanner;

public class LinkedHashMap {
	Node[] buckets;
	Node header;
	Node current;
	int size;
	final static int capacity = 10;

	public LinkedHashMap() {
		buckets = new Node[capacity];
		header = null;
		current = null;
		size = 0;
	}

	public static void main(String args[]) {
		LinkedHashMap map = new LinkedHashMap();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\nChoices");
			System.out.println("1. Put\n" + "2. Delete\n" + "3. Get\n" + "4. Display");
			System.out.print("Your Choice : ");
			int choice = sc.nextInt();
			sc.nextLine();
			String key, value;

			switch (choice) {
			case 1:
				System.out.println("Ënter key");
				key = sc.nextLine();
				System.out.println("Ënter value");
				value = sc.nextLine();
				map.put(key, value);
				break;
			case 2:
				System.out.println("Ënter key");
				key = sc.nextLine();
				map.delete(key);
				break;
			case 3:
				System.out.println("Ënter key");
				key = sc.nextLine();
				map.get(key);
				break;
			case 4:
				map.display();
				break;
			default:
				System.out.println("Wrong choice. Try again");
			}
		}
	}

	public void put(String key, String value) {
		if (key == null || "".equals(key)) {
			System.out.println("Key cant be empty");
			return;
		}
		int hash = getHash(key);
		int bucket = hash % capacity;
		Node existing = buckets[bucket];

		try {
			while (existing.next != null) {
				if (existing.key.equals(key)) {
					existing.value = value;
					System.out.println("Key found. Value modified");
					return;
				}
				existing = existing.next;
			}

			if (existing.key.equals(key)) {
				existing.value = value;
				System.out.println("Key found. Value modified");
				return;
			}
		} catch (Exception e) {
		}

		Node newNode = new Node(key, value, hash);

		if (size == 0)
			header = current = newNode;
		else {
			newNode.before = current;
			current.after = newNode;
			current = newNode;
		}

//		newNode.next = buckets[bucket];
//		buckets[bucket] = newNode;
		if (existing == null)
			buckets[bucket] = newNode;
		else
			existing.next = newNode;

		size++;
		System.out.println("Ëntered. Size : " + size);

	}

	public void delete(String key) {
		if (size == 0) {
			System.out.println("Empty");
			return;
		}

		int hash = getHash(key);
		int bucket = hash % capacity;
		Node existing = buckets[bucket];

		Node prev = null;
		while (existing != null) {
			if (key.equals(existing.key))
				break;
			prev = existing;
			existing = existing.next;
		}

		if (existing == null)
			System.out.println("Can't Delete. Not found");
		else {
			size--;
			System.out.println("Deleted. Size : " + size);
			if (prev == null)
				buckets[bucket] = null;
			else {
				prev.next = existing.next;
			}

			if (size == 0)
				header = current = null;
			else if (header == existing) {
				header = header.after;
				header.before = null;
			} else if (current == existing) {
				current = existing.before;
				current.after = null;
			} else {
				existing.before.after = existing.after;
				existing.after.before = existing.before;
			}
		}
	}

	public void get(String key) {
		if (size == 0) {
			System.out.println("Empty");
			return;
		}

		int hash = getHash(key);
		int bucket = hash % capacity;
		Node existing = buckets[bucket];
		while (existing != null) {
			if (key.equals(existing.key))
				break;
			existing = existing.next;
		}

		if (existing == null)
			System.out.println("Not found");
		else
			System.out.println("Key : " + existing.key + "\tValue : " + existing.value);
	}

	public void display() {

		if (size == 0) {
			System.out.println("Empty");
			return;
		}
		Node dispCurrent = header;
		while (dispCurrent != null) {
			System.out.println("Key : " + dispCurrent.key + "\tValue : " + dispCurrent.value);
			dispCurrent = dispCurrent.after;
		}

	}

	public int getHash(String key) {
		return (int) key.charAt(0);
	}

}

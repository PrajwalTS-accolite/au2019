package com.accolite.au.java_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class ListDuplicateAlphabetical {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String> arr = new HashSet<>();
		HashSet<String> dupArr = new HashSet<>();
		System.out.println("Enter the elemets to be entered. Enter # to stop insertion");
		while(true) {
			String elem = sc.nextLine();
			if("#".equals(elem))
				break;
			if(!arr.add(elem)) {
				dupArr.add(elem);
			}			
		}
		
		ArrayList<String> list = new ArrayList<>(dupArr);
		System.out.println("Sorted Duplicated Array");
		Collections.sort(list);
		System.out.println(list);
		
	}
}

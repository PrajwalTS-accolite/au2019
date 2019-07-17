package com.accolite.au.java_collections;

import java.util.ArrayList;
import java.util.Scanner;

public class ListCommonElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr1 = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();
		
		for(int i=1;i<=2;i++) {
			System.out.println("Enter the elemets to be entered in Array "+i+". Enter # to stop insertion");
			while(true) {
				String elem = sc.nextLine();
				if("#".equals(elem))
					break;	
				if(i==1)
					arr1.add(elem);
				else
					arr2.add(elem);
				
			}
		}
		
		arr1.retainAll(arr2);
		System.out.println("Common elements\n"+arr1);
	}

}

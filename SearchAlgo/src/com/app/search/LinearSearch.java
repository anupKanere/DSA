package com.app.search;

import java.util.Scanner;

public class LinearSearch {

	public static int LinearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
		}

		return -1;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 10, 20, 8, 5, 35, 45, 85 };
		System.out.println("Enter the key :  ");
		int key = sc.nextInt();
		int index = LinearSearch(arr, key);
		if (index != -1) {
			System.out.println(" Key found at index : " + index);
		} else
			System.out.println("KEY NOT FOUND");

	}

}

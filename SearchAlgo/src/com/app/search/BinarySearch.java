package com.app.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	
	public static int binarySearch(int[] arr, int key) {
		int left = 0, right = arr.length - 1, mid;
		while (left <= right) 
		{
			mid = (left + right) / 2;
			if (key == arr[mid])
				return mid;
			if (key < arr[mid])
				right = mid - 1; 
			else
				left = mid + 1;
		}
		return 1;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 10, 20, 8, 5, 35, 45, 85 };
		Arrays.sort(arr);
		System.out.println("Enter the key :  ");
		int key = sc.nextInt();
		int index = binarySearch(arr, key);
		if (index != -1) {
			System.out.println(" Key found at index : " + index);
		} else
			System.out.println("KEY NOT FOUND");

	}

}

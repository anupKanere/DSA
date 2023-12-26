package com.app.list;

import java.util.Scanner;
//Singly List using head and tail pointer
class SinglyList {

	static class Node {
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {
			data = val;
			next = null;
		}
	}

	private Node head;
	private Node tail;

	public SinglyList() {
		head = null;
		tail = null;
	}

	public void display() {
		System.out.println("List : ");
		Node trav = head;

		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
		System.out.println("");
	}

	public void addLast(int val) {

		Node newNode = new Node(val);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			// update tail = newNode
			tail = newNode;

			// Not needed after keeping track of tail;
//			Node trav = head;
//			while (trav.next != null) {
//				trav = trav.next;

		}

	}

	public void addFirst(int val) {

		Node newNode = new Node(val);

		// if list is emoty, first new node itself is last node;
		if (head == null)
			tail = newNode;

		newNode.next = head;
		head = newNode;

	}

	public void addAtPosition(int val, int pos) {

		if (head == null || pos <= 1) {
			addFirst(val);
		} else {
			Node newNode = new Node(val);

			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
		}

	}

	public void deleteFirst() {
		if (head == null)
			throw new RuntimeException("List is EMPTY!!!");

		head = head.next;
		tail = tail.next;
	}

	public void deleteAll() {
		head = null;
		tail = null;
	}

	public void deleteAtPosition(int pos) {

		if (pos == 1) {
			deleteFirst();
		}

		if (head == null || pos < 1)
			throw new RuntimeException("Empty List or Invalid Position");

		Node trav = head, temp = null;

		for (int i = 1; i < pos; i++) {
			temp = trav;
			trav = trav.next;
		}
		temp.next = trav.next;

	}

	public void deleteLast() {

		// if list is empty(Special case)
		if (head == null)
			throw new RuntimeException("List is Empty!!!");

		// if list contains only one Node(Special Case)
		if (head.next == null) {
			head = null;
			tail = null;
		}

		else {
			Node trav = head, temp = null;
			while (trav.next != null) {
				temp = trav;
				trav = trav.next;
			}

			temp.next = null;
			tail = temp;

		}

	}

}

public class SinglyListMain {

	public static void main(String[] args) {

		int choice, pos, val;
		SinglyList list = new SinglyList();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Your Choice :");
			System.out.println(
					"0.Exit \n1.Display List \n2.AddFirst \n3.AddLast \n4.Add at Position \n5.DeleteFirst \n6.Delete at Position \n7.Delete all \n8.Delete Last ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:// Display all
				list.display();

				break;

			case 2:// Add First
				System.out.println("Enter the element to add at first node : ");
				val = sc.nextInt();
				list.addFirst(val);

				break;

			case 3:// Add Last
				System.out.println("Enter the element to add at Last position : ");
				val = sc.nextInt();
				list.addLast(val);

				break;

			case 4:// Add at position
				System.out.println("Enter the Element : ");
				val = sc.nextInt();
				System.out.println("Enter the position : ");
				pos = sc.nextInt();
				list.addAtPosition(val, pos);

				break;

			case 5:// Delete First
				try {
					list.deleteFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 6:// Delete At position
				System.out.println("Enter the position to delete the element : ");
				pos = sc.nextInt();
				list.deleteAtPosition(pos);

				break;

			case 7:// delete ALl
				list.deleteAll();

				break;
			case 8:// Delete Last
				try {
					list.deleteLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		} while (choice != 0);
		sc.close();

	}

}

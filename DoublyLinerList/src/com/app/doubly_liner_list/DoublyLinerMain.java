package com.app.doubly_liner_list;

import java.util.Scanner;

class DoublyLiner {

	static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node() {
			data = 0;
			next = null;
			prev = null;
		}

		public Node(int val) {
			data = val;
			next = null;
			prev = null;

		}
	}

	private Node head;

	public DoublyLiner() {

		head = null;
	}

	public void forwardDisplay() {
		System.out.println("Forward List => ");

		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}

	public void reverseDisplay() {
		System.out.println("Reverse List => ");

		if (head == null)
			return;

		Node trav = head;
		while (trav.next != null)
			trav = trav.next;

		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.prev;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addLast(int val) {
		Node newNode = new Node(val);

		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;

			while (trav.next != null)
				trav = trav.next;

			trav.next = newNode;
			newNode.prev = trav;
		}

	}

	public void addFirst(int val) {

		Node newNode = new Node(val);

		if (isEmpty())
			head = newNode;
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public void addAtPosition(int val, int pos) {
		Node newNode = new Node(val);

		if (head == null || pos <= 1)
			head = newNode;

		else {
			Node trav = head, temp = null;

			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null)
					break;
				trav = trav.next;

			}
			temp = trav.next;
			newNode.next = temp;
			newNode.prev = trav;
			trav.next = newNode;
			if (temp != null)
				temp.prev = newNode;
		}

	}

	public void deleteAll() {
		head = null;
	}

	public void deleteFirst() {

		if (head == null)
			throw new RuntimeException("List is Empty!!!!");
		if (head.next == null)
			head = null;
		else {
			head = head.next;
			head.prev = null;
		}
	}
	
	public void deleteAtPosition(int pos) {
		if(head == null || pos <= 1 )
			throw new RuntimeException("List is Empty OR Invalid position");
		
		if ( pos == 1)
			deleteFirst();
		
		else 
		{
			Node trav = head;
			for (int i = 1; i<pos-1; i++)
			{
				if (trav == null)
				trav = trav.next;
			}
			trav.prev.next =trav.next;
			
			if (trav.next != null)
			{
				trav.next.prev =trav.prev;
			}
		}
	}
}

public class DoublyLinerMain {

	public static void main(String[] args) {

		int choice, pos, val;
		DoublyLiner list = new DoublyLiner();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Your Choice :");
			System.out.println(
					"0.Exit \n1.Display List \n2.AddFirst \n3.AddLast \n4.Add at Position \n5.DeleteFirst \n6.Delete at Position \n7.Delete all \n8.Delete Last ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:// Display all
				try {
					list.forwardDisplay();
					list.reverseDisplay();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
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
//				try {
//					list.deleteFirst();
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//
				break;

			case 6:// Delete At position
//				System.out.println("Enter the position to delete the element : ");
//				pos = sc.nextInt();
//				try {
//					list.deleteAtPosition(pos);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}

				break;

			case 7:// delete ALl
				list.deleteAll();

				break;
			case 8:// Delete Last
//				try {
//					list.deleteLast();
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}

			}

		} while (choice != 0);
		sc.close();

	}

}

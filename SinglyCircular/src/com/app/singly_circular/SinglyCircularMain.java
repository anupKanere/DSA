package com.app.singly_circular;

import java.util.Scanner;

class SinglyCircular {

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

	public SinglyCircular() {
		head = null;
	}

	public void display() {
		System.out.println("List : ");
		if (isEmpty())// special case i.e if list is empty
			throw new RuntimeException("List is empty");

		Node trav = head;
		do {
			System.out.println(trav.data);
			trav = trav.next;
		} while (trav != head);

	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addLast(int val) {

		Node newNode = new Node(val);// create new Node

		// corner case , i.e if list is empty
		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
		}
		// normal case
		else {
			// traverse
			Node trav = head;
			while (trav.next != head) {
				trav = trav.next;
			}
			newNode.next = head;// set newNode next points to head
			trav.next = newNode;// set trav's next points to newNode

		}

	}

	public void addFirst(int val) {
		Node newNode = new Node(val);

		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
		} else {
			// traverse till last Node
			Node trav = head;
			while (trav.next != head) {
				trav = trav.next;
			}

			newNode.next = head;
			trav.next = newNode;
			head = newNode;
		}

	}

	public void addAtPosition(int val, int pos) {

		// if list is empty adding node at 1st position
		if (head == null || pos <= 1) {
			addFirst(val);
		} else {
			Node newNode = new Node(val);// create new Node
			// trav till pos - 1
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == head)
					break;
				trav = trav.next;
			}

			newNode.next = trav.next;// newNode;s next pointing to next node
			trav.next = newNode;// node before newNode pointing to newNode
		}
	}

	public void deleteFirst() {
		if (isEmpty()) {
			throw new RuntimeException("List is Empty!!!");
		}
		if (head.next == head)
			head = null;
		else {
			Node trav = head;
			while (trav.next != head)
				trav = trav.next;
			head = head.next;
			trav.next = head;
		}

	}

	public void deleteAtPosition(int pos) {
		if (pos == 1)
			deleteFirst();

		if (head == null || pos < 1)
			throw new RuntimeException("List is Empty!!!!!");

		else {
			Node temp = null, trav = head;
			for (int i = 1; i < pos; i++) {
				if (trav.next == head)
					throw new RuntimeException("Wrong position entered!!!!");

				temp = trav;
				trav = trav.next;
			}
			temp.next = trav.next;
		}

	}

	public void deleteLast() {

		if(head.next == head)
			head = null;
		
		else if(head == null)
			throw new RuntimeException("List is empty!!!");
		
		else {
			Node trav = head, temp = null;
			while (trav.next != head) {
				temp = trav;
				trav = trav.next;
			}

			temp.next = head;
			trav.next= null;

		}

	}

	public void deleteAll() {
		head.next = null;
		head = null;

	}
}

public class SinglyCircularMain {

	public static void main(String[] args) {

		int choice, pos, val;
		SinglyCircular list = new SinglyCircular();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Your Choice :");
			System.out.println(
					"0.Exit \n1.Display List \n2.AddFirst \n3.AddLast \n4.Add at Position \n5.DeleteFirst \n6.Delete at Position \n7.Delete all \n8.Delete Last ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:// Display all
				try {
					list.display();
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
				try {
					list.deleteFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 6:// Delete At position
				System.out.println("Enter the position to delete the element : ");
				pos = sc.nextInt();
				try {
					list.deleteAtPosition(pos);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

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

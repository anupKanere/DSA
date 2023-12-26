package com.app;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import com.app.BinarySearchTree.Node;

class BinarySearchTree {

	static class Node {
		int data;
		private Node right, left;

		public Node() {
			data = 0;
			right = null;
			left = null;
		}

		public Node(int val) {
			data = val;
			right = null;
			left = null;
		}
	}

	private Node root;

	public BinarySearchTree() {
		root = null;

	}

	public void add(int val) {
		Node newNode = new Node(val);

		if (root == null)
			root = newNode;
		else {

			Node trav = root;
			while (true) {
				if (val < trav.data) {
					if (trav.left != null)
						trav = trav.left;
					else {
						trav.left = newNode;
						break;
					}
				} else {
					if (trav.right != null)
						trav = trav.right;
					else {
						trav.right = newNode;
						break;
					}
				}
			}
		}
	}

	private void deleteAll(Node trav) {
		if (trav == null)
			return;
		deleteAll(trav.left);
		deleteAll(trav.right);
		trav.left = null;
		trav.right = null;
		trav = null;
	}

	public void deleteAll() {
		deleteAll(root);
		root = null;
	}

	public void preOrderNonRecursive() {
		System.out.print("pre-nonrec : ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while (trav != null || !s.empty()) {
			while (trav != null) {

				System.out.print(trav.data + " ");
				if (trav.right != null)
					s.push(trav.right);
				trav = trav.left;
			}
			if (!s.isEmpty())
				trav = s.pop();

		}
		System.out.println();
	}

	// Pre order using recursion
	public void preOrder(Node trav) {
		if (trav == null)
			return;
		System.out.print(trav.data + " ");
		preOrder(trav.left);
		preOrder(trav.right);
	}

	public void preOrder() {
		System.out.print("Pre-Order : ");
		preOrder(root);
		System.out.println();
	}

	// inorder non-recursive
	public void inOrderNonRec() {
		System.out.print("Inorde-non Rec :");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}

			if (!s.isEmpty()) {
				trav = s.pop();
				System.out.print(trav.data + " ");
				trav = trav.right;
			}
		}
	}

	public void inOrder(Node trav) {
		if (trav == null)
			return;

		inOrder(trav.left);
		System.out.print(trav.data + " ");
		inOrder(trav.right);
	}

	public void inOrder() {
		System.out.print("In-Order : ");
		inOrder(root);
		System.out.println();
	}

	public void postOrder(Node trav) {
		if (trav == null)
			return;

		postOrder(trav.left);
		postOrder(trav.right);
		System.out.print(trav.data + " ");
	}

	public void postOrder() {
		System.out.print("post-Order : ");
		postOrder(root);
		System.out.println();

	}

	// bfs
	public Node bfs(int key) {
		Queue<Node> q = new LinkedList<>();

		q.offer(root);

		while (!q.isEmpty()) {
			Node trav = q.poll();
			if (key == trav.data)
				return trav;
			if (trav.left != null)
				q.offer(trav.left);
			if (trav.right != null)
				q.offer(trav.right);

		}
		return null;
	}

}

public class BinarySearchTreeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();

		bst.add(50);
		bst.add(30);
		bst.add(10);
		bst.add(90);
		bst.add(100);
		bst.add(40);
		bst.add(70);
		bst.add(80);
		bst.add(60);
		bst.add(20);

		bst.preOrder();
		bst.preOrderNonRecursive();
		bst.postOrder();
		bst.inOrder();
		bst.inOrderNonRec();

//		bst.deleteAll();
//		bst.preOrder();

		System.out.println("Enter the key to Search : ");
		int val = sc.nextInt();
		Node tmp = bst.bfs(val);
		if (tmp != null) {
		    System.out.println("Node found with value: " + tmp.data);
		} else {
		    System.out.println("Node not found.");
		}

	}
}

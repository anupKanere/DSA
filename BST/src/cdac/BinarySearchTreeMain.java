package cdac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import cdac.BinarySearchTree.Node;

class BinarySearchTree {

	static class Node {
		private int data;
		private Node right, left;

		public Node() {
			setData(0);
			right = null;
			left = null;
		}

		public Node(int val) {
			setData(val);
			right = null;
			left = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
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
				if (val < trav.getData()) {
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

				System.out.print(trav.getData() + " ");
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
		System.out.print(trav.getData() + " ");
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
				System.out.print(trav.getData() + " ");
				trav = trav.right;

			}
		}
		System.out.println();
	}

	public void inOrder(Node trav) {
		if (trav == null)
			return;

		inOrder(trav.left);
		System.out.print(trav.getData() + " ");
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
		System.out.print(trav.getData() + " ");
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
			if (key == trav.getData())
				return trav;
			if (trav.left != null)
				q.offer(trav.left);
			if (trav.right != null)
				q.offer(trav.right);

		}
		return null;
	}

	public int height(Node trav) {
		if (trav == null)
			return -1;
		int hl = height(trav.left);
		int hr = height(trav.right);
		int max = hl > hr ? hl : hr;
		return max + 1;

	}

	public int height() {
		return height(root);
	}

	public Node binarySearch(int key) {
		Node trav = root;

		while (trav != null) {
			if (key == trav.data)
				return trav;
			if (key < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		return null;
	}

	public Node[] binarySearchParent(int key) {
		Node trav = root;
		Node parent = null;

		while (trav != null) {
			if (key == trav.data)
				return new Node[] { trav, parent };

			parent = trav;
			if (key < trav.data)
				trav = trav.left;
			else
				trav = trav.right;

		}
		return new Node[] { null, null };
	}

	// delete node;
	public void delete(int val) {
		Node trav, parent;
		Node[] arr = binarySearchParent(val);
		trav = arr[0];
		parent = arr[1];

		if (trav == null)
			throw new RuntimeException("Node not found !!!");

		if (trav.left != null && trav.right != null) {
			parent = trav;
			Node succ = trav.right;
			while (trav.left != null) {
				parent = succ;
				succ = succ.left;
			}
			trav.data = succ.data;

			trav = succ;
		}

		if (trav.left == null) {
			if (trav == root)
				root = trav.right;
			else if (trav == parent.left)
				parent.left = trav.right;
			else
				parent.right = trav.right;
		}

		if (trav.right == null) {
			if (trav == root)
				root = trav.left;
			else if (trav == parent.right)
				parent.right = trav.left;
			else
				parent.right = trav.left;
		}
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
//		bst.preOrderNonRecursive();
		bst.postOrder();
		bst.inOrder();
//		bst.inOrderNonRec();

//		bst.deleteAll();
//		bst.preOrder();

		/*
		 * // BFS System.out.println("Enter the key to Search : "); int val =
		 * sc.nextInt(); Node tmp = bst.bfs(val); if (tmp == null)
		 * System.out.println("Key not found : "); else {
		 * System.out.println("BFS key found : " + tmp.getData()); }
		 */

		// Height of tree;
		System.out.println("height : " + bst.height());

		/*
		 * // Search element in tree by using binary search
		 * System.out.println("Enter the key to Search : "); int val = sc.nextInt();
		 * Node tmp = bst.binarySearch(val); if (tmp == null)
		 * System.out.println("Key not found : "); else {
		 * System.out.println(" key found using Binary search : " + tmp.getData()); }
		 */

		/*
		 * // Search element in tree by using binary search with parent
		 * System.out.println("Enter the key to Search : "); int val = sc.nextInt();
		 * Node arr[] = bst.binarySearchParent(val); if (arr[0] == null)
		 * System.out.println("Key not found : "); else if (arr[1] == null)
		 * System.out.println("Key found : " + arr[0].getData() + " with parent => " +
		 * arr[1]); else { System.out.println(" key found: " + arr[0].getData() +
		 * " with parent => " + arr[1].getData()); }
		 */

		// checking deletion of node; bst.inOrder();

		try {
			System.out.println("Enter the element to delete : ");
			int val = sc.nextInt();
			bst.delete(val);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		bst.inOrder();

	}
}

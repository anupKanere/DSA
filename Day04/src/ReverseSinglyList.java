
public class ReverseSinglyList {

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

	public ReverseSinglyList() {
		head = null;
	}

	public void addLast(int val) {

		Node newNode = new Node(val);
		if (head == null)
			head = newNode;
		else {
			Node trav = head;
			while (trav.next != null)
				trav = trav.next;
			trav.next = newNode;
		}
	}

	public void display() {
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}

	public void reverse() {
		Node oldHead = head;
		head = null;

		while (oldHead != null) {

			// delete 1st from old list
			Node temp = oldHead;
			oldHead = oldHead.next;

			// addfirst in new List
			temp.next = head;
			head = temp;
		}
	}

	private Node recReverse(Node h) {

		if (h.next == null) {
			head = h;
			return h;
		}
		Node t = recReverse(h.next);
		t.next = h;
		h.next = null;
		return h;
	}

	public void recReverse() {
		if (head != null)
			recReverse(head);
	}

	private void revDisplay(Node h) {
		if (h == null) {
			return;
		}
		revDisplay(h.next);
		System.out.println(h.data);
	}

	public void revDisplay() {
		revDisplay(head);
	}

	public int findMid() {
		Node fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		return slow.data;
	}

	public static void main(String[] args) {

		ReverseSinglyList list = new ReverseSinglyList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
//		list.addLast(111);

		System.out.println("Before Reverse =>");
		list.display();
		list.revDisplay();

//		list.reverse();
//		list.recReverse();
		
//		System.out.println("After Reverse =>");
//		list.display();
		
		System.out.println(" mid element = > " +list.findMid());
	}

}

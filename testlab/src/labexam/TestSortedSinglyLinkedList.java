package labexam;

public class TestSortedSinglyLinkedList {

	public static void main(String[] args) {
		SortedLinkedList list = new SortedLinkedList();
		list.add(5);
		list.add(2);
		list.add(8);
		list.add(1);
		list.add(5);

		System.out.println("Original List:");
		Node current = list.getHead();
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();

		System.out.println("Size: " + list.size());
		list.removeALL(5);
		System.out.println("List after removing 5:");
		current = list.getHead();
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();

		System.out.println("Reversed List:");
		list.displayReverse();
	}
}

package labexam;

public class SortedLinkedList {
    private Node head;
    private int size;

    public SortedLinkedList() {
        setHead(null);
        size = 0;
    }

    public void add(int X) {
        Node newNode = new Node(X);
        if (getHead() == null || X < getHead().data) {
            newNode.next = getHead();
            setHead(newNode);
        } else {
            Node current = getHead();
            while (current.next != null && X > current.next.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void removeALL(int X) {
        while (getHead() != null && getHead().data == X) {
            setHead(getHead().next);
            size--;
        }

        if (getHead() == null) {
            return;
        }

        Node current = getHead();
        while (current.next != null) {
            if (current.next.data == X) {
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }
    }

    public void displayReverse() {
        reversePrint(getHead());
    }

    private void reversePrint(Node node) {
        if (node == null) {
            return;
        }
        reversePrint(node.next);
        System.out.print(node.data + " ");
    }

    public int size() {
        return size;
    }

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}
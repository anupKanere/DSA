
public class SinglyList 
{
	private Node head;
	private Node tail;

	public SinglyList() 
	{
		head = null;
		tail = null;
	}

	// Add at Front
	public void addAtFront(int element) 
	{
		// Make space for new element , newNode
		Node newNode;
		newNode = new Node(element, null);// create new instance of the Node class and assign it to the variable newNode

		// if we add constructor in node then we dont have to write below 2 steps every
		// time while creating new node so its better to write constructor
//		newNode.data= element;
//		newNode.next= null;

		if (head == null) 
		{
			head = newNode;
			tail = newNode;
			return;
		}
		else 
		{
			newNode.next = head;// Here, we assign the value of the head variable to the next reference of the
								// newNode
			head = newNode;// we update the value of the head variable to be the newNode This means that we
							// make the newNode the new head of the linked list. By updating the head,
		}
	}

	// Add at Rear
	public void addAtRear(int element) 
	{
		// Make space for new element , newNode and store data in new node
		Node newNode = new Node(element, null);

		// if list is empty i.e then add the node at the front
		if (head == null)
		{
			head = newNode;
			tail = newNode;
			return;
		}

		// if list is not empty
		// set tails's next to newNode
		tail.next = newNode;
		tail = newNode;

	}
	
	//traversal
	public int getCount()
	{
		int count = 0;
		Node current;
		
		current = head;
		while (current != null)
		{
			++count;
			current = current.next;
		}
		
		return count;
		
	}
	
	public int[] getElements()
	{
		//allocate memory for array that get count will return 
		int elements[] = new int[getCount()];
		int i= 0;
		Node current;
		
		current = head;
		while (current != null)
		{
			elements[i]=current.data;
			++i;
			current = current.next;
		}
		return elements;
		
	}
}









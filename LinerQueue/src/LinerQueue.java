import java.util.Scanner;

class LinearQ
{
	private int []arr;
	private int front,rear;
	
	public LinearQ(int size) {
		arr = new int [size];
		front = -1;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return rear == arr.length-1;
	}
	
	public void push (int val)
	{
		if(isFull())
			throw new RuntimeException("Queue is Full!!!");
		else {
		rear ++;
		arr[rear] = val;
		}
	}
	
	public void pop() {
		
		if(isEmpty())
			throw new RuntimeException("Queue is Empty");
		front++;
	}
	
	public int peek() {
		if(isEmpty())
			throw new RuntimeException("Queue is Empty");
		return arr[front + 1];
	}

	public void display() {
		for (int i : arr)
			System.out.println(i);
		
	}
}
public class LinerQueue {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearQ q = new LinearQ(6);
		int choice, val;
		do {
			System.out.println("\n0. Exit\n1. Push\n2. Pop\n3. Peek\n4.Display queue \nEnter choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: // push
				try {
					System.out.print("Enter value to push: ");
					val = sc.nextInt();
					q.push(val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: // pop
				try {
					val = q.peek();
					q.pop();
					System.out.println("Popped: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: // peek
				try {
					val = q.peek();
					System.out.println("Peek: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			case 4://display
					q.display();
				break;
			}
		}while(choice != 0);
		sc.close();
	}
}



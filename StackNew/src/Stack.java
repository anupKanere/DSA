import java.util.Arrays;
import java.util.Scanner;

public class Stack {

	private int arr[];
	private int top;

	public Stack(int size) {
		arr = new int[size];
		top = -1;

	}

	public void push(int val) {
		if (isFull())
			throw new RuntimeException("Stack Overflow");

		top++;
		arr[top] = val;
	}

	public void pop() {
		if (isEmpty())
			System.out.println("Stack Underflow");
		else {
			top--;
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty!!!");

		}
		return arr[top];
	}
	
	public void display() {
		for (int i : arr)
			System.out.println(i);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack(6);
		int choice, val;
		do {
			System.out.println("\n0. Exit\n1. Push\n2. Pop\n3. Peek\n4.Display Stack \nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // push
				try {
					System.out.print("Enter value to push: ");
					val = sc.nextInt();
					s.push(val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: // pop
				try {
					val = s.peek();
					s.pop();
					System.out.println("Popped: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: // peek
				try {
					val = s.peek();
					System.out.println("Peek: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4://display
				s.display();
				
			}
		} while (choice != 0);
		sc.close();
	}

}

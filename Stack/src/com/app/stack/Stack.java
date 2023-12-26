package com.app.stack;

public class Stack {

	private int stack[];
	private int top;
	private int capacity;

	Stack() {
		top = -1;
		capacity = 15;
		stack = new int[capacity];
	}

	public boolean isEmpty() {
		return top == -1;

	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public int push(int key) {
		if (isFull()) {
			System.out.println("Stack is full");
		}
		return stack[++top] = key;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack underflow");
		}
		return stack[top--];
	}

	public int peek() {
		return stack[top];

	}
	
	public void display()
	{
		for (int i : stack)
			System.out.println(i);
		
	}

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(34);
		st.push(25);
		st.push(8);
		st.push(65);

		System.out.println(st.isEmpty());
		System.out.println(st.isFull());
		System.out.println(st.capacity);
		System.out.println(st.peek());
		System.out.println(st.pop());
		
		st.display();

	}

}

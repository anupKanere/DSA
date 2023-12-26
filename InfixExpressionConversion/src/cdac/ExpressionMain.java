package cdac;

import java.util.Stack;


public class ExpressionMain {
	
	//PostFix Evaluation
	private static int calc(int a, int b, char operator) {
		switch (operator) {
		case '$':
			return (int) Math.pow(a, b);
		case '*':
			return a * b;
		case '/':
			return a / b;
		case '%':
			return a % b;
		case '+':
			return a + b;
		case '-':
			return a - b;
		}
		return 0;
	}
	
	public static int postfixEva(String post) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < post.length(); i++) {
			char sym = post.charAt(i);
			if (Character.isDigit(sym)) {
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			} else {
				int b = s.pop();
				int a = s.pop();
				int c = calc(a, b, sym);
				s.push(c);
			}
		}
		return s.pop();
	}

	//Infix to Postfix conversion
	public static String infixToPostfix(String infix) {
		StringBuilder post = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < infix.length(); i++) {
			char sym = infix.charAt(i);

			if (Character.isLetterOrDigit(sym))
				post.append(sym);

			else if (sym == '(')
				stack.push(sym);

			else if (sym == ')') {
				while (stack.peek() != '(')
					post.append(stack.pop());
				stack.pop();
			} else {
				while (!stack.isEmpty() && prio(stack.peek()) >= prio(sym))
					post.append(stack.pop());

				stack.push(sym);
			}
		}
		while (!stack.isEmpty())
			post.append(stack.pop());
		return post.toString();
	}
	
	//Infix to Prefix Expression
	public static String infixToPrefix(String infix) {
		StringBuilder post = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		for (int i = infix.length()-1; i >= 0; i--) {
			char sym = infix.charAt(i);

			if (Character.isLetterOrDigit(sym))
				post.append(sym);

			else if (sym == ')')
				stack.push(sym);

			else if (sym == '(') {
				while (stack.peek() != ')')
					post.append(stack.pop());
				stack.pop();
			} else {
				while (!stack.isEmpty() && prio(stack.peek()) > prio(sym))
					post.append(stack.pop());

				stack.push(sym);
			}
		}
		while (!stack.isEmpty())
			post.append(stack.pop());
		return post.reverse().toString();
	}

	private static int prio(Character operator) {
		switch (operator) {
		case '$':
			return 15;
		case '*':
			return 10;
		case '%':
			return 10;
		case '/':
			return 10;
		case '+':
			return 5;
		case '-':
			return 5;
		}

		return 0;
	}

	public static void main(String[] args) {
		String infix = "5+9-4*(8-6/2)+1$(7-3)";
		
		String postfix = infixToPostfix(infix);
		System.out.println("postfix Exp => " + postfix);
		System.out.println("Result => " + postfixEva(postfix));
	
		String prefix = infixToPrefix(infix);
		System.out.println("Prefix Exp =>" + prefix);

	}

}

package cdac;

import java.util.Stack;

public class PrefixEvaluation {
	public static int prefixEva(String pre) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = pre.length() - 1; i >= 0; i--) {
			char sym = pre.charAt(i);
			if (Character.isLetterOrDigit(sym)) {
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			} else {
				int a = s.pop();
				int b = s.pop();
				int c = calc(a, b, sym);
				s.push(c);
			}
		}
		return s.pop();
	}

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

	public static void main(String[] args) {
		String prefix = "+-+59*4-8/62$1-73";
		int result = prefixEva(prefix);
		System.out.println("Result : " + result);

	}

}

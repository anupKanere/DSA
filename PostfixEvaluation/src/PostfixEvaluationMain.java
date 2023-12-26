import java.util.Stack;

public class PostfixEvaluationMain {
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
		String postfix = "59+4862/-*-173-$+";
		int result = postfixEva(postfix);
		System.out.println("Result : " + result);

	}

}

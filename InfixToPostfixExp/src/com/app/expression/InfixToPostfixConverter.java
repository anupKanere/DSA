package com.app.expression;

import java.util.Stack;

public class InfixToPostfixConverter {

	public static int precedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;

		case '^':
			return 3;

		}
		return -1;

	}

	// to check character is operator or not
	public static boolean isOperator(char character) {
		return precedence(character) > 0;
	}

	// checking if character is letter or digit by usin character class
	public static boolean isOperand(char character) {
		return Character.isLetterOrDigit(character);
	}

	// method for converting infix to postfix
	public static String convertTOPostfix(String infixExpression) {
		StringBuilder postfixExpression = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infixExpression.length(); i++) {
			char character = infixExpression.charAt(i);

			// if character is operand then append it to postfix expression
			if (isOperand(character)) {
				postfixExpression.append(character);
			}

			// if character is opening brace then push it into stack
			else if (character == '(') {
				stack.push(character);
			}

			// if characte is closing brace then remove elements from stack
			// untill STACK is empty and stack element is not having corresponding
			// opening brace
			else if (character == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfixExpression.append(stack.pop());
				}

				// if stack is not empty and if there is no any opening braces
				// for corresponding closing braces then this case is miss-matched
				// parenthesis. It will return NULL.
				if (!stack.isEmpty() && stack.peek() != '(') {
					return null;
				}
				stack.pop();
			}

			/*
			 * If the character is an operator, it is compared with the operator at the top
			 * of the stack. If the current operator has lower or equal precedence, the
			 * operators from the stack are popped and appended to the postfixExpression
			 * until a lower precedence operator is encountered or the stack becomes empty.
			 * Then, the current operator is pushed onto the stack.
			 */
			else if (isOperator(character)) {
				while (!stack.isEmpty() && precedence(character) <= precedence(stack.peek())) {
					postfixExpression.append(stack.pop());
				}
				stack.push(character);

			}

		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				return null;
			}
			postfixExpression.append(stack.pop());

		}
		return postfixExpression.toString();
	}

	public static void main(String[] args) {
		String infixExpression = "x^y/(5*z)+2";
		String postfixExpression = convertTOPostfix(infixExpression);
		System.out.println("INFIX EXPRESSION : " + infixExpression);
		System.out.println("POSTFIX EXPRESSION : " + postfixExpression);

	}

}

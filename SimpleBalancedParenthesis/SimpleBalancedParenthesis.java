/*********************************************************************
 * Implementing simple balanced parenthesis program
 *
 * @author Pratik Chaudhari
 * @since 01/07/2021
 *********************************************************************/
package SimpleBalancedParenthesis;

public class SimpleBalancedParenthesis {
	public static void main(String[] args) {
		SimpleBalancedParenthesis sbp = new SimpleBalancedParenthesis();
		String expr = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		String expr1 = "[{()}]";
		sbp.checkIsBalanced(expr);
		sbp.checkIsBalanced(expr1);
	}

	/**
	 * To check if the string is balanced or not
	 * 
	 * @param expr string expression
	 */
	private void checkIsBalanced(String expr) {
		if (areBracketsBalanced(expr)) {
			System.out.println(expr + " is Balanced ");
		} else {
			System.out.println(expr + " is Not Balanced ");
		}
	}

	/**
	 * to push open parenthesis “(“ and pop closed parenthesis “)”. At the End of
	 * the Expression if the Stack is Empty then the Arithmetic Expression is
	 * Balanced.
	 */
	private boolean areBracketsBalanced(String expr) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
				case ')' -> {
					check = stack.pop();
					if (check == '{' || check == '[')
						return false;
				}
				case '}' -> {
					check = stack.pop();
					if (check == '(' || check == '[')
						return false;
				}
				case ']' -> {
					check = stack.pop();
					if (check == '(' || check == '{')
						return false;
				}
			}
		}
		return (stack.isEmpty());
	}

}

package stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * SymbolMatch
 * <p>
 * 验证符号表达式，左右括号是否匹配，如((5-3)*8-2)
 *
 * @author: xMustang
 * @since: 1.0
 */
public class SymbolMatch {
	public static void main(String[] args) {
		String input = "((5-3)*8-2)";
//		String input = "((5-3)*8-2))";
//		String input = "(((5-3)*8-2)";

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				// 该栈中只存储'('，而且如果栈为空，再pop时，pop会调用peek，peek在栈为空时会抛异常。
				try {
					stack.pop();
				} catch (EmptyStackException e) {
					System.out.println("该表达式" + input + "：左右括号不匹配");
					throw e;
				}
			}
		}
		if (stack.empty()) {
			System.out.println("该表达式" + input + "：左右括号匹配");
		} else {
			System.out.println("该表达式" + input + "：左右括号不匹配");
		}
	}
}

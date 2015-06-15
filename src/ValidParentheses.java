import java.util.*;


public class ValidParentheses {
	public boolean isValid(String s) {
		
		Deque<Character> leftParentheseStack = new ArrayDeque<Character>();
		
		Set<Character> leftParentheseSet = new HashSet<Character>();
		leftParentheseSet.add('[');
		leftParentheseSet.add('(');
		leftParentheseSet.add('{');
		
		Set<Character> rightParentheseSet = new HashSet<Character>();
		
		rightParentheseSet.add(']');
		rightParentheseSet.add(')');
		rightParentheseSet.add('}');
		
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (leftParentheseSet.contains(c)) {
				leftParentheseStack.push(c);
				continue;
			}
			if (rightParentheseSet.contains(c)) {
				if (leftParentheseStack.size() == 0) {
					return false;
				}
				char t = leftParentheseStack.pop().charValue();
				if ((t == '[' && c != ']') || (t == '(' && c != ')') || (t == '{') && c != '}' ) {
					return false;
				} else {
					continue;
				}
			}
		}
		
		if (leftParentheseStack.size() != 0) {
			return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		ValidParentheses p = new ValidParentheses();
		System.out.println(p.isValid("()"));
	}
	
}

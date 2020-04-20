import java.util.*;

class Solution {
	public static boolean isValid(String s) {
		Stack<Character> workingStack = new Stack<Character>();
		HashMap<Character, Character> match = new HashMap<>();
		List<Character> open = new ArrayList<>();
		List<Character> closed = new ArrayList<>();
		open.add('(');
		open.add('{');
		open.add('[');
		closed.add(')');
		closed.add('}');
		closed.add(']');
		match.put('(', ')');
		match.put('{', '}');
		match.put('[', ']');
		match.put(')', '(');
		match.put('}', '{');
		match.put(']', '[');

		for (int i = 0; i < s.length(); i++) {
			if (open.contains(s.charAt(i))) {
				workingStack.push(s.charAt(i));
			} else if (closed.contains(s.charAt(i)) && !workingStack.isEmpty()) {
				if(workingStack.peek() == match.get(s.charAt(i))) workingStack.pop();
				else return false;
			} else return false;
		}
		if (workingStack.isEmpty())
			return true;
		return false;
	}
}
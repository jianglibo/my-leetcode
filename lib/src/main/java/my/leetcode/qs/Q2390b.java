package my.leetcode.qs;

import java.util.Stack;

public class Q2390b {
	public String removeStars(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) { // leet**code
			if (s.charAt(i) == '*') {
				if (!st.isEmpty())
					st.pop();
			} else {
				st.push(s.charAt(i));
			}
		}
		char[] cc = new char[st.size()];
		for (int i = 0; i < st.size(); i++) {
			cc[i] = st.get(i);
		}
		return new String(cc);
	}
}

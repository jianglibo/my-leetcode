package my.leetcode.qs;

public class Q2390c {
	public String removeStars(String s) {
		StringBuilder sb = new StringBuilder(s);

		int idx;

		while ((idx = sb.indexOf("*")) != -1) {
			sb.deleteCharAt(idx);
			if (idx > 0) {
				sb.deleteCharAt(idx - 1);
			}

		}

		return sb.toString();
	}
}

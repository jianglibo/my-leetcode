package my.leetcode.qs;

public class Q2390a {
	public String removeStars(String s) {
		StringBuilder sb = new StringBuilder();
		int stars = 0;
		for (int i = 0; i < s.length(); i++) { // leet**code
			if (s.charAt(i) == '*') {
				stars++;
			} else {
				if (stars > 0) {
					deleteSome(sb, stars);
					stars = 0;
				}
				sb.append(s.charAt(i));
			}
		}
		if (stars > 0) {
			deleteSome(sb, stars);
		}
		return sb.toString();
	}

	void deleteSome(StringBuilder sb, int stars) {
		int len = sb.length(); // 4
		int toDelete = stars > len ? len : stars; // 2
		sb.delete(len - toDelete, len);
	}


}

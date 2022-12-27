package my.leetcode.qs;

public class Q1234 {
	public int balancedString(String s) {
		int[] count = new int[128];
		int n = s.length(), res = n, i = 0, k = n / 4;
		for (int j = 0; j < n; ++j) {
			++count[s.charAt(j)];
		}
		for (int j = 0; j < n; ++j) {
			--count[s.charAt(j)];
			while (i < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k
					&& count['R'] <= k) {
				res = Math.min(res, j - i + 1);
				++count[s.charAt(i++)];
			}
		}
		return res;
	}
	// int average = s.length() / 4;
	// Map<Integer, Integer> counts = new ConcurrentHashMap<>();
	// for (int i = 0; i < s.length(); i++) {
	// counts.merge((int) s.charAt(i), 1, (t, u) -> Integer.sum(t, u));
	// }



	// for (Integer c : counts.keySet()) {
	// counts.computeIfPresent(c, (k, ov) -> ov > average ? ov - average : null);
	// }

	// if (counts.isEmpty())
	// return 0; // balanced

	// Map<Integer, Integer> diffs = new ConcurrentHashMap<>();
	// diffs.putAll(counts);
	// diffs.replaceAll((k, v) -> 0);

	// // try to find one solution from index 0;
	// int l = 0, r = 0;
	// int minimal = Integer.MAX_VALUE;

	// for (; r < s.length(); r++) { // ERQQ
	// int cr = s.charAt(r);

	// diffs.computeIfPresent(cr, (k, ov) -> ++ov);
	// boolean found = true;
	// for (Integer k : diffs.keySet()) {
	// if (diffs.get(k) < counts.get(k)) { // when r == 2
	// found = false;
	// }
	// }
	// if (found) {
	// for (; l < r; l++) { // l == 2
	// int cl = s.charAt(l);
	// if (diffs.containsKey(cl)) {
	// break;
	// }
	// }
	// minimal = Math.min(minimal, r - l + 1);
	// break;
	// }
	// }

	// // rolling windows
	// for (; r < s.length();r++) {
	// int cr = s.charAt(r);

	// diffs.computeIfPresent(cr, (k, ov) -> ++ov); // add right character to the
	// // diffs.
	// // try to remove the left
	// for (;l<r;l++) {
	// int cl = s.charAt(l);
	// if (counts.containsKey(cl)) {
	// if (diffs.get(cl) > counts.get(cl)) {
	// // it's safe to remove.
	// diffs.computeIfPresent(cl, (k, ov) -> --ov);
	// } else {
	// break;
	// }
	// }
	// }
	// if (r > l) {
	// minimal = Math.min(minimal, r - l + 1);
	// }

	// }

	// return minimal;
	// }
}

package my.leetcode.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import my.leetcode.Tutil;

@Slf4j
public class Q1231Test {
	@Test
	void t3() {
		int left = 1, right = 10;
		while(left <= right) {
			// int mid = (left + right + 1) / 2;
			int mid = left + (right - left) / 2;
			log.info("current mid: {}", mid);
			// right = right - 1;
			left = mid;
		}
	}

	@Test
	void t1() {
		Q1231 classUnderTest = new Q1231();
		JSONObject jo = Tutil.loadJsonFromClassPath("/Q1231.json");
		assertEquals(1, classUnderTest.maximizeSweetness(Tutil.getIntAry(jo, "data"),
				jo.getInt("p1")));
	}

	public int maximizeSweetness(int[] sweetness, int k) {
		int n = sweetness.length;
		int m = k + 1;
		int[][] memo = new int[n + 1][m + 1];
		int[] prefixSum = new int[n + 1];
		int lowEnd = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			prefixSum[i + 1] = prefixSum[i] + sweetness[i];
			lowEnd = Math.min(lowEnd, sweetness[i]);
		}
		int highEnd = prefixSum[n];

		for (; lowEnd < highEnd;) {
			int guessed = lowEnd + (highEnd - lowEnd) / 2;
			int cuts = 0;
			// all the segments must be greater than the guessed.
			for (int p1 = 0, p2 = 1; p2 <= n;) {
				if (prefixSum[p2] - prefixSum[p1] >= guessed) {
					p1 = p2++;
					if (p1 < n)
						++cuts;
				} else {
					++p2;
				}
			}
			if (cuts < k) { // the guessed is too high;
				highEnd = guessed - 1;
			} else {
				lowEnd = guessed + 1;
			}

		}
		return lowEnd;
	}



}

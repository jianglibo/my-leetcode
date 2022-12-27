package my.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	int smallestDiff(int leftSum, int[] nums) {
		int b = 0, t = nums.length - 1, ans = leftSum;
		for (int p = b; b < t;) {
			if (t - b == 1) {
				ans = Math.min(ans, Math.abs(leftSum - nums[p + 1]));
				break;
			}
			p = b + (t - b) / 2;
			int diff = leftSum - nums[p];
			if (diff < 0) {
				t = p;
			} else {
				b = p;
			}
			ans = Math.min(ans, Math.abs(diff));
		}
		return ans;
	}

	@Test
	void t() {

		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 16};
		int n = 12;


		assertEquals(1, smallestDiff(n, nums));

	}
}

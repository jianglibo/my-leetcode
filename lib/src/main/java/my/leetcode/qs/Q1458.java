package my.leetcode.qs;

public class Q1458 {

	int findMax(int... values) {
		assert values.length > 1 : "at least 2 values are required to compare.";
		int max = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		return max;
	}

	public int maxDotProduct(int[] nums1, int[] nums2) {

		int MIN = -1000 * 1000 - 1, leni = nums1.length, lenj = nums2.length;

		int[][] dp = new int[leni + 1][lenj + 1];
		for (int i = 0; i < leni; i++) {
			dp[i][0] = MIN;
		}
		for (int j = 0; j < lenj; j++) {
			dp[0][j] = MIN;
		}

		for (int i = 1; i < leni + 1; i++) {
			for (int j = 1; j < lenj + 1; j++) {
				dp[i][j] = findMax(nums1[i - 1] * nums2[j - 1], dp[i - 1][j],
						dp[i][j - 1],
						dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
			}

		}

		return dp[leni][lenj];
	}
}

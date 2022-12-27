package my.leetcode.qs;

public class Q1231 {
	public int maximizeSweetness(int[] sweetness, int k) {
		int n = sweetness.length;
		int m = k + 1;
		int[][] memo = new int[n + 1][m + 1];
		int[] prefixSum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			prefixSum[i + 1] = prefixSum[i] + sweetness[i];
		}


		for (int subArrays = 1; subArrays <= m; subArrays++) {
			for (int curIdx = 0; curIdx < n; curIdx++) {
				if (subArrays == 1) {
					memo[curIdx][subArrays] = prefixSum[n] - prefixSum[curIdx];
				} else {
					int maxInMinimums = Integer.MIN_VALUE;
					for (int i = curIdx; i <= n - subArrays; i++) {
						int curSum = prefixSum[i + 1] - prefixSum[curIdx];
						int minInCuts = Math.min(curSum,
								memo[i + 1][subArrays - 1]);
						maxInMinimums = Math.max(maxInMinimums, minInCuts);
					}
					memo[curIdx][subArrays] = maxInMinimums;
				}
			}
		}

		return memo[0][m];
	}
}

package my.leetcode;

import java.util.List;

public class Fabonacci {
	
	public int recurssion(List<Integer> values, int n) {
		int v;
		if (n == 0) {
			v =  0;
		} else if (n == 1) {
			v =  1;
		} else {
			v = recurssion(values, n - 1) + recurssion(values, n - 2);
		}
		values.add(v);
		return v;
	}

	public int[] dp(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<= n;i++) {
			dp[i] = dp[i - 1] + dp[i -2];
		}
		return dp;
	}

}

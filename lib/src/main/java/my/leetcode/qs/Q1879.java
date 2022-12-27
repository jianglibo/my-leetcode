package my.leetcode.qs;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import my.leetcode.Permutation;

public class Q1879 {
	public AtomicInteger ai = new AtomicInteger();

	int dfs(int[] dp, int[] a, int[] b, int i, int mask) {
		if (i >= a.length) {
			return 0;
		}
		if (dp[mask] == Integer.MAX_VALUE)
			for (int j = 0; j < b.length; ++j)
				if ((mask & (1 << j)) == 0)
					dp[mask] = Math.min(dp[mask], (a[i] ^ b[j])
							+ dfs(dp, a, b, i + 1, mask + (1 << j)));
		return dpReturn(dp, mask);
	}

	private int dpReturn(int[] dp, int mask) {
		ai.getAndIncrement();
		return dp[mask];
	}

	public int minimumXORSum(int[] nums1, int[] nums2) {
		int dp[] = new int[1 << nums2.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		return dfs(dp, nums1, nums2, 0, 0);
	}

	public void permutation(int[] b) {

		Permutation.recusiveSwap(Arrays.stream(b).boxed().toArray(Integer[]::new), 0, 'c',
				ai, false);
	}

	public int minimumXORSum1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][1<<n];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for(int i1 = 0; i1 < n; i1++)
            dp[0][1<<i1] = nums1[i1] ^ nums2[0];
        
        for(int i2 = 1; i2 < n; i2++)
        {
            Arrays.fill(dp[i2], Integer.MAX_VALUE);
            for(int mask = 0; mask < (1<<n); mask++)
            {
                if(dp[i2-1][mask] == Integer.MAX_VALUE) continue;
                for(int i1 = 0; i1 < n; i1++)
                {
                    if((mask & (1<<i1)) == 0)
                        dp[i2][mask|(1<<i1)] = Math.min(dp[i2][mask|(1<<i1)], dp[i2-1][mask]+(nums1[i1]^nums2[i2]));
                }
            }
        }
        return dp[n-1][(1<<n)-1];
    }
}

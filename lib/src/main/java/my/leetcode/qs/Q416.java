package my.leetcode.qs;

public class Q416 {
	private Boolean[][] memo;

	public boolean canPartition1(int[] nums) {
		if (nums.length == 0)
			return false;
		int totalSum = 0;
		// find sum of all array elements
		for (int num : nums) {
			totalSum += num;
		}
		// if totalSum is odd, it cannot be partitioned into equal sum subset
		if (totalSum % 2 != 0)
			return false;
		int subSetSum = totalSum / 2;
		boolean dp[] = new boolean[subSetSum + 1];
		dp[0] = true;
		for (int curr : nums) {
			for (int j = subSetSum; j >= curr; j--) {
				dp[j] |= dp[j - curr];
			}
		}
		return dp[subSetSum];
	}

	boolean partition(int[] nums, int idx, int sum) {
		if (sum == 0)
			return true;

		if (sum < 0 || idx == nums.length) {
			return false;
		}

		if (memo[idx][sum] != null)
			return memo[idx][sum];

		boolean res = partition(nums, idx + 1, sum - nums[idx])
				|| partition(nums, idx + 1, sum);
		memo[idx][sum] = res;
		return res;
	}

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		memo = new Boolean[nums.length + 1][sum / 2 + 1];
		return partition(nums, 0, sum / 2);
	}


	public static void main(String[] args) {
		// int[] nums = {1, 5, 11, 5};
		int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 99, 97};
		Q416 q = new Q416();
		// boolean b = q.canPartition(nums);
		boolean b = q.canPartition1(nums);
		assert b;
	}
}

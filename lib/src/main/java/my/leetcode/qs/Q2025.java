package my.leetcode.qs;

import java.util.HashMap;
import java.util.Map;

public class Q2025 {

	public int waysToPartition(int[] nums, int k) {

		int len = nums.length;
		long[] df = new long[len - 1];

		long[] dp = new long[len];
		dp[0] = nums[0];
		for (int i = 1; i < len; i++) {
			dp[i] = dp[i - 1] + nums[i];
		}

		Map<Long, Integer> rightmap = new HashMap<>();
		Map<Long, Integer> leftmap = new HashMap<>();
		for (int i = 0; i < len - 1; i++) {
			long left = dp[i];
			long right = dp[len - 1] - left;
			df[i] = left - right;
			rightmap.merge(left - right, 1, (old, one) -> old + one);
		}


		// long res = IntStream.of(df).filter(i -> i == 0).count();
		int res = rightmap.getOrDefault(0L, 0);

		for (int i = 0; i < len; i++) {
			long dv = k - nums[i];
			int count = leftmap.getOrDefault(dv, 0) + rightmap.getOrDefault(-dv, 0);
			// for (int j = 0; j < df.length; j++) {
			// if ((j < i && dv == df[j]) || (j >= i && -dv == df[j])) {
			// count++;
			// }
			// }
			if (i < len - 1) {
				rightmap.computeIfPresent(df[i], (_k, old) -> old > 0 ? --old : old);
				leftmap.merge(df[i], 1, (old, one) -> ++old);
			}
			res = Math.max(res, count);
		}
		return Math.toIntExact(res);
	}

	public static void main(String[] args) {
		Q2025 q = new Q2025();
		// int[] nums = {1,2,3,4};
		// int k = 5;
		// int[] nums = {2,0,0,0};

		// int[] nums = {0, 0, 0, 30827, 0, 0};
		// int k = 0;
		// String text = null;
		// try (InputStream in = q.getClass().getResourceAsStream("Q2025.json")) {
		// 	text = new String(in.readAllBytes(), StandardCharsets.UTF_8);	
		// } catch (Exception e) {
		// }
		// JSONObject jo = new JSONObject(text);
		// JSONArray ja = jo.getJSONArray("nums");
		
		// int[] nums = new int[ja.length()];
		// for(int i=0;i<ja.length();i++) {
		// 	nums[i] = ja.getInt(i);
		// }
		// int k = jo.getInt("k");

		// int[] nums = {0,-4732,0,0,0};
		// int k = -4732;
		int[] nums = {0,0,0};
		int k = 1;

		int res = q.waysToPartition(nums, k);
		System.out.println(res);;

	}

}

package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class SegmentTreeTest {

	@Test
	void t() {
		int[] nums = {1, 3, 5, 7, 9, 11};
		SegmentTree st = new SegmentTree(nums, nums.length);
		int mid = st.getSum(0, 0, 0);

		PriorityQueue<int[]> pq = new PriorityQueue<>(5);

		Set<int[]> s = new HashSet<>();
		s.add(new int[] {1, 2});
		s.add(new int[] {1, 2});
		assertThat(s).hasSize(2);
		String t = "";
		Map<String, String> m = new HashMap<>();
		m.values().stream().allMatch(null);
		// PriorityQueue<int[]> pq = new PriorityQueue<>(5, (a,b) ->
		// Integer.compare(a[1],b[1]));
		// PriorityQueue<Integer>[] pqs = new PriorityQueue<Integer>[]{null, new
		// PriorityQueue<>()};
		List<Integer> li = new ArrayList<>();
		int[] example1 = li.stream().mapToInt(i -> i).toArray();
		int[] ii = li.stream().mapToInt(i -> i).toArray();
		// li.stream().mapToInt(null)

		// Map<Character, Integer> charsMap = new HashMap<>();
		// for(int i=0;i<s.length();i++) {
		// char c = s.charAt(i);
		// charsMap.merge(c, 1, (ov, one) -> ++ov);
		// }

		// int[] ary = charsMap.values().stream().mapToInt().toArray(int[]::new);
		Arrays.stream(new int[]{1}).max().getAsInt();

	}





}
